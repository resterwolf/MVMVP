package restwl.com.mvmvp.sample.main.fragments;

import restwl.com.mvmvp.base.presenter.BasePresenter;
import restwl.com.mvmvp.sample.main.MainContract;

public class SecondFragmentPresenter extends BasePresenter<MainContract.SecondFragmentView, MainContract.NavigationManager>
    implements MainContract.SecondFragmentPresenter {

    public SecondFragmentPresenter(MainContract.NavigationManager navigationManager) {
        super(navigationManager);
    }

}
