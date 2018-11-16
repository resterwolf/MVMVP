package restwl.com.mvmvp.base;

import restwl.com.mvmvp.base.navigation.MVPNavigationManager;
import restwl.com.mvmvp.base.presenter.MVPFragmentPresenter;
import restwl.com.mvmvp.base.presenter.MVPPresenter;
import restwl.com.mvmvp.base.ui.MVPView;
import restwl.com.mvmvp.base.viewmodel.MVPFragmentViewModel;
import restwl.com.mvmvp.base.viewmodel.MVPViewModel;

public interface TemplateContract {

    interface View extends MVPView {
    }

    interface Presenter extends MVPPresenter<View> {
    }


    interface ViewModel extends MVPViewModel {

    }

    interface FragmentViewModel extends MVPFragmentViewModel {

    }

    interface NavigationManager extends MVPNavigationManager {

    }

    // Fragment A
    interface FragmentViewA extends MVPView {

    }

    interface FragmentPresenterA extends MVPFragmentPresenter<FragmentViewA> {

    }

    // Fragment B
    interface FragmentViewB extends MVPView {

    }

    interface FragmentPresenterB extends MVPFragmentPresenter<FragmentViewB> {

    }



}
