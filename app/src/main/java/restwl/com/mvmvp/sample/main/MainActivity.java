package restwl.com.mvmvp.sample.main;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import restwl.com.mvmvp.R;
import restwl.com.mvmvp.Utils;
import restwl.com.mvmvp.base.ui.BaseActivity;
import restwl.com.mvmvp.sample.main.fragments.FirstFragment;

public class MainActivity extends BaseActivity<MainContract.View, MainContract.Presenter,
    MainContract.ViewModel> implements MainContract.View {

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
        return new MainPresenter(new NavigationManager(this), new MainInteractor());
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
        getSupportFragmentManager()
            .beginTransaction()
            .add(R.id.frame_layout, fragment, tag)
            .commitNow();
    }
}
