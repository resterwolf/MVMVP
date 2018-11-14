package restwl.com.mvpvm.sample;

import java.util.concurrent.TimeUnit;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import restwl.com.mvpvm.base.presenter.BasePresenter;

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
        subscribeOnDestroyDisposable(disposable);
    }
}
