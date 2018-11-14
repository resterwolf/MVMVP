package restwl.com.mvpvm.base.viewmodel;

import androidx.annotation.NonNull;
import restwl.com.mvpvm.base.presenter.MVPPresenter;
import restwl.com.mvpvm.base.ui.MVPView;

public interface MVPViewModel<View extends MVPView, Presenter extends MVPPresenter<View>> {

    @NonNull
    Presenter getPresenter();

    void setPresenter(@NonNull Presenter presenter);

}
