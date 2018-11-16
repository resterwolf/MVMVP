package restwl.com.mvmvp.sample.main;

import androidx.fragment.app.Fragment;
import restwl.com.mvmvp.base.navigation.MVPNavigationManager;
import restwl.com.mvmvp.base.presenter.MVPFragmentPresenter;
import restwl.com.mvmvp.base.presenter.MVPPresenter;
import restwl.com.mvmvp.base.ui.MVPView;
import restwl.com.mvmvp.base.viewmodel.MVPFragmentViewModel;
import restwl.com.mvmvp.base.viewmodel.MVPViewModel;

public interface MainContract {

    interface View extends MVPView {
        void showToastMessage(String message);
        void showFragment(Fragment fragment, String tag);
    }

    interface Presenter extends MVPPresenter<View> {
        void onButtonClicked();
    }

    interface ViewModel extends MVPViewModel {

    }

    interface FragmentViewModel extends MVPFragmentViewModel {

    }

    interface NavigationManager extends MVPNavigationManager {
        void startSecondActivity();
    }


    // Main fragment
    interface FirstFragmentView extends MVPView {
        void showToastMessage(String message);
    }

    interface FirstFragmentPresenter extends MVPFragmentPresenter<FirstFragmentView> {
        void onButtonClicked();
    }

    // Main fragment
    interface SecondFragmentView extends MVPView {
    }

    interface SecondFragmentPresenter extends MVPFragmentPresenter<SecondFragmentView> {
    }

}
