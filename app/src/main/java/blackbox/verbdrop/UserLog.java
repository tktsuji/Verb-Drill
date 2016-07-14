package blackbox.verbdrop;

import android.app.Activity;
import android.os.Bundle;

/**
 * A log to keep track of user's past activity and progress.
 */
public class UserLog extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_log);
    }
}
