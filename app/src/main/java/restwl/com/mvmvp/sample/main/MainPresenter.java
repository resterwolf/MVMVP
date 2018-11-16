package restwl.com.mvmvp.sample.main;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import restwl.com.mvmvp.base.presenter.BasePresenter;
import restwl.com.mvmvp.sample.data.Service;
import restwl.com.mvmvp.sample.main.fragments.FirstFragment;

public class MainPresenter extends BasePresenter<MainContract.View, MainContract.NavigationManager>
    implements MainContract.Presenter,
    LifecycleObserver {

    FirstFragment fragment = new FirstFragment();

    private Service mService = new Service();

    public MainPresenter(MainContract.NavigationManager navigationManager) {
        super(navigationManager);
    }

    @Override
    public void onViewCreated(MainContract.View view) {
        super.onViewCreated(view);
        view.getLifecycle().addObserver(this);
    }

    @Override
    public void onButtonClicked() {

        getNavigationManager().startSecondActivity();
//        getView().showFragment(fragment, FirstFragment.TAG);
//        if(fragment.getPresenter() == null) {
//
//            Utils.showDebugMessage("Null");
//        } else {
//            fragment.getPresenter().onButtonClicked();
//            Utils.showDebugMessage(" no nuul");
//        }
    }

    // Subscribe on resume event
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void foo() {

    }


}
