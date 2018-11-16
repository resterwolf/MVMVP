package restwl.com.mvmvp.sample.main;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import io.reactivex.disposables.Disposable;
import restwl.com.mvmvp.Utils;
import restwl.com.mvmvp.base.presenter.BasePresenter;
import restwl.com.mvmvp.sample.data.Service;
import restwl.com.mvmvp.sample.main.fragments.FirstFragment;

public class MainPresenter extends BasePresenter<MainContract.View, MainContract.NavigationManager,
    MainContract.MainInteractor>
    implements MainContract.Presenter,
    LifecycleObserver {

    public MainPresenter(MainContract.NavigationManager navigationManager, MainContract.MainInteractor interactor) {
        super(navigationManager, interactor);
    }

    @Override
    public void onViewCreated(MainContract.View view) {
        super.onViewCreated(view);
        view.getLifecycle().addObserver(this);
    }

    @Override
    public void onButtonClicked() {
        Utils.showDebugMessage("OnCLick");
        Disposable disposable = getInteractor().loadData().subscribe(s -> {
            getView().showToastMessage(s);
            if (isViewAttached()) {

            }
        }, error -> {
            getView().showToastMessage(error.getMessage());
        });
        subscribeOnPresenterDestroyDisposable(disposable);
    }

    // Subscribe on resume event
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void foo() {

    }

}
