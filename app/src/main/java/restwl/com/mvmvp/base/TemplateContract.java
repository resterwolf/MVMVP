package restwl.com.mvmvp.base;

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

    interface ViewModel extends MVPViewModel<View, Presenter> {

    }


    interface FragmentView extends MVPView {

    }

    interface FragmentPresenter extends MVPFragmentPresenter<FragmentView> {

    }

    interface FragmentViewModel extends MVPFragmentViewModel<FragmentView, FragmentPresenter> {

    }

}
