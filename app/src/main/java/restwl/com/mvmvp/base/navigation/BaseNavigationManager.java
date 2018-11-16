package restwl.com.mvmvp.base.navigation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;

public abstract class BaseNavigationManager implements MVPNavigationManager {

    private Context context;

    public BaseNavigationManager(@NonNull Context context) {
        this.context = context;
    }

    @NonNull
    public Context getContext() {
        return context;
    }

    public void startActivity(Intent intent) {
        context.startActivity(intent);
    }

    public void startActivity(Intent intent, Bundle bundle) {
        context.startActivity(intent,bundle);
    }

}
