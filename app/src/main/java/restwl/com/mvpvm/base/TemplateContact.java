package restwl.com.mvpvm.base;

import restwl.com.mvpvm.base.presenter.MVPPresenter;
import restwl.com.mvpvm.base.ui.MVPView;
import restwl.com.mvpvm.base.viewmodel.MVPViewModel;

public interface TemplateContact {

    interface View extends MVPView {
    }

    interface Presenter extends MVPPresenter<View> {
    }

    interface ViewModel extends MVPViewModel<View, Presenter> {

    }
}
