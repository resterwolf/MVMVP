package restwl.com.mvpvm.base.presenter;

import androidx.lifecycle.Lifecycle;
import io.reactivex.disposables.Disposable;
import restwl.com.mvpvm.base.ui.MVPView;

public interface MVPPresenter<View extends MVPView> {

    void attachLifecycle(Lifecycle lifecycle);

    void onViewCreated(View view);

    void onViewDestroyed();

    boolean isViewAttached();

    void onPresenterCreate();

    void onPresenterDestroy();

    void subscribeDisposableOnDestroy(Disposable disposable);

}
