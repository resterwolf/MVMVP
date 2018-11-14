package restwl.com.mvmvp.sample;

import java.util.concurrent.TimeUnit;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import restwl.com.mvmvp.Utils;
import restwl.com.mvmvp.base.presenter.BasePresenter;

public class MainPresenter extends BasePresenter<MainContact.View> implements MainContact.Presenter {

    @Override
    public void onButtonClicked() {

        Disposable disposable = Flowable.<String>create(emitter -> {
            TimeUnit.SECONDS.sleep(3);
            String str = "Hello world!!!";
            emitter.onNext(str);
        }, BackpressureStrategy.BUFFER)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(s -> {
                if (isViewAttached()) {
                    getView().showToastMessage(s);
                }
            });
        subscribeOnPresenterDestroyDisposable(disposable);
    }

    // Subscribe on resume event
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void foo() {
        Utils.showDebugMessage("Fooo");
    }

}
