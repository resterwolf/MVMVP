package restwl.com.mvmvp.sample.main.fragments;

import java.util.concurrent.TimeUnit;

import androidx.annotation.NonNull;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import restwl.com.mvmvp.base.presenter.BasePresenter;
import restwl.com.mvmvp.sample.main.MainContract;

public class FirstFragmentPresenter extends BasePresenter<MainContract.FirstFragmentView,
    MainContract.NavigationManager, MainContract.MainInteractor> implements MainContract.FirstFragmentPresenter {

    public FirstFragmentPresenter(@NonNull MainContract.NavigationManager navigationManager,
                                  @NonNull MainContract.MainInteractor interactor) {
        super(navigationManager, interactor);
    }

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
}
