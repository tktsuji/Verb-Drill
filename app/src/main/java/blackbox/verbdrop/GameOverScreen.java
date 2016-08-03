package blackbox.verbdrop;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *  Displays Game Over screen.
 */
public class GameOverScreen extends Activity {

    // OBJECTS TO MAKE EXPANDABLE LISTS THAT SHOW THE VERBS AND VERB TENSES THAT ARE IN PLAY
    private ExpandableListAdapter listAdapter;
    private ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    // BUTTONS
    private Button buttonSave, buttonDone;

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
        streak2TV.setText(Integer.toString(extras.getInt("streak")));
        time2TV.setText(extras.getString("time"));

        listDataHeader = new ArrayList<String>();
        listDataHeader.add("Verb Groups In Play");
        listDataHeader.add("Verb Tenses In Play");
        listDataChild = new HashMap<String, List<String>>();
        listDataChild = (HashMap<String, List<String>>) extras.getSerializable("childDataHash");
        expListView = (ExpandableListView) findViewById(R.id.lvExp);
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
        expListView.setAdapter(listAdapter);

        buttonSave = (Button) findViewById(R.id.buttonSave);
        buttonDone = (Button) findViewById(R.id.buttonDone);
        buttonSave.setTypeface(tf);
        buttonDone.setTypeface(tf);
    }
}
