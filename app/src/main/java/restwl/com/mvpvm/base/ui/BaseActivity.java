package restwl.com.mvpvm.base.ui;

import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import restwl.com.mvpvm.base.presenter.MVPPresenter;
import restwl.com.mvpvm.base.viewmodel.MVPViewModel;

public abstract class BaseActivity<View extends MVPView, Presenter extends MVPPresenter<View>,
    ViewModel extends MVPViewModel<View, Presenter>> extends AppCompatActivity implements MVPView {

    private ViewModel mViewModel;

    public abstract @LayoutRes
    int getLayoutResId();

    public abstract @NonNull
    ViewModel createViewModel();

    public abstract @NonNull
    Presenter createPresenter();

    public abstract View getMVPView();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getLayoutResId() != 0) {
            setContentView(getLayoutResId());
        }
        mViewModel = createViewModel();
        mViewModel.setPresenter(createPresenter());
        mViewModel.getPresenter().onViewCreated(getMVPView());
        mViewModel.getPresenter().attachLifecycle(getLifecycle());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mViewModel.getPresenter().onViewDestroyed();
    }

    public Presenter getPresenter() {
        return mViewModel.getPresenter();
    }

    public ViewModel getViewModel() {
        return mViewModel;
    }
}
