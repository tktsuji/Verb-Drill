package blackbox.verbdrill;

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
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
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
 *  ActivitySettings.
 */
public abstract class ActivityGame extends AppCompatActivity {
    protected static int MODE; // 1 for FNB, 2 for MC
    protected WordBank wordBank = new WordBank();
    protected Verb randVerb;
    protected int randSubjIndx;
    protected int streak;
    protected static final String[] ENG_SUBJECTS = {
            "I", "you", "you",
            "he", "she", "we",
            "you all", "they", "they"
    };
    protected static final String[] SP_SUBJECTS = {
            "yo", "tú", "usted",
            "él", "ella", "nosotros",
            "ustedes", "ellos", "ellas"
    };
    protected String engPhrase;     // The phrase to be translated
    protected String spSubject;     // The Spanish subject of the sentence
    protected String correctPhrase; // The correct Spanish translation of engPhrase
    protected String userPhrase;    // The user's inputted response
    protected static int NUM_GROUPS = 30; // Number of verb groups in WordBank

    // BUTTONS AND TEXTS
    protected Button buttonGo;
    protected TextView spInfinTV, engPhraseTV, streakNumTV, spSubjTV,
            streakTV, timeTV;

    // FONT, SOUND, AND TIME OBJECTS
    protected TTSManager ttsManager;
    protected SoundPool sounds;
    protected int sndwhoosh;
    protected Chronometer timer;

    // OBJECTS TO MAKE EXPANDABLE LISTS THAT SHOW THE VERBS AND VERB TENSES THAT ARE IN PLAY
    protected ExpandableListAdapter listAdapter;
    protected ExpandableListView expListView;
    protected List<String> listDataHeader;
    protected HashMap<String, List<String>> listDataChild;

    protected SharedPreferences sharedPreferences;
    // VALUES THAT WILL BE LOADED FROM PREFERENCES (SETTINGS)
    protected Verb[] verbList;
    protected int numOfVerbs;
    protected boolean[] isGroupChecked = new boolean[NUM_GROUPS];
    protected boolean isText2SpeechOn = true;
    protected boolean isSoundFxOn = true;
    boolean isRegPres, isIrregPres, isRegPret, isIrregPret,
            isRegFut, isIrregFut, isRegImpInd, isIrregImpInd, isRegPresSubj, isIrregPresSubj;
    protected int numGroupsSelected; // num of verb groups selected
    protected int numTensesSelected; // num of tenses selected

    abstract void setupUI();
    abstract void updateQuestion();

    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        if (isText2SpeechOn) {
            ttsManager = new TTSManager();
            ttsManager.init(this);
        }
    }

    protected void onStart() {
        super.onStart();
        if (numOfVerbs <= 0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("There are no verbs that meet your specifications as selected in Settings." +
                    " Please try adding more verb groups and/or more verb tenses.")
                    .setCancelable(false)
                    .setTitle("No Verbs Selected")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            finish();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        } else {
            updateQuestion();
        }
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
        engPhrase = engSubject + " " + engVerb;
    }

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
        correctPhrase = spSubject + " " + correctAnswer;
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
        // PREPARE DATA TO BE TRANSFERRED TO GAMEOVERSCREEN ACTIVITY
        String stopTime = timer.getText().toString();
        timer.stop();

        Intent i = new Intent(this, ActivityGameOverScreen.class);
        i.putExtra("spInfin", randVerb.getSpInfinitive());
        i.putExtra("verbTense", randVerb.getVerbTense());
        i.putExtra("mode", MODE);
        i.putExtra("engPhrase", engPhrase);
        i.putExtra("correctPhrase", correctPhrase);
        i.putExtra("userPhrase", userPhrase);
        i.putExtra("streak", streak);
        i.putExtra("time", stopTime);
        //i.putExtra("childDataHash", listDataChild);
        i.putExtra("numGroupsAndTenses", numGroupsSelected+numTensesSelected);
        startActivity(i);
        finish();
    }

    public void playSound() {
        if (isSoundFxOn)
            sounds.play(sndwhoosh, 1.0f, 1.0f, 0, 0, 1.5f);
        if (isText2SpeechOn && ttsManager.getIsLangSupported())
            ttsManager.initQueue(userPhrase);
    }

    public void setupTextStyle() {
        buttonGo = (Button) findViewById(R.id.buttonGo);
        spInfinTV = (TextView) findViewById(R.id.txtViewSpInfin);
        engPhraseTV = (TextView) findViewById(R.id.txtViewEngPhrase);
        spSubjTV = (TextView) findViewById(R.id.txtViewSpSubject);
        streakTV = (TextView) findViewById(R.id.txtViewStreak);
        streakNumTV = (TextView) findViewById(R.id.txtViewStreakNum);
        timeTV = (TextView)findViewById(R.id.txtViewTime);
    }

    public void loadPreferences() {
        sharedPreferences =  PreferenceManager.getDefaultSharedPreferences(this);
        // LOAD PREFERENCES FOR WHICH VERB GROUPS WILL APPEAR IN THE GAME.

        int groupNum = 0;
        numGroupsSelected = 0;
        numTensesSelected = 0;
        isGroupChecked[groupNum++] = sharedPreferences.getBoolean("group1_key", true);
        isGroupChecked[groupNum++] = sharedPreferences.getBoolean("group2_key", true);
        isGroupChecked[groupNum++] = sharedPreferences.getBoolean("group3_key", true);
        isGroupChecked[groupNum++] = sharedPreferences.getBoolean("group4_key", true);
        isGroupChecked[groupNum++] = sharedPreferences.getBoolean("group5_key", true);
        isGroupChecked[groupNum++] = sharedPreferences.getBoolean("group6_key", true);
        isGroupChecked[groupNum++] = sharedPreferences.getBoolean("group7_key", true);
        isGroupChecked[groupNum++] = sharedPreferences.getBoolean("group8_key", true);
        isGroupChecked[groupNum++] = sharedPreferences.getBoolean("group9_key", true);
        isGroupChecked[groupNum++] = sharedPreferences.getBoolean("group10_key", true);
        isGroupChecked[groupNum++] = sharedPreferences.getBoolean("group11_key", true);
        isGroupChecked[groupNum++] = sharedPreferences.getBoolean("group12_key", true);
        isGroupChecked[groupNum++] = sharedPreferences.getBoolean("group13_key", true);
        isGroupChecked[groupNum++] = sharedPreferences.getBoolean("group14_key", true);
        isGroupChecked[groupNum++] = sharedPreferences.getBoolean("group15_key", true);
        isGroupChecked[groupNum++] = sharedPreferences.getBoolean("group16_key", true);
        isGroupChecked[groupNum++] = sharedPreferences.getBoolean("group17_key", true);
        isGroupChecked[groupNum++] = sharedPreferences.getBoolean("group18_key", true);
        isGroupChecked[groupNum++] = sharedPreferences.getBoolean("group19_key", true);
        isGroupChecked[groupNum++] = sharedPreferences.getBoolean("group20_key", true);
        isGroupChecked[groupNum++] = sharedPreferences.getBoolean("group21_key", true);
        isGroupChecked[groupNum++] = sharedPreferences.getBoolean("group22_key", true);
        isGroupChecked[groupNum++] = sharedPreferences.getBoolean("group23_key", true);
        isGroupChecked[groupNum++] = sharedPreferences.getBoolean("group24_key", true);
        isGroupChecked[groupNum++] = sharedPreferences.getBoolean("group25_key", true);
        isGroupChecked[groupNum++] = sharedPreferences.getBoolean("group26_key", true);
        isGroupChecked[groupNum++] = sharedPreferences.getBoolean("group27_key", true);
        isGroupChecked[groupNum++] = sharedPreferences.getBoolean("group28_key", true);
        isGroupChecked[groupNum++] = sharedPreferences.getBoolean("group29_key", true);
        isGroupChecked[groupNum++] = sharedPreferences.getBoolean("group30_key", true);

        for (int i = 0; i < NUM_GROUPS; i++) {
            if (isGroupChecked[i]) numGroupsSelected++;
        }
        verbList = wordBank.getSelectedVerbs(isGroupChecked, numGroupsSelected);

        // LOAD PREFERENCES FOR WHICH VERB TENSES AND FORMS WILL APPEAR IN THE GAME.
        isRegPres   = sharedPreferences.getBoolean("regular_present", true);
        isIrregPres = sharedPreferences.getBoolean("irregular_present", true);
        isRegPret   = sharedPreferences.getBoolean("regular_preterite", true);
        isIrregPret = sharedPreferences.getBoolean("irregular_preterite", true);
        isRegFut    = sharedPreferences.getBoolean("regular_future", true);
        isIrregFut  = sharedPreferences.getBoolean("irregular_future", true);
        isRegImpInd = sharedPreferences.getBoolean("regular_imperfect_indic", true);
        isIrregImpInd = sharedPreferences.getBoolean("irregular_imperfect_indic", true);
        isRegPresSubj = sharedPreferences.getBoolean("regular_present_subj", true);
        isIrregPresSubj = sharedPreferences.getBoolean("irregular_present_subj", true);
        verbList = wordBank.removeTense(verbList, isRegPres, isIrregPres, isRegPret, isIrregPret,
                                        isRegFut, isIrregFut, isRegImpInd, isIrregImpInd, isRegPresSubj, isIrregPresSubj);

        if (isRegPres) numTensesSelected++;
        if (isIrregPres) numTensesSelected++;
        if (isRegPret) numTensesSelected++;
        if (isIrregPret) numTensesSelected++;
        if (isRegFut) numTensesSelected++;
        if (isIrregFut) numTensesSelected++;
        if (isRegImpInd) numTensesSelected++;
        if (isIrregImpInd) numTensesSelected++;
        if (isRegPresSubj) numTensesSelected++;
        if (isIrregPresSubj) numTensesSelected++;

        numOfVerbs = verbList.length;

        // LOAD PREFERENCES FOR SOUNDS
        isText2SpeechOn = sharedPreferences.getBoolean("text_to_speech", true);
        isSoundFxOn = sharedPreferences.getBoolean("sound_fx", true);
    }

    public void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding header data
        listDataHeader.add("Verb Groups In Play");
        listDataHeader.add("Verb Tenses In Play");

        // Adding child data
        List<String> verbGroupsInPlay = new ArrayList<String>();
        for (int i = 0; i < NUM_GROUPS; i++) {
            if (isGroupChecked[i]) {
                verbGroupsInPlay.add("Group " + Integer.toString(i+1));
            }
        }

        List<String> verbTensesInPlay = new ArrayList<String>();
        if (isRegPres)
            verbTensesInPlay.add("Regular Present Indic.");
        if (isIrregPres)
            verbTensesInPlay.add("Irregular Present Indic.");
        if (isRegPret)
            verbTensesInPlay.add("Regular Preterite Indic.");
        if (isIrregPret)
            verbTensesInPlay.add("Irregular Preterite Indic.");
        if (isRegFut)
            verbTensesInPlay.add("Regular Future Indic.");
        if (isIrregFut)
            verbTensesInPlay.add("Irregular Future Indic.");
        if (isRegImpInd)
            verbTensesInPlay.add("Regular Imperfect Indic.");
        if (isIrregImpInd)
            verbTensesInPlay.add("Irregular Imperfect Indic.");
        if (isRegPresSubj)
            verbTensesInPlay.add("Regular Present Subj.");
        if (isIrregPresSubj)
            verbTensesInPlay.add("Irregular Present Subj.");

        listDataChild.put(listDataHeader.get(0), verbGroupsInPlay); // Header, Child data
        listDataChild.put(listDataHeader.get(1), verbTensesInPlay);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return(true);
        }

        return(super.onOptionsItemSelected(item));
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Exit Game")
                .setMessage("Are you sure you want to quit?")
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
        if (isText2SpeechOn)
            ttsManager.shutDown();
    }
}
