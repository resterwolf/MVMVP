package restwl.com.mvmvp.sample.main.fragments;

import androidx.annotation.NonNull;
import restwl.com.mvmvp.base.presenter.BasePresenter;
import restwl.com.mvmvp.sample.main.MainContract;

public class SecondFragmentPresenter extends BasePresenter<MainContract.SecondFragmentView,
    MainContract.NavigationManager, MainContract.MainInteractor>
    implements MainContract.SecondFragmentPresenter {


    public SecondFragmentPresenter(@NonNull MainContract.NavigationManager navigationManager,
                                   @NonNull MainContract.MainInteractor interactor) {
        super(navigationManager, interactor);
    }
}
