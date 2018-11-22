package restwl.com.mvmvp.base.presenter;

import androidx.annotation.NonNull;
import io.reactivex.disposables.Disposable;
import restwl.com.mvmvp.base.ui.MvvmpView;

public interface MvvmpPresenter<View extends MvvmpView> {

    void onViewCreated(@NonNull View view);

    void onViewDestroyed();

    boolean isViewAttached();

    void onPresenterCreate();

    void onPresenterDestroy();

    void addDisposableOnDestroy(@NonNull Disposable disposable);

}
