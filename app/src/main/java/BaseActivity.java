import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.Toast;
import com.common.android.utils.BuildConfig;
import com.common.android.utils.logging.Logger;
import com.zplesac.connectionbuddy.ConnectionBuddy;
import com.zplesac.connectionbuddy.ConnectionBuddyConfiguration;
import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

import static android.widget.Toast.makeText;
import static com.android.codechallenge.R.string.connection_error;
import static com.common.android.utils.ContextHelper.getContext;
import static com.zplesac.connectionbuddy.ConnectionBuddy.getInstance;
import static de.keyboardsurfer.android.widget.crouton.Crouton.makeText;

public abstract class BaseActivity extends AppCompatActivity {
    private static final String TAG = BaseActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
