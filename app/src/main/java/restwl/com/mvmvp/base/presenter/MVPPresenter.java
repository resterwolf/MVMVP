package restwl.com.mvmvp.base.presenter;

import androidx.lifecycle.Lifecycle;
import io.reactivex.disposables.Disposable;
import restwl.com.mvmvp.base.ui.MVPView;

public interface MVPPresenter<View extends MVPView> {

    void onViewCreated(View view);

    void onViewDestroyed();

    void attachLifecycle(Lifecycle lifecycle);

    boolean isViewAttached();

    void onPresenterCreate();

    void onPresenterDestroy();

    void subscribeOnPresenterDestroyDisposable(Disposable disposable);

}
