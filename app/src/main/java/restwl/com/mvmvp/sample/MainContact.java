package restwl.com.mvmvp.sample;

import restwl.com.mvmvp.base.presenter.MVPFragmentPresenter;
import restwl.com.mvmvp.base.presenter.MVPPresenter;
import restwl.com.mvmvp.base.ui.MVPView;
import restwl.com.mvmvp.base.viewmodel.MVPFragmentViewModel;
import restwl.com.mvmvp.base.viewmodel.MVPViewModel;

public interface MainContact {

    interface View extends MVPView {
        void showToastMessage(String message);
    }

    interface Presenter extends MVPPresenter<View> {
        void onButtonClicked();
    }

    interface ViewModel extends MVPViewModel<View, Presenter> {

    }

    // Main fragment
    interface FragmentView extends MVPView {
        void showToastMessage(String message);
    }

    interface FragmentPresenter extends MVPFragmentPresenter<FragmentView> {
        void onButtonClicked();
    }

    interface FragmentViewModel extends MVPFragmentViewModel<FragmentView, FragmentPresenter> {

    }
}
