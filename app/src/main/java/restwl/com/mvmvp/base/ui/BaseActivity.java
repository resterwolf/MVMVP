package restwl.com.mvmvp.base.ui;

import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import restwl.com.mvmvp.base.presenter.MVPPresenter;
import restwl.com.mvmvp.base.viewmodel.MVPViewModel;

public abstract class BaseActivity<View extends MVPView, Presenter extends MVPPresenter<View>,
    ViewModel extends MVPViewModel> extends AppCompatActivity implements MVPView {

    private ViewModel mViewModel;
    private Presenter mPresenter;

    public abstract @LayoutRes
    int getLayoutResId();

    public abstract @NonNull
    ViewModel createViewModel();

    public abstract @NonNull
    Presenter createPresenter();

    public abstract @NonNull
    View getMVPView();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getLayoutResId() != 0) {
            setContentView(getLayoutResId());
        }
        if (mViewModel == null) {
            mViewModel = createViewModel();
        }

        mPresenter = mViewModel.getPresenter();
        if (mPresenter == null) {
            mPresenter = createPresenter();
            mViewModel.setPresenter(mPresenter);
        }
        mPresenter.onViewCreated(getMVPView());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onViewDestroyed();
    }

    public Presenter getPresenter() {
        return mPresenter;
    }

    public ViewModel getViewModel() {
        return mViewModel;
    }
}
