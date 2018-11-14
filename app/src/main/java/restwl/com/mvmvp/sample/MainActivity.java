package restwl.com.mvmvp.sample;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProviders;
import restwl.com.mvmvp.R;
import restwl.com.mvmvp.base.ui.BaseActivity;

public class MainActivity extends BaseActivity<MainContact.View, MainContact.Presenter,
    MainContact.ViewModel> implements MainContact.View {

    @Override
    public int getLayoutResId() {
        return R.layout.activity_main;
    }

    @NonNull
    @Override
    public MainContact.ViewModel createViewModel() {
        return ViewModelProviders.of(this).get(MainViewModel.class);
    }

    @NonNull
    @Override
    public MainContact.Presenter createPresenter() {
        return new MainPresenter();
    }

    @NonNull
    @Override
    public MainContact.View getMVPView() {
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
}
