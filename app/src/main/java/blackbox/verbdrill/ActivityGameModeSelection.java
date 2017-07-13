package blackbox.verbdrill;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

/**
 * Displays buttons to select which activity_fillnblank mode to begin.
 */
public class ActivityGameModeSelection extends AppCompatActivity {
    SharedPreferences sharedPref;
    private int fnbHiscore1, fnbHiscore2, mcHiscore1, mcHiscore2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_mode_selection);
        TextView fnbHiscore1Num = (TextView) findViewById(R.id.fnb_hiscore1_num_tv);
        TextView fnbHiscore2Num = (TextView) findViewById(R.id.fnb_hiscore2_num_tv);
        TextView mcHiscore1Num = (TextView) findViewById(R.id.mc_hiscore1_num_tv);
        TextView mcHiscore2Num = (TextView) findViewById(R.id.mc_hiscore2_num_tv);
        getHiscoreData();
        fnbHiscore1Num.setText(String.format(Locale.US, "%d", fnbHiscore1));
        fnbHiscore2Num.setText(String.format(Locale.US, "%d", fnbHiscore2));
        mcHiscore1Num.setText(String.format(Locale.US, "%d", mcHiscore1));
        mcHiscore2Num.setText(String.format(Locale.US, "%d", mcHiscore2));
    }

    public void onMode1(View v) {
        Intent i = new Intent(this, ActivityFillNBlank.class);
        startActivity(i);
    }

    public void onMode2(View v) {
        Intent i = new Intent(this, ActivityMultipleChoice.class);
        startActivity(i);
    }

    public void getHiscoreData() {
        sharedPref = this.getSharedPreferences("hiscoreData", Context.MODE_PRIVATE);
        fnbHiscore1 = sharedPref.getInt("hiscoreFNB", 0);
        fnbHiscore2 = sharedPref.getInt("ultimateHiscoreFNB", 0);
        mcHiscore1 = sharedPref.getInt("hiscoreMC", 0);
        mcHiscore2 = sharedPref.getInt("ultimateHiscoreMC", 0);
    }
}