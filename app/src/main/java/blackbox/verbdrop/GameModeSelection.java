package blackbox.verbdrop;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by tricia on 7/22/16.
 */
public class GameModeSelection extends Activity {
    private Button mode1, mode2;
    private TextView selectModeTV, arrow1TV, arrow2TV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_mode_selection);
        mode1 = (Button) findViewById(R.id.buttonMode1);
        mode2 = (Button) findViewById(R.id.buttonMode2);
        selectModeTV = (TextView) findViewById(R.id.txtViewModeSelection);
        arrow1TV = (TextView) findViewById(R.id.txtViewArrow);
        arrow2TV = (TextView) findViewById(R.id.txtViewArrow2);
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/chalkboard-bold.ttf");
        mode1.setTypeface(tf);
        mode2.setTypeface(tf);
        selectModeTV.setTypeface(tf);
        arrow1TV.setTypeface(tf);
        arrow2TV.setTypeface(tf);
    }

    public void onMode1(View v) {
        Intent i = new Intent(this, Game.class);
        startActivity(i);
    }

}
