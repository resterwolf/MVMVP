package restwl.com.mvmvp.sample.main;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.MutableLiveData;
import restwl.com.mvmvp.Utils;
import restwl.com.mvmvp.base.presenter.BaseMvvmpPresenter;

public class MainPresenter extends BaseMvvmpPresenter<MainContract.View>
    implements MainContract.Presenter,
    LifecycleObserver {

    private MutableLiveData<Runnable> mShowProgressLivaData = new MutableLiveData<>();

    @Override
    public void onViewCreated(@NonNull MainContract.View view) {
        super.onViewCreated(view);
        mShowProgressLivaData.observe(view, this::executeRunnable);
    }

    private void executeRunnable(Runnable runnable) {
        if (runnable != null) {
            runnable.run();
        }
    }

    @Override
    public void onButtonClicked() {
        if (mShowProgressLivaData.getValue() == null) {
            Runnable runnable = () -> {
                getView().showPogress(true);
                getView().showToastMessage("Show progress bar");
            };
            mShowProgressLivaData.setValue(runnable);
        } else {
            Runnable runnable = () -> {
                getView().showPogress(false);
                getView().showToastMessage("Hide progress bar");
            };
            mShowProgressLivaData.setValue(runnable);
            mShowProgressLivaData.setValue(null);
        }
    }

}
