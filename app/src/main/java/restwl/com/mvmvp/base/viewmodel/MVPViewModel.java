package restwl.com.mvmvp.base.viewmodel;

import androidx.annotation.NonNull;
import restwl.com.mvmvp.base.presenter.MVPFragmentPresenter;
import restwl.com.mvmvp.base.presenter.MVPPresenter;
import restwl.com.mvmvp.base.ui.MVPView;

public interface MVPViewModel {

    <V extends MVPView, P extends MVPPresenter<V>> P getPresenter();

    void setPresenter(@NonNull MVPPresenter<? extends MVPView> presenter);

}
