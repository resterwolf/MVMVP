package restwl.com.mvmvp.base.viewmodel;

import androidx.annotation.NonNull;
import restwl.com.mvmvp.base.presenter.MVPFragmentPresenter;
import restwl.com.mvmvp.base.ui.MVPView;

public interface MVPFragmentViewModel<View extends MVPView,
    FragmentPresenter extends MVPFragmentPresenter<View>> {

    FragmentPresenter getFragmentPresenter(int id);

    void setFragmentPresenter(int id, @NonNull FragmentPresenter presenter);

}
