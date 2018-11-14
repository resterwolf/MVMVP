package restwl.com.mvmvp.base.viewmodel;

import androidx.annotation.NonNull;
import restwl.com.mvmvp.base.presenter.MVPPresenter;
import restwl.com.mvmvp.base.ui.MVPView;

public interface MVPViewModel<View extends MVPView, Presenter extends MVPPresenter<View>> {


    Presenter getPresenter();

    void setPresenter(@NonNull Presenter presenter);

}
