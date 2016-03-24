package blackbox.verbdrop;


import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
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
    private static final String[] ENG_SUBJECTS = {
            "I", "You", "You",
            "He", "She", "We",
            "You all", "They", "They"
    };
    private static final String[] SP_SUBJECTS = {
            "Yo", "Tu", "Usted",
            "El", "Ella", "Nosotros",
            "Ustedes", "Ellos", "Ellas"
    };

    private Button buttonGo;
    private EditText answer;
    private TextView promptTV, engPhraseTV, spSubjTV, finalAnswerTV, streakTV, gameOverTV;
    private Typeface tf;

    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        verbList = wordBank.getAllVerbs();
        numOfVerbs = wordBank.getNumWords();
        tf = Typeface.createFromAsset(getAssets(), "fonts/chalkboard-bold.ttf");
        buttonGo = (Button) findViewById(R.id.buttonGo);
        buttonGo.setTypeface(tf);
        promptTV = (TextView) findViewById(R.id.txtViewPrompt);
        promptTV.setTypeface(tf);
        engPhraseTV = (TextView) findViewById(R.id.txtViewEngPhrase);
        engPhraseTV.setTypeface(tf);
        spSubjTV = (TextView) findViewById(R.id.txtViewSpSubject);
        spSubjTV.setTypeface(tf);
        answer = (EditText) findViewById(R.id.editTxtAnswer);
        finalAnswerTV = (TextView) findViewById(R.id.txtViewFinalAnswer);
        streakTV = (TextView) findViewById(R.id.txtViewStreak);
    }

     protected void onStart() {
         super.onStart();
         generatePhrase();
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
        String engVerb = randVerb.getInEnglish();
        if (randNum1 == 3 || randNum1 == 4)
            engVerb = engVerb + "s";

        // Display phrase
        String phrase = engSubject + " " + engVerb + ".";
        engPhraseTV.setText(phrase);
        spSubjTV.setText(spSubject);
    }

    public void onButtonPress(View v) {
        String userAnswer = answer.getText().toString();
        if (isAnswerCorrect(userAnswer)) {
            finalAnswerTV.setText(userAnswer);
            answer.setText("");
            Animation animation=new TranslateAnimation(0,0,0,4000);
            animation.setDuration(2000);
            finalAnswerTV.startAnimation(animation);
            finalAnswerTV.setVisibility(View.INVISIBLE);
        }
        else {
            setContentView(R.layout.game_over);
            gameOverTV = (TextView) findViewById(R.id.txtViewOver);
            TextView correctAnsw = (TextView) findViewById(R.id.txtViewCorrect2);
            TextView yourResponse = (TextView) findViewById(R.id.txtViewYourResponse2);
            TextView streak = (TextView) findViewById(R.id.txtViewStreak2);
            gameOverTV.setTypeface(tf);
            correctAnsw.setTypeface(tf);
            yourResponse.setTypeface(tf);
            streak.setTypeface(tf);

            correctAnsw.setText(SP_SUBJECTS[randSubjIndx] + " " + getCorrectAnswer());
            yourResponse.setText(SP_SUBJECTS[randSubjIndx] + " " + userAnswer);
            //streak.setText()
        }

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
            correctAnswer = randVerb.getYoForm();
        else if (randSubjIndx == 1)
            correctAnswer = randVerb.getTuForm();
        else if (randSubjIndx == 2 || randSubjIndx == 3 || randSubjIndx == 4)
            correctAnswer = randVerb.getUstedForm();
        else if (randSubjIndx == 5)
            correctAnswer = randVerb.getNosotrosForm();
        else
            correctAnswer = randVerb.getUstedesForm();
        return correctAnswer;
    }
}
