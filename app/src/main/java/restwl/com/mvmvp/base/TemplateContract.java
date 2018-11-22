package restwl.com.mvmvp.base;

import restwl.com.mvmvp.base.presenter.MvvmpPresenter;
import restwl.com.mvmvp.base.ui.MvvmpView;
import restwl.com.mvmvp.base.viewmodel.MvvmpViewModel;

public interface TemplateContract {

    interface View extends MvvmpView {
    }

    interface Presenter extends MvvmpPresenter<View> {
    }

    interface ViewModel extends MvvmpViewModel<Presenter> {

    }

    interface FragmentAView extends MvvmpView {

    }

    interface FragmentAPresenter extends MvvmpPresenter<FragmentAView> {

    }

    interface FragmentBView extends MvvmpView {

    }

    interface FragmentBPresenter extends MvvmpPresenter<FragmentBView> {

    }

}
