package restwl.com.mvpvm.sample;

import restwl.com.mvpvm.base.presenter.MVPPresenter;
import restwl.com.mvpvm.base.ui.MVPView;
import restwl.com.mvpvm.base.viewmodel.MVPViewModel;

public interface MainContact {

    interface View extends MVPView {
        void showToastMessage(String message);
    }

    interface Presenter extends MVPPresenter<View> {
        void onButtonClicked();
    }

    interface ViewModel extends MVPViewModel<View, Presenter> {

    }
}
