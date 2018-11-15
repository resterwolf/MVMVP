package restwl.com.mvmvp.base.presenter;

import io.reactivex.disposables.Disposable;
import restwl.com.mvmvp.base.ui.MVPView;

public interface MVPFragmentPresenter<View extends MVPView> {

    void onFragmentViewCreated(View view);

    void onFragmentViewDestroyed();

    boolean isViewAttached();

    void onPresenterCreate();

    void onPresenterDestroy();

    void subscribeOnPresenterDestroyDisposable(Disposable disposable);

}
