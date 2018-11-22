package restwl.com.mvmvp.base.di;


import android.content.Context;

import dagger.Module;

@Module
public class ActivityContextModule {
    private final Context context;

    public ActivityContextModule(Context context) {
        this.context = context;
    }
}
