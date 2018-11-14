package restwl.com.mvmvp.sample;

import android.app.Application;

import androidx.annotation.NonNull;
import restwl.com.mvmvp.base.viewmodel.BaseMVPViewModel;

public class MainViewModel extends BaseMVPViewModel<MainContact.View, MainContact.FragmentView,
    MainContact.Presenter, MainContact.FragmentPresenter> implements MainContact.ViewModel, MainContact.FragmentViewModel {

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

}
