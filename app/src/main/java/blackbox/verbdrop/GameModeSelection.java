package blackbox.verbdrop;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Displays buttons to select which game mode to begin.
 */
public class GameModeSelection extends Activity {
    private Button mode1, mode2;
    private TextView arrow1TV, arrow2TV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_mode_selection);
        mode1 = (Button) findViewById(R.id.buttonMode1);
        mode2 = (Button) findViewById(R.id.buttonMode2);
        arrow1TV = (TextView) findViewById(R.id.txtViewArrow);
        arrow2TV = (TextView) findViewById(R.id.txtViewArrow2);
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/chalkboard-bold.ttf");
        mode1.setTypeface(tf);
        mode2.setTypeface(tf);
        arrow1TV.setTypeface(tf);
        arrow2TV.setTypeface(tf);
    }

    public void onMode1(View v) {
        Intent i = new Intent(this, FillNBlank.class);
        startActivity(i);
    }

    public void onMode2(View v) {
        Intent i = new Intent(this, MultipleChoice.class);
        startActivity(i);
    }

}
