package blackbox.verbdrop;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by tricia on 3/21/16.
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

    private Button buttonGo;
    private EditText answer;
    private TextView promptTV, spInfinTV, engPhraseTV, spSubjTV, finalAnswerTV, streakNumTV, gameOverTV;
    private TTSManager ttsManager;
    private Typeface tf;

    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        loadPreferences();
        setupTextStyle();
        streak = 0;
        //verbList = wordBank.getAllVerbs();
        //numOfVerbs = wordBank.getNumWords();
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
        if (isAnswerCorrect(userAnswer)) {
            finalAnswerTV.setText(userAnswer);
            answer.setText("");
            ttsManager.initQueue(SP_SUBJECTS[randSubjIndx] + userAnswer);
            Animation animation=new TranslateAnimation(0,0,0,4000);
            animation.setDuration(2000);
            finalAnswerTV.startAnimation(animation);
            finalAnswerTV.setVisibility(View.INVISIBLE);
            ++streak;
            streakNumTV.setText(Integer.toString(streak));
            generatePhrase();
        }
        else {
            setContentView(R.layout.game_over);
            gameOverTV = (TextView) findViewById(R.id.txtViewOver);
            TextView correctAnswTV = (TextView) findViewById(R.id.txtViewCorrect2);
            TextView yourResponseTV = (TextView) findViewById(R.id.txtViewYourResponse2);
            TextView streakTV = (TextView) findViewById(R.id.txtViewStreak2);
            gameOverTV.setTypeface(tf);
            correctAnswTV.setTypeface(tf);
            yourResponseTV.setTypeface(tf);
            streakTV.setTypeface(tf);
            correctAnswTV.setText(SP_SUBJECTS[randSubjIndx] + " " + getCorrectAnswer());
            yourResponseTV.setText(SP_SUBJECTS[randSubjIndx] + " " + userAnswer);
            streakTV.setText(Integer.toString(streak));
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
        String phrase = engSubject + " " + engVerb + ".";
        engPhraseTV.setText(phrase);
        spSubjTV.setText(spSubject);

        // Display Spanish infinitive and current tense to use
        String spInfinAndTense = "(" + randVerb.getSpInfinitive() + " - " + randVerb.getVerbTense() + " tense)";
        spInfinTV.setText(spInfinAndTense.toUpperCase());
    }

    private boolean isAnswerCorrect(String userAnswer) {
        String correctAnswer = getCorrectAnswer();
        userAnswer = userAnswer.toLowerCase();
        if (userAnswer.equals(correctAnswer))
            return true;
        else
            return false;
    }

    private String getCorrectAnswer() {
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
        return correctAnswer;
    }

    private void setupTextStyle() {
        tf = Typeface.createFromAsset(getAssets(), "fonts/chalkboard-bold.ttf");
        buttonGo = (Button) findViewById(R.id.buttonGo);
        buttonGo.setTypeface(tf);
        //promptTV = (TextView) findViewById(R.id.txtViewPrompt);
        // promptTV.setTypeface(tf);
        spInfinTV = (TextView) findViewById(R.id.txtViewSpInfin);
        spInfinTV.setTypeface(tf);
        engPhraseTV = (TextView) findViewById(R.id.txtViewEngPhrase);
        engPhraseTV.setTypeface(tf);
        spSubjTV = (TextView) findViewById(R.id.txtViewSpSubject);
        spSubjTV.setTypeface(tf);
        answer = (EditText) findViewById(R.id.editTxtAnswer);
        finalAnswerTV = (TextView) findViewById(R.id.txtViewFinalAnswer);
        streakNumTV = (TextView) findViewById(R.id.txtViewStreakNum);
    }

    private void loadPreferences() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        // LOAD PREFERENCES FOR WHICH VERB GROUPS WILL APPEAR IN THE GAME.
        boolean[] isGroupChecked = new boolean[4];
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
        verbList = wordBank.removeTense(verbList, isRegPres, isIrregPres);

        numOfVerbs = verbList.length;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        ttsManager.shutDown();
    }
}
