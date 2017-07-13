package blackbox.verbdrill;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *  Displays ActivityGame Over screen. Updates hiscore and allows user to save record of the activity_fillnblank
 *  to the UserLog.
 */
public class ActivityGameOverScreen extends AppCompatActivity {

    // FOR UPDATING HISCORE
    private int streak;
    private int mode;
    private static int TOTAL_VERBGROUPSNTENSES = 40; // # of verb groups + # of verb tenses
    private int numOfGroupsTensesChecked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        TextView correctAnswTV = (TextView) findViewById(R.id.txtViewCorrect);
        TextView yourResponseTV = (TextView) findViewById(R.id.txtViewYourResponse);
        TextView streakTV = (TextView) findViewById(R.id.txtViewStreak);
        TextView promptTV = (TextView) findViewById(R.id.txtViewPrompt);
        TextView timeTV = (TextView) findViewById(R.id.txtViewTime);
        TextView prompt2InfinTV = (TextView) findViewById(R.id.txtViewPrompt2Infin);
        TextView prompt2TV = (TextView) findViewById(R.id.txtViewPrompt2);
        TextView correctAnsw2TV = (TextView) findViewById(R.id.txtViewCorrect2);
        TextView yourResponse2TV = (TextView) findViewById(R.id.txtViewYourResponse2);
        TextView streak2TV = (TextView) findViewById(R.id.txtViewStreak2);
        TextView time2TV = (TextView) findViewById(R.id.txtViewTime2);

        Bundle extras = getIntent().getExtras();
        String infinFormAndTense = "(" + extras.getString("spInfin") + " - " + extras.getString("verbTense") + ")";
        prompt2InfinTV.setText(infinFormAndTense);
        prompt2TV.setText(extras.getString("engPhrase"));
        correctAnsw2TV.setText(extras.getString("correctPhrase"));
        yourResponse2TV.setText(extras.getString("userPhrase"));
        streak = extras.getInt("streak");
        streak2TV.setText(Integer.toString(streak));
        time2TV.setText(extras.getString("time"));
        mode = extras.getInt("mode");
        numOfGroupsTensesChecked = extras.getInt("numGroupsAndTenses");
        Button buttonDone = (Button) findViewById(R.id.buttonDone);
        updateHiscore();
    }

    public void updateHiscore() {
        SharedPreferences sharedPref = getSharedPreferences("hiscoreData", Context.MODE_PRIVATE);

        int ultimateHiscoreFNB = sharedPref.getInt("ultimateHiscoreFNB", 0);
        int ultimateHiscoreMC  = sharedPref.getInt("ultimateHiscoreMC", 0);
        int hiscoreFNB = sharedPref.getInt("hiscoreFNB", 0);
        int hiscoreMC  = sharedPref.getInt("hiscoreMC", 0);

        /*int numOfGroupsTensesChecked = listDataChild.get("Verb Groups In Play").size()
                + listDataChild.get("Verb Tenses In Play").size();*/
        Toast toast=Toast.makeText(getApplicationContext(),"New Hiscore!", Toast.LENGTH_SHORT);
        if (mode == 1) {
            if (streak > hiscoreFNB) {
                hiscoreFNB = streak;
                toast.show();
            }
            if (streak > ultimateHiscoreFNB && (numOfGroupsTensesChecked == TOTAL_VERBGROUPSNTENSES)) {
                ultimateHiscoreFNB = streak;
                toast.show();
            }
        }
        else if (mode == 2) {
            if (streak > hiscoreMC) {
                hiscoreMC = streak;
                toast.show();
            }
            if (streak > ultimateHiscoreMC && numOfGroupsTensesChecked == TOTAL_VERBGROUPSNTENSES) {
                ultimateHiscoreMC = streak;
                toast.show();
            }
        }

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("hiscoreFNB", hiscoreFNB);
        editor.putInt("hiscoreMC", hiscoreMC);
        editor.putInt("ultimateHiscoreFNB", ultimateHiscoreFNB);
        editor.putInt("ultimateHiscoreMC", ultimateHiscoreMC);
        editor.apply();
    }

    public void onDone(View v) {
        Intent i = new Intent(this, ActivityMainMenu.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        // DISABLED, DO NOTHING
    }

}
