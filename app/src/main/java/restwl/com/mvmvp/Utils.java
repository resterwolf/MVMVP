package restwl.com.mvmvp;

import android.util.Log;

public final class Utils {

    private static final String TAG = "MyLog";

    private Utils() {
    }

    public static void showDebugMessage(String message) {
        Log.d(TAG, message);
    }
}
