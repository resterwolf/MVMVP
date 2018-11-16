package restwl.com.mvmvp.base.viewmodel;

import android.app.Application;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import restwl.com.mvmvp.base.presenter.MVPFragmentPresenter;
import restwl.com.mvmvp.base.presenter.MVPPresenter;
import restwl.com.mvmvp.base.ui.MVPView;

public abstract class BaseMVPViewModel extends AndroidViewModel implements MVPViewModel, MVPFragmentViewModel {

    private MVPPresenter mPresenter;
    private Map<String, MVPFragmentPresenter> mFragmentPresenterMap
        = new LinkedHashMap<>();

    public BaseMVPViewModel(@NonNull Application application) {
        super(application);
    }

    @Override
    public void setPresenter(@NonNull MVPPresenter<? extends MVPView> presenter) {
        mPresenter = presenter;
        mPresenter.onPresenterCreate();
    }

    @Override
    public <V extends MVPView, P extends MVPPresenter<V>> P getPresenter() {
        return (P) mPresenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        mPresenter.onPresenterDestroy();
        mPresenter = null;
        for (MVPFragmentPresenter fr : mFragmentPresenterMap.values()) {
            fr.onPresenterDestroy();
        }
        mFragmentPresenterMap.clear();
        mFragmentPresenterMap = null;
    }

    @Override
    public void setFragmentPresenter(@NonNull String tag,
                                     @NonNull MVPFragmentPresenter<? extends MVPView> presenter) {
        mFragmentPresenterMap.put(tag, presenter);
        presenter.onPresenterCreate();
    }

    @Override
    public <V extends MVPView, P extends MVPFragmentPresenter<V>> P getFragmentPresenter(@NonNull String tag) {
        return (P) mFragmentPresenterMap.get(tag);
    }
}
