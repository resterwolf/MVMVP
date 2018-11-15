package restwl.com.mvmvp.sample;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import restwl.com.mvmvp.Utils;
import restwl.com.mvmvp.base.presenter.BasePresenter;
import restwl.com.mvmvp.sample.data.Service;

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter,
    LifecycleObserver {

    private Service mService = new Service();

    @Override
    public void onViewCreated(MainContract.View view) {
        super.onViewCreated(view);
        view.getLifecycle().addObserver(this);
    }

    @Override
    public void onButtonClicked() {
        mService.loadData().observe(getView(), getView()::showToastMessage);
    }

    // Subscribe on resume event
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void foo() {
        Utils.showDebugMessage("Fooo");
    }

}
