package blackbox.verbdrop;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 *  Translate from English to Spanish by filling in the blank with the correct
 *  form of the verb.
 */

public class Game extends Activity {
    private WordBank wordBank = new WordBank();
    private Verb[] verbList;
    private Verb randVerb;
    private int numOfVerbs;
    private int randSubjIndx;
    private int streak;
    private static final String[] ENG_SUBJECTS = {
            "I", "You", "You",
            "He", "She", "We",
            "You all", "They", "They"
    };
    private static final String[] SP_SUBJECTS = {
            "Yo", "T\u00FA", "Usted",
            "\u00C9l", "Ella", "Nosotros",
            "Ustedes", "Ellos", "Ellas"
    };
    private String engPhrase;
    private String correctPhrase;
    private String userPhrase;

    // BUTTONS AND TEXTS
    private Button buttonGo;
    private EditText answer;
    private TextView spInfinTV, engPhraseTV, spSubjTV, finalAnswerTV, streakNumTV,
            streakTV, timeTV;

    // SOUND AND TIME OBJECTS
    private TTSManager ttsManager;
    private SharedPreferences sharedPreferences;
    private Typeface tf;
    private SoundPool sounds;
    private int sndwhoosh;
    private Chronometer timer;

    // OBJECTS TO MAKE EXPANDABLE LISTS THAT SHOW THE VERBS AND VERB TENSES THAT ARE IN PLAY
    private ExpandableListAdapter listAdapter;
    private ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    // VALUES THAT WILL BE LOADED FROM PREFERENCES (SETTINGS)
    private boolean[] isGroupChecked = new boolean[4];
    private boolean isText2SpeechOn = true;
    private boolean isSoundFxOn = true;

    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
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
     }

    public void onGo(View v) {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
        String userAnswer = answer.getText().toString();
        userPhrase = SP_SUBJECTS[randSubjIndx] + userAnswer;
        if (isAnswerCorrect(userAnswer)) {
            finalAnswerTV.setText(userAnswer);
            answer.setText("");
            if (isSoundFxOn)
                sounds.play(sndwhoosh, 1.0f, 1.0f, 0, 0, 1.5f);
            if (isText2SpeechOn)
                ttsManager.initQueue(userPhrase);
            Animation animation= new TranslateAnimation(0,0,0,1000);
            animation.setDuration(2000);
            finalAnswerTV.startAnimation(animation);
            finalAnswerTV.setVisibility(View.INVISIBLE);
            ++streak;
            streakNumTV.setText(Integer.toString(streak));
            generatePhrase();
        }
        else {
            Intent i = new Intent(this, GameOverScreen.class);
            i.putExtra("engPhrase", engPhrase);
            i.putExtra("correctPhrase", correctPhrase);
            i.putExtra("userPhrase", userPhrase);
            i.putExtra("streak", streak);
            startActivity(i);
            finish();
        }
    }

    public void generatePhrase() {
        // Get random subject
        Random rand1 = new Random();
        int randNum1 = rand1.nextInt(ENG_SUBJECTS.length);
        String engSubject = ENG_SUBJECTS[randNum1];
        String spSubject  = SP_SUBJECTS[randNum1];
        randSubjIndx = randNum1;

        // Get random verb
        Random rand2 = new Random();
        int randNum2 = rand2.nextInt(numOfVerbs);
        randVerb = verbList[randNum2];

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

        // Display phrase
        engPhrase = engSubject + " " + engVerb + ".";
        engPhraseTV.setText(engPhrase);
        spSubjTV.setText(spSubject);

        // Display Spanish infinitive and current tense to use
        String spInfinAndTense = "(" + randVerb.getSpInfinitive() + " - " + randVerb.getVerbTense() + " tense)";
        spInfinTV.setText(spInfinAndTense.toUpperCase());
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

    public void setupTextStyle() {
        tf = Typeface.createFromAsset(getAssets(), "fonts/chalkboard-bold.ttf");
        buttonGo = (Button) findViewById(R.id.buttonGo);
        buttonGo.setTypeface(tf);
        spInfinTV = (TextView) findViewById(R.id.txtViewSpInfin);
        spInfinTV.setTypeface(tf);
        engPhraseTV = (TextView) findViewById(R.id.txtViewEngPhrase);
        engPhraseTV.setTypeface(tf);
        spSubjTV = (TextView) findViewById(R.id.txtViewSpSubject);
        spSubjTV.setTypeface(tf);
        answer = (EditText) findViewById(R.id.editTxtAnswer);
        finalAnswerTV = (TextView) findViewById(R.id.txtViewFinalAnswer);
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

    public void onA(View v) {
        answer.append("\u00E1");
    }

    public void onE(View v) {
        answer.append("\u00E9");
    }

    public void onI(View v) {
        answer.append("\u00ED");
    }

    public void onO(View v) {
        answer.append("\u00F3");
    }

    public void onU(View v) {
        answer.append("\u00FA");
    }

    public void onN(View v) {
        answer.append("\u00F1");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ttsManager.shutDown();
    }
}
