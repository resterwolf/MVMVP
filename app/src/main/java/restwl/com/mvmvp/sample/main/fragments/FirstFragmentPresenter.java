package restwl.com.mvmvp.sample.main.fragments;

import java.util.concurrent.TimeUnit;

import androidx.annotation.NonNull;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import restwl.com.mvmvp.base.presenter.BaseMvvmpPresenter;
import restwl.com.mvmvp.sample.main.MainContract;

public class FirstFragmentPresenter extends BaseMvvmpPresenter<MainContract.FirstFragmentView>
    implements MainContract.FirstFragmentPresenter {

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
        addDisposableOnDestroy(disposable);
    }
}
