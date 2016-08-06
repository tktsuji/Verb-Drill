package blackbox.verbdrop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *  Displays Game Over screen. Updates hiscore and allows user to save record of the game
 *  to the UserLog.
 */
public class GameOverScreen extends Activity {

    // OBJECTS TO MAKE EXPANDABLE LISTS THAT SHOW THE VERBS AND VERB TENSES THAT ARE IN PLAY
    private ExpandableListAdapter listAdapter;
    private ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    // FOR UPDATING HISCORE
    private int streak;
    private int mode;
    private static int TOTAL_VERBGROUPSNTENSES = 8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_over);
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/chalkboard-bold.ttf");
        TextView correctAnswTV = (TextView) findViewById(R.id.txtViewCorrect);
        correctAnswTV.setTypeface(tf);
        TextView yourResponseTV = (TextView) findViewById(R.id.txtViewYourResponse);
        yourResponseTV.setTypeface(tf);
        TextView streakTV = (TextView) findViewById(R.id.txtViewStreak);
        streakTV.setTypeface(tf);
        TextView promptTV = (TextView) findViewById(R.id.txtViewPrompt);
        promptTV.setTypeface(tf);
        TextView timeTV = (TextView) findViewById(R.id.txtViewTime);
        timeTV.setTypeface(tf);
        TextView prompt2TV = (TextView) findViewById(R.id.txtViewPrompt2);
        TextView correctAnsw2TV = (TextView) findViewById(R.id.txtViewCorrect2);
        TextView yourResponse2TV = (TextView) findViewById(R.id.txtViewYourResponse2);
        TextView streak2TV = (TextView) findViewById(R.id.txtViewStreak2);
        TextView time2TV = (TextView) findViewById(R.id.txtViewTime2);

        Bundle extras = getIntent().getExtras();
        prompt2TV.setText(extras.getString("engPhrase"));
        correctAnsw2TV.setText(extras.getString("correctPhrase"));
        yourResponse2TV.setText(extras.getString("userPhrase"));
        streak = extras.getInt("streak");
        streak2TV.setText(Integer.toString(streak));
        time2TV.setText(extras.getString("time"));
        mode = extras.getInt("mode");

        listDataHeader = new ArrayList<String>();
        listDataHeader.add("Verb Groups In Play");
        listDataHeader.add("Verb Tenses In Play");
        listDataChild = new HashMap<String, List<String>>();
        listDataChild = (HashMap<String, List<String>>) extras.getSerializable("childDataHash");
        expListView = (ExpandableListView) findViewById(R.id.lvExp);
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
        expListView.setAdapter(listAdapter);

        Button buttonDone = (Button) findViewById(R.id.buttonDone);
        buttonDone.setTypeface(tf);

        updateHiscore();
    }

    public void updateHiscore() {
        SharedPreferences sharedPref = getSharedPreferences("hiscoreData", Context.MODE_PRIVATE);

        int ultimateHiscoreFNB = sharedPref.getInt("ultimateHiscoreFNB", 0);
        int ultimateHiscoreMC  = sharedPref.getInt("ultimateHiscoreMC", 0);
        int hiscoreFNB = sharedPref.getInt("hiscoreFNB", 0);
        int hiscoreMC  = sharedPref.getInt("hiscoreMC", 0);
        int numOfGroupsTensesChecked = listDataChild.get("Verb Groups In Play").size()
                + listDataChild.get("Verb Tenses In Play").size();
        Toast toast=Toast.makeText(getApplicationContext(),"New Hiscore!", Toast.LENGTH_SHORT);
        Toast toast2=Toast.makeText(getApplicationContext(),"New Ultimate Hiscore!",Toast.LENGTH_SHORT);
        if (mode == 1) {
            if (streak > hiscoreFNB) {
                hiscoreFNB = streak;
                toast.show();
            }
            if (streak > ultimateHiscoreFNB && (numOfGroupsTensesChecked == TOTAL_VERBGROUPSNTENSES)) {
                ultimateHiscoreFNB = streak;
                toast2.show();
            }
        }
        else if (mode == 2) {
            if (streak > hiscoreMC) {
                hiscoreMC = streak;
                toast.show();
            }
            if (streak > ultimateHiscoreMC && numOfGroupsTensesChecked == TOTAL_VERBGROUPSNTENSES) {
                ultimateHiscoreMC = streak;
                toast2.show();
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
        Intent i = new Intent(this, MainMenu.class);
        startActivity(i);
    }

}
