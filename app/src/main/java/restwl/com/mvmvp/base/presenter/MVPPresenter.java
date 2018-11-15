package restwl.com.mvmvp.base.presenter;

import io.reactivex.disposables.Disposable;
import restwl.com.mvmvp.base.ui.MVPView;

public interface MVPPresenter<View extends MVPView> {

    void onViewCreated(View view);

    void onViewDestroyed();

    boolean isViewAttached();

    void onPresenterCreate();

    void onPresenterDestroy();

    void subscribeOnPresenterDestroyDisposable(Disposable disposable);

}
