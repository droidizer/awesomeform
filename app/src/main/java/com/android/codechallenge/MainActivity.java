package com.android.codechallenge;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;
import com.common.android.utils.*;
import com.common.android.utils.logging.Logger;
import com.zplesac.connectionbuddy.ConnectionBuddyConfiguration;
import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

import static android.widget.Toast.makeText;
import static com.android.codechallenge.FragmentProvider.showUsersFragment;
import static com.android.codechallenge.R.string.connection_error;
import static com.common.android.utils.ContextHelper.getContext;
import static com.zplesac.connectionbuddy.ConnectionBuddy.getInstance;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showUsersFragment();

        // Keep the screen always on
        if (com.common.android.utils.BuildConfig.DEBUG)
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        getInstance().init(new ConnectionBuddyConfiguration.Builder(this).build());

        Logger.v(TAG, "[Connection] hasConnection: " + getInstance().hasNetworkConnection());
        if (!getInstance().hasNetworkConnection()) {
            makeText(getContext(), connection_error, Toast.LENGTH_LONG).show();
            Crouton.makeText(this, connection_error, Style.ALERT);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
