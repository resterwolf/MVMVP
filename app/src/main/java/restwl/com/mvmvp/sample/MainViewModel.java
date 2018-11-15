package restwl.com.mvmvp.sample;

import android.app.Application;

import androidx.annotation.NonNull;
import restwl.com.mvmvp.base.viewmodel.BaseMVPViewModel;

public class MainViewModel extends BaseMVPViewModel<MainContract.View, MainContract.FragmentView,
    MainContract.Presenter, MainContract.FragmentPresenter> implements MainContract.ViewModel, MainContract.FragmentViewModel {

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

}
