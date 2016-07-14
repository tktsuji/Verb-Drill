package blackbox.verbdrop;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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

    // Respond to press on dropdown menu on Main Menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_help) {
            Intent i = new Intent(this, Help.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // Respond to button press on Main Menu
    public void ButtonOnClick(View v)
    {
        Intent i;
        switch (v.getId())
        {
            case R.id.buttonStart :
                i = new Intent(this, Game.class);
                startActivity(i);
                //finish();
                break;
            case R.id.buttonSettings :
                i = new Intent(this, Settings.class);
                startActivity(i);
                break;
            case R.id.buttonLog :
                i = new Intent(this, UserLog.class);
                startActivity(i);
                break;
        }
    }
}
