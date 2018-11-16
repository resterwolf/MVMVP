package restwl.com.mvmvp.base.presenter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import restwl.com.mvmvp.base.Interactor.MVPInteractor;
import restwl.com.mvmvp.base.navigation.MVPNavigationManager;
import restwl.com.mvmvp.base.ui.MVPView;

public abstract class BasePresenter<View extends MVPView, NavigationManager extends MVPNavigationManager,
    Interactor extends MVPInteractor>
    implements MVPPresenter<View>, MVPFragmentPresenter<View> {

    private View mView;
    private NavigationManager mNavigationManager;
    private Interactor mInteractor;
    private CompositeDisposable mDisposables = new CompositeDisposable();

    public BasePresenter(@NonNull NavigationManager navigationManager,
                         @NonNull Interactor interactor) {
        mNavigationManager = navigationManager;
        mInteractor = interactor;
    }

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
        mDisposables = null;
        mNavigationManager = null;
        mView = null;
    }

    @Override
    public void subscribeOnPresenterDestroyDisposable(Disposable disposable) {
        mDisposables.add(disposable);
    }

    public @Nullable
    View getView() {
        return mView;
    }

    @NonNull
    protected NavigationManager getNavigationManager() {
        return mNavigationManager;
    }

    @NonNull
    protected Interactor getInteractor() {
        return mInteractor;
    }
}
