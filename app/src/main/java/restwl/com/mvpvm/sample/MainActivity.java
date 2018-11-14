package restwl.com.mvpvm.sample;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProviders;
import restwl.com.mvpvm.R;
import restwl.com.mvpvm.Utils;
import restwl.com.mvpvm.base.ui.BaseActivity;

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
        Utils.showDebugMessage(getPresenter().toString());
        findViewById(R.id.button).setOnClickListener(this::onButtonClick);
    }

    private void onButtonClick(View view) {
        getPresenter().onButtonClicked();
    }

    @Override
    public void showToastMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }
}
