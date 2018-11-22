package restwl.com.mvmvp.base.viewmodel;

import androidx.annotation.NonNull;
import restwl.com.mvmvp.base.presenter.MvvmpPresenter;
import restwl.com.mvmvp.base.ui.BaseMvvmpFragment;
import restwl.com.mvmvp.base.ui.MvvmpView;

public interface MvvmpViewModel<Presenter extends MvvmpPresenter<? extends MvvmpView>> {

    Presenter getActivityPresenter();

    void setActivityPresenter(@NonNull Presenter presenter);

    MvvmpPresenter<? extends MvvmpView> getFragmentPresenter(
        @NonNull Class<? extends BaseMvvmpFragment> key);

    void setFragmentPresenter(@NonNull Class<? extends BaseMvvmpFragment> key,
                              @NonNull MvvmpPresenter<? extends MvvmpView> presenter);

}
