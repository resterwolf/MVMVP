package restwl.com.mvmvp.base.viewmodel;

import androidx.annotation.NonNull;
import restwl.com.mvmvp.base.presenter.MVPFragmentPresenter;
import restwl.com.mvmvp.base.ui.MVPView;

public interface MVPFragmentViewModel {

    <V extends MVPView, P extends MVPFragmentPresenter<V>> P getFragmentPresenter(@NonNull String tag);

    void setFragmentPresenter(@NonNull String tag, @NonNull MVPFragmentPresenter<? extends MVPView> presenter);

}
