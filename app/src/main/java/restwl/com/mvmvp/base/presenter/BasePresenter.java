package restwl.com.mvmvp.base.presenter;

import androidx.annotation.Nullable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import restwl.com.mvmvp.base.ui.MVPView;

public class BasePresenter<View extends MVPView> implements MVPPresenter<View>,
    MVPFragmentPresenter<View> {

    private View mView;
    private CompositeDisposable mDisposables = new CompositeDisposable();

    @Override
    public void onViewCreated(View view) {
        mView = view;
    }

    @Override
    public void onViewDestroyed() {
        mView = null;
    }

    @Override
    public void onFragmentViewCreated(View view) {
        mView = view;
    }

    @Override
    public void onFragmentViewDestroyed() {
        mView = null;
    }

    @Override
    public boolean isViewAttached() {
        return mView != null;
    }

    @Override
    public void onPresenterCreate() {

    }

    @Override
    public void onPresenterDestroy() {
        mDisposables.clear();
    }

    @Override
    public void subscribeOnPresenterDestroyDisposable(Disposable disposable) {
        mDisposables.add(disposable);
    }

    public @Nullable
    View getView() {
        return mView;
    }

}
