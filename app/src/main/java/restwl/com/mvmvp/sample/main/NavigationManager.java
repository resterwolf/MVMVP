package restwl.com.mvmvp.sample.main;

import android.content.Context;
import android.content.Intent;

import restwl.com.mvmvp.base.navigation.BaseNavigationManager;
import restwl.com.mvmvp.sample.second.SecondActivity;

public class NavigationManager extends BaseNavigationManager implements MainContract.NavigationManager {

    public NavigationManager(Context context) {
        super(context);
    }

    @Override
    public void startSecondActivity() {
        Intent secondActivityIntent = new Intent(getContext(), SecondActivity.class);
        startActivity(secondActivityIntent);
    }
}
