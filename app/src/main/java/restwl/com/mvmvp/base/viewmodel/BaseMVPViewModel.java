package restwl.com.mvmvp.base.viewmodel;

import android.app.Application;

import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import restwl.com.mvmvp.base.presenter.MVPFragmentPresenter;
import restwl.com.mvmvp.base.presenter.MVPPresenter;
import restwl.com.mvmvp.base.ui.MVPView;

public class BaseMVPViewModel<View extends MVPView, FragmentView extends MVPView,
    Presenter extends MVPPresenter<View>, FragmentPresenter extends MVPFragmentPresenter<FragmentView>>
    extends AndroidViewModel implements MVPViewModel<View, Presenter>,
    MVPFragmentViewModel<FragmentView, FragmentPresenter> {

    private Presenter mPresenter;
    private Map<Integer, FragmentPresenter> mFragmentPresenterMap
        = new HashMap<>();

    public BaseMVPViewModel(@NonNull Application application) {
        super(application);
    }

    @Override
    public void setPresenter(@NonNull Presenter presenter) {
        mPresenter = presenter;
        mPresenter.onPresenterCreate();
    }

    @Override
    public Presenter getPresenter() {
        return mPresenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        mPresenter.onPresenterDestroy();
        mPresenter = null;
        for (FragmentPresenter fr : mFragmentPresenterMap.values()) {
            fr.onPresenterDestroy();
        }
        mFragmentPresenterMap.clear();
        mFragmentPresenterMap = null;
    }

    @Override
    public void setFragmentPresenter(int id, @NonNull FragmentPresenter presenter) {
        mFragmentPresenterMap.put(id, presenter);
        presenter.onPresenterCreate();
    }

    @Override
    public FragmentPresenter getFragmentPresenter(int id) {
        return mFragmentPresenterMap.get(id);
    }

}
