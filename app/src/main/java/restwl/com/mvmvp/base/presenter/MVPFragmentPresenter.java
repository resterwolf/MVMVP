package restwl.com.mvmvp.base.presenter;

import androidx.lifecycle.Lifecycle;
import io.reactivex.disposables.Disposable;
import restwl.com.mvmvp.base.ui.MVPView;

public interface MVPFragmentPresenter<View extends MVPView> {

    void onFragmentViewCreated(View view);

    void onFragmentViewDestroyed();

    void attachLifecycle(Lifecycle lifecycle);

    boolean isViewAttached();

    void onPresenterCreate();

    void onPresenterDestroy();

    void subscribeOnPresenterDestroyDisposable(Disposable disposable);

}
