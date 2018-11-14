package restwl.com.mvpvm.base.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import restwl.com.mvpvm.base.presenter.MVPPresenter;
import restwl.com.mvpvm.base.ui.MVPView;

public class BaseMVPViewModel<View extends MVPView, Presenter extends MVPPresenter<View>>
    extends AndroidViewModel implements MVPViewModel<View, Presenter> {

    private Presenter mPresenter;

    public BaseMVPViewModel(@NonNull Application application) {
        super(application);
    }

    @Override
    public void setPresenter(@NonNull Presenter presenter) {
        if (mPresenter == null) {
            mPresenter = presenter;
            mPresenter.onPresenterCreate();
        }
    }

    @NonNull
    @Override
    public Presenter getPresenter() {
        return mPresenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        mPresenter.onPresenterDestroy();
        mPresenter = null;
    }
}
