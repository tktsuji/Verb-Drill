package blackbox.verbdrill;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/chalkboard-bold.ttf");
        Button startBtn = (Button) findViewById(R.id.buttonStart);
        Button settingsBtn = (Button) findViewById(R.id.buttonSettings);
        Button helpBtn = (Button) findViewById(R.id.buttonLog);
        TextView arrow1 = (TextView) findViewById(R.id.txtViewArrow);
        TextView arrow2 = (TextView) findViewById(R.id.txtViewArrow2);
        TextView arrow3 = (TextView) findViewById(R.id.txtViewArrow3);
        arrow1.setTypeface(tf);
        arrow2.setTypeface(tf);
        arrow3.setTypeface(tf);
        startBtn.setTypeface(tf);
        settingsBtn.setTypeface(tf);
        helpBtn.setTypeface(tf);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_menu, menu);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        return true;
    }

    // Respond to button press on Main Menu
    public void ButtonOnClick(View v)
    {
        Intent i;
        switch (v.getId())
        {
            case R.id.buttonStart :
                i = new Intent(this, GameModeSelection.class);
                startActivity(i);
                //finish();
                break;
            case R.id.buttonSettings :
                i = new Intent(this, Settings.class);
                startActivity(i);
                break;
            case R.id.buttonLog :
                i = new Intent(this, Hiscore.class);
                startActivity(i);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        // DISABLED, DO NOTHING
    }
}
