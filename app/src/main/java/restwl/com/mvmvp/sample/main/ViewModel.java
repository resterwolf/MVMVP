package restwl.com.mvmvp.sample.main;

import android.app.Application;

import androidx.annotation.NonNull;
import restwl.com.mvmvp.base.viewmodel.BaseMVPViewModel;
import restwl.com.mvmvp.sample.main.MainContract;

public class ViewModel extends BaseMVPViewModel implements MainContract.ViewModel,
    MainContract.FragmentViewModel {

    public ViewModel(@NonNull Application application) {
        super(application);
    }

}
