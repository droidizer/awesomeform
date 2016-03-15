import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import com.common.android.utils.BuildConfig;
import com.common.android.utils.logging.Logger;
import com.zplesac.connectionbuddy.ConnectionBuddy;
import com.zplesac.connectionbuddy.ConnectionBuddyConfiguration;

/**
 * Created by greymatter on 02/03/16.
 */
public abstract class BaseActivity extends AppCompatActivity {
    private static final String TAG = BaseActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Keep the screen always on
        if (BuildConfig.DEBUG)
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        ConnectionBuddy.getInstance().init(new ConnectionBuddyConfiguration.Builder(this).build());

        Logger.v(TAG, "[Connection] hasConnection: " + ConnectionBuddy.getInstance().hasNetworkConnection());
        if (!ConnectionBuddy.getInstance().hasNetworkConnection()) {
            onNoConnectionAvailable();
        }
    }
    protected abstract void onNoConnectionAvailable();

}
