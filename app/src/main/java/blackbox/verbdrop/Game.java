package blackbox.verbdrop;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 *  Generates a random phrase in English and checks if the user's input is the correct
 *  Spanish translation. Keeps track of user's streak and time. Loads preferences from user's
 *  Settings.
 */
public abstract class Game extends Activity {
    protected WordBank wordBank = new WordBank();
    protected Verb randVerb;
    protected int randSubjIndx;
    protected int streak;
    protected static final String[] ENG_SUBJECTS = {
            "I", "You", "You",
            "He", "She", "We",
            "You all", "They", "They"
    };
    protected static final String[] SP_SUBJECTS = {
            "Yo", "T\u00FA", "Usted",
            "\u00C9l", "Ella", "Nosotros",
            "Ustedes", "Ellos", "Ellas"
    };
    protected String engPhrase;     // The phrase to be translated
    protected String spSubject;     // The Spanish subject of the sentence
    protected String correctPhrase; // The correct Spanish translation
    protected String userPhrase;    // The user's inputted response

    // BUTTONS AND TEXTS
    protected Button buttonGo;
    protected TextView spInfinTV, engPhraseTV, streakNumTV,
            streakTV, timeTV;

    // FONT, SOUND, AND TIME OBJECTS
    protected TTSManager ttsManager;
    protected Typeface tf;
    protected SoundPool sounds;
    protected int sndwhoosh;
    protected Chronometer timer;

    // OBJECTS TO MAKE EXPANDABLE LISTS THAT SHOW THE VERBS AND VERB TENSES THAT ARE IN PLAY
    protected ExpandableListAdapter listAdapter;
    protected ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    protected SharedPreferences sharedPreferences;
    // VALUES THAT WILL BE LOADED FROM PREFERENCES (SETTINGS)
    protected Verb[] verbList;
    protected int numOfVerbs;
    protected boolean[] isGroupChecked = new boolean[4];
    protected boolean isText2SpeechOn = true;
    protected boolean isSoundFxOn = true;

    abstract void setupUI();

    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tf = Typeface.createFromAsset(getAssets(), "fonts/chalkboard-bold.ttf");
        setupUI();
        loadPreferences();
        setupTextStyle();
        expListView = (ExpandableListView) findViewById(R.id.lvExp);
        prepareListData();
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
        expListView.setAdapter(listAdapter);
        timer = (Chronometer) findViewById(R.id.chronometer1);
        timer.start();
        sounds = new SoundPool(10, AudioManager.STREAM_MUSIC,0);
        sndwhoosh = sounds.load(this, R.raw.whoosh, 1);
        streak = 0;
        ttsManager = new TTSManager();
        ttsManager.init(this);
    }

    protected void onStart() {
        super.onStart();
        generatePhrase();
        displayPhrase();
    }

    public void generatePhrase() {
        // GET RANDOM SUBJECT
        Random rand1 = new Random();
        int randNum1 = rand1.nextInt(ENG_SUBJECTS.length);
        String engSubject = ENG_SUBJECTS[randNum1];
        spSubject  = SP_SUBJECTS[randNum1];
        randSubjIndx = randNum1;

        // GET RANDOM VERB
        Random rand2 = new Random();
        int randNum2 = rand2.nextInt(numOfVerbs);
        randVerb = verbList[randNum2];

        // GET CORRECT ENGLISH FORM OF THE VERB
        String engVerb;
        if (randNum1 == 0)
            engVerb = randVerb.getI();
        else if (randNum1 == 1 || randNum1 == 2 || randNum1 == 6)
            engVerb = randVerb.getYou();
        else if (randNum1 == 3 || randNum1 == 4)
            engVerb = randVerb.getHeShe();
        else if (randNum1 == 5)
            engVerb = randVerb.getWe();
        else
            engVerb = randVerb.getThey();
        engPhrase = engSubject + " " + engVerb + ".";
    }

    abstract void displayPhrase();

    public String getCorrectAnswer() {
        String correctAnswer;
        if (randSubjIndx == 0) // yo form
            correctAnswer = randVerb.getYo();
        else if (randSubjIndx == 1)
            correctAnswer = randVerb.getTu();
        else if (randSubjIndx == 2 || randSubjIndx == 3 || randSubjIndx == 4)
            correctAnswer = randVerb.getUsted();
        else if (randSubjIndx == 5)
            correctAnswer = randVerb.getNosotros();
        else
            correctAnswer = randVerb.getUstedes();
        correctPhrase = SP_SUBJECTS[randSubjIndx] + " " + correctAnswer;
        return correctAnswer;
    }

    public boolean isAnswerCorrect(String userAnswer) {
        String correctAnswer = getCorrectAnswer();
        userAnswer = userAnswer.toLowerCase();
        if (userAnswer.equals(correctAnswer))
            return true;
        else
            return false;
    }

    public void onIncorrectAnswer() {
        Intent i = new Intent(this, GameOverScreen.class);
        i.putExtra("engPhrase", engPhrase);
        i.putExtra("correctPhrase", correctPhrase);
        i.putExtra("userPhrase", userPhrase);
        i.putExtra("streak", streak);
        startActivity(i);
        finish();
    }

    public void playSound() {
        if (isSoundFxOn)
            sounds.play(sndwhoosh, 1.0f, 1.0f, 0, 0, 1.5f);
        if (isText2SpeechOn)
            ttsManager.initQueue(userPhrase);
    }

    public void setupTextStyle() {
        buttonGo = (Button) findViewById(R.id.buttonGo);
        buttonGo.setTypeface(tf);
        spInfinTV = (TextView) findViewById(R.id.txtViewSpInfin);
        spInfinTV.setTypeface(tf);
        engPhraseTV = (TextView) findViewById(R.id.txtViewEngPhrase);
        engPhraseTV.setTypeface(tf);
        streakTV = (TextView) findViewById(R.id.txtViewStreak);
        streakTV.setTypeface(tf);
        streakNumTV = (TextView) findViewById(R.id.txtViewStreakNum);
        timeTV = (TextView)findViewById(R.id.txtViewTime);
        timeTV.setTypeface(tf);
    }

    public void loadPreferences() {
        sharedPreferences =  PreferenceManager.getDefaultSharedPreferences(this);
        // LOAD PREFERENCES FOR WHICH VERB GROUPS WILL APPEAR IN THE GAME.
        int groupNum = 0;
        int numSelected = 0;
        isGroupChecked[groupNum++] = sharedPreferences.getBoolean("group1_key", false);
        isGroupChecked[groupNum++] = sharedPreferences.getBoolean("group2_key", false);
        isGroupChecked[groupNum++] = sharedPreferences.getBoolean("group3_key", false);
        isGroupChecked[groupNum++] = sharedPreferences.getBoolean("group4_key", false);
        for (int i = 0; i < 4; i++)
            if (isGroupChecked[i]) numSelected++;
        verbList = wordBank.getSelectedVerbs(isGroupChecked, numSelected);

        // LOAD PREFERENCES FOR WHICH VERB TENSES AND FORMS WILL APPEAR IN THE GAME.
        boolean isRegPres   = sharedPreferences.getBoolean("regular_present", true);
        boolean isIrregPres = sharedPreferences.getBoolean("irregular_present", true);
        boolean isRegPret   = sharedPreferences.getBoolean("regular_preterite", true);
        boolean isIrregPret = sharedPreferences.getBoolean("irregular_preterite", true);
        verbList = wordBank.removeTense(verbList, isRegPres, isIrregPres, isRegPret, isIrregPret);
        numOfVerbs = verbList.length;

        // LOAD PREFERENCES FOR SOUNDS
        isText2SpeechOn = sharedPreferences.getBoolean("text_to_speech", true);
        isSoundFxOn = sharedPreferences.getBoolean("sound_fx", true);
    }

    public void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Verb Groups In Play");
        listDataHeader.add("Verb Tenses In Play");

        // Adding child data
        List<String> verbGroupsInPlay = new ArrayList<String>();
        for (int i = 0; i < 4; i++) {
            if (isGroupChecked[i]) {
                verbGroupsInPlay.add("Group " + Integer.toString(i+1));
            }
        }

        List<String> verbTensesInPlay = new ArrayList<String>();
        if (sharedPreferences.getBoolean("regular_present", true))
            verbTensesInPlay.add("Regular Present");
        if (sharedPreferences.getBoolean("irregular_present", true))
            verbTensesInPlay.add("Irregular Present");
        if (sharedPreferences.getBoolean("regular_preterite", true))
            verbTensesInPlay.add("Regular Preterite");
        if (sharedPreferences.getBoolean("irregular_preterite", true))
            verbTensesInPlay.add("Irregular Preterite");

        listDataChild.put(listDataHeader.get(0), verbGroupsInPlay); // Header, Child data
        listDataChild.put(listDataHeader.get(1), verbTensesInPlay);
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Exit Game")
                .setMessage("Are you sure you want to quit? This session will not be saved.")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ttsManager.shutDown();
    }
}
