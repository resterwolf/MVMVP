package restwl.com.mvmvp.base.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import restwl.com.mvmvp.base.presenter.MvvmpPresenter;
import restwl.com.mvmvp.base.viewmodel.MvvmpViewModel;

public abstract class BaseMvvmpActivity<MView extends MvvmpView, Presenter extends MvvmpPresenter<MView>,
    ViewModel extends MvvmpViewModel<Presenter>> extends AppCompatActivity implements MvvmpView {

    private ViewModel mViewModel;
    private volatile boolean mIsStateLost = false;

    public abstract @LayoutRes
    int getLayoutResId();

    public abstract @NonNull
    ViewModel createViewModel();

    public abstract @NonNull
    Presenter createPresenter();

    public abstract @NonNull
    MView getMVPView();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getLayoutResId() != 0) {
            setContentView(getLayoutResId());
        }
        if (getViewModel() == null) {
            mViewModel = createViewModel();
        }

        if (getPresenter() == null) {
            getViewModel().setActivityPresenter(createPresenter());
        }
        getPresenter().onViewCreated(getMVPView());
    }

    @Override
    protected void onStart() {
        super.onStart();
        mIsStateLost = false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsStateLost = false;
    }

    @Override
    protected void onDestroy() {
        getPresenter().onViewDestroyed();
        super.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mIsStateLost = true;
    }

    public boolean isStateLost() {
        return mIsStateLost;
    }

    public void showToast(@NonNull String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void showShackBar(@NonNull String message) {
        View parentLayout = findViewById(android.R.id.content);
        if (parentLayout != null) {
//            Snac.make(parentLayout, message, Snackbar.LENGTH_SHORT).show();
        }
    }

    public Presenter getPresenter() {
        return getViewModel().getActivityPresenter();
    }

    public ViewModel getViewModel() {
        return mViewModel;
    }

}
