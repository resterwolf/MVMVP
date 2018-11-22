package restwl.com.mvmvp.sample.main;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import io.reactivex.Observable;
import restwl.com.mvmvp.base.Interactor.MVPInteractor;
import restwl.com.mvmvp.base.presenter.MvvmpPresenter;
import restwl.com.mvmvp.base.ui.MvvmpView;
import restwl.com.mvmvp.base.viewmodel.MvvmpViewModel;

public interface MainContract {

    interface View extends MvvmpView {
        void showToastMessage(String message);

        void showFragment(Fragment fragment, String tag);

        void showPogress(boolean show);

    }

    interface Presenter extends MvvmpPresenter<View> {
        void onButtonClicked();
    }

    interface ViewModel extends MvvmpViewModel<Presenter> {

    }

    interface MainInteractor extends MVPInteractor {
        Observable<String> loadDataRx();
        LiveData<String> loadData();
    }

    // Main fragment
    interface FirstFragmentView extends MvvmpView {
        void showToastMessage(String message);
    }

    interface FirstFragmentPresenter extends MvvmpPresenter<FirstFragmentView> {
        void onButtonClicked();
    }

    // Main fragment
    interface SecondFragmentView extends MvvmpView {
    }

    interface SecondFragmentPresenter extends MvvmpPresenter<SecondFragmentView> {
    }

}
