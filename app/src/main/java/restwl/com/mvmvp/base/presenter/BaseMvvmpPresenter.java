package restwl.com.mvmvp.base.presenter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import restwl.com.mvmvp.base.ui.MvvmpView;

public abstract class BaseMvvmpPresenter<View extends MvvmpView>
    implements MvvmpPresenter<View> {

    private View mView;
    private CompositeDisposable mDisposables = new CompositeDisposable();

    @Override
    public void onViewCreated(@NonNull View view) {
        mView = view;
    }

    @Override
    public void onViewDestroyed() {
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
        mView = null;
        mDisposables.clear();
        mDisposables = null;
    }

    @Override
    public void addDisposableOnDestroy(@NonNull Disposable disposable) {
        mDisposables.add(disposable);
    }

    public @Nullable
    View getView() {
        return mView;
    }

}