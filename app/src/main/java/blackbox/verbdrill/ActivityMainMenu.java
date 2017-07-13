package blackbox.verbdrill;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityMainMenu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.content_main_menu);
    }

    // Respond to button press on Main Menu
    public void ButtonOnClick(View v)
    {
        Intent i;
        switch (v.getId())
        {
            case R.id.buttonStart :
                i = new Intent(this, ActivityGameModeSelection.class);
                startActivity(i);
                break;
            case R.id.buttonReference :
                i = new Intent(this, ActivityReferences.class);
                startActivity(i);
                break;
            case R.id.buttonSettings :
                i = new Intent(this, ActivitySettings.class);
                startActivity(i);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        // DISABLED, DO NOTHING
    }
}
