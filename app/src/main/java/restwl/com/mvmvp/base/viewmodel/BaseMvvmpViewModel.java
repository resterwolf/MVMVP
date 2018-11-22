package restwl.com.mvmvp.base.viewmodel;

import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import restwl.com.mvmvp.base.presenter.MvvmpPresenter;
import restwl.com.mvmvp.base.ui.BaseMvvmpFragment;
import restwl.com.mvmvp.base.ui.MvvmpView;

public abstract class BaseMvvmpViewModel<Presenter extends MvvmpPresenter<? extends MvvmpView>>
    extends ViewModel implements MvvmpViewModel<Presenter> {

    private Presenter mActivityPresenter;
    private Map<Class<? extends BaseMvvmpFragment>, MvvmpPresenter<? extends MvvmpView>>
        mFragmentPresenterMap = new HashMap<>();

    @Override
    public void setActivityPresenter(@NonNull Presenter presenter) {
        mActivityPresenter = presenter;
        presenter.onPresenterCreate();
    }

    @Override
    public Presenter getActivityPresenter() {
        return mActivityPresenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (mActivityPresenter != null) {
            mActivityPresenter.onPresenterDestroy();
            mActivityPresenter = null;
        }
        for (MvvmpPresenter fragmentPresenter : mFragmentPresenterMap.values()) {
            fragmentPresenter.onPresenterDestroy();
        }
        mFragmentPresenterMap.clear();
        mFragmentPresenterMap = null;
    }

    @Override
    public MvvmpPresenter<? extends MvvmpView>
    getFragmentPresenter(@NonNull Class<? extends BaseMvvmpFragment> key) {
        return mFragmentPresenterMap.get(key);
    }

    @Override
    public void setFragmentPresenter(@NonNull Class<? extends BaseMvvmpFragment> key,
                                     @NonNull MvvmpPresenter<? extends MvvmpView> presenter) {
        mFragmentPresenterMap.put(key, presenter);
        presenter.onPresenterCreate();
    }
}
