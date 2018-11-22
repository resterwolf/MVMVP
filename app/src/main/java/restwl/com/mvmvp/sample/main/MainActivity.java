package restwl.com.mvmvp.sample.main;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import restwl.com.mvmvp.R;
import restwl.com.mvmvp.Utils;
import restwl.com.mvmvp.base.ui.BaseMvvmpActivity;
import restwl.com.mvmvp.sample.main.fragments.FirstFragment;

public class MainActivity extends BaseMvvmpActivity<MainContract.View, MainContract.Presenter,
    MainContract.ViewModel> implements MainContract.View {

    private ProgressBar mProgressBar;

    @Override
    public int getLayoutResId() {
        return R.layout.activity_main;
    }

    @NonNull
    @Override
    public MainContract.ViewModel createViewModel() {
        return ViewModelProviders.of(this).get(ViewModel.class);
    }

    @NonNull
    @Override
    public MainContract.Presenter createPresenter() {
        return new MainPresenter();
    }

    @NonNull
    @Override
    public MainContract.View getMVPView() {
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        findViewById(R.id.button).setOnClickListener(this::onButtonClick);
        mProgressBar = findViewById(R.id.progressBar);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void onButtonClick(View view) {
        getPresenter().onButtonClicked();
    }

    @Override
    public void showToastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showFragment(Fragment fragment, String tag) {
    }

    @Override
    public void showPogress(boolean show) {
        if (show) {
            mProgressBar.setVisibility(View.VISIBLE);
        } else {
            mProgressBar.setVisibility(View.GONE);
        }
    }
}
