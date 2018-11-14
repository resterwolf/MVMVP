package restwl.com.mvpvm.sample;

import android.app.Application;

import androidx.annotation.NonNull;
import restwl.com.mvpvm.base.viewmodel.BaseMVPViewModel;

public class MainViewModel extends BaseMVPViewModel<MainContact.View,MainContact.Presenter> implements MainContact.ViewModel {

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

}
