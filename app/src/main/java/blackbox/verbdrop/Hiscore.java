package blackbox.verbdrop;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

/**
 *  Show Hiscore
 */
public class Hiscore extends Activity {

    SharedPreferences sharedPref;
    private int hiscoreFNB, ultHiscoreFNB, hiscoreMC, ultHiscoreMC;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hiscore);
        Typeface tf = Typeface.createFromAsset(this.getAssets(), "fonts/chalkboard-bold.ttf");
        TextView fillNBlankTV = (TextView) findViewById(R.id.textViewFillNBlank);
        TextView mcTV = (TextView) findViewById(R.id.textViewMC);
        TextView highStreakFNB = (TextView) findViewById(R.id.textViewHiscoreFNB);
        TextView ultHighStreakFNB = (TextView) findViewById(R.id.textViewUltimateHiscoreFNB);
        TextView highStreakMC = (TextView) findViewById(R.id.textViewHiscoreMC);
        TextView ultHighStreakMC = (TextView) findViewById(R.id.textViewUltimateHiscoreMC);
        fillNBlankTV.setTypeface(tf);
        mcTV.setTypeface(tf);
        highStreakFNB.setTypeface(tf);
        ultHighStreakFNB.setTypeface(tf);
        highStreakMC.setTypeface(tf);
        ultHighStreakMC.setTypeface(tf);

        getHiscoreData();
        TextView highStreakFNB2 = (TextView) findViewById(R.id.textViewHiscoreFNB2);
        TextView ultHighStreakFNB2 = (TextView) findViewById(R.id.textViewUltimateHiscoreFNB2);
        TextView highStreakMC2 = (TextView) findViewById(R.id.textViewHiscoreMC2);
        TextView ultHighStreakMC2 = (TextView) findViewById(R.id.textViewUltimateHiscoreMC2);
        highStreakFNB2.setText(Integer.toString(hiscoreFNB));
        ultHighStreakFNB2.setText(Integer.toString(ultHiscoreFNB));
        highStreakMC2.setText(Integer.toString(hiscoreMC));
        ultHighStreakMC2.setText(Integer.toString(ultHiscoreMC));
    }

    public void getHiscoreData() {
        sharedPref = this.getSharedPreferences("hiscoreData", Context.MODE_PRIVATE);
        hiscoreFNB = sharedPref.getInt("hiscoreFNB", 0);
        ultHiscoreFNB = sharedPref.getInt("ultimateHiscoreFNB", 0);
        hiscoreMC = sharedPref.getInt("hiscoreMC", 0);
        ultHiscoreMC = sharedPref.getInt("ultimateHiscoreMC", 0);
    }
}