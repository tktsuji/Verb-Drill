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
    private int numOfVerbs;
    private Button buttonGo;
    private TextView prompt, engPhrase, spSubj, finalAnswer;
    private EditText answer;
    private static final String[] ENG_SUBJECTS = {
            "I", "You", "You",
            "You all", "We", "They",
            "He", "She"
    };

    private static final String[] SP_SUBJECTS = {
            "Yo", "Usted", "Tu",
            "Ustedes", "Nosotros", "Ellos\n/Ellas",
            "El", "Ella"
    };

    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        verbList = wordBank.getAllVerbs();
        numOfVerbs = wordBank.getNumWords();
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/chalkboard-bold.ttf");
        buttonGo = (Button) findViewById(R.id.buttonGo);
        buttonGo.setTypeface(tf);
        prompt = (TextView) findViewById(R.id.txtViewPrompt);
        prompt.setTypeface(tf);
        engPhrase = (TextView) findViewById(R.id.txtViewEngPhrase);
        engPhrase.setTypeface(tf);
        spSubj = (TextView) findViewById(R.id.txtViewSpSubject);
        spSubj.setTypeface(tf);
        answer = (EditText) findViewById(R.id.editTxtAnswer);
        finalAnswer = (TextView) findViewById(R.id.txtViewFinalAnswer);
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

        // Get random verb
        Random rand2 = new Random();
        int randNum2 = rand2.nextInt(numOfVerbs);
        Verb randVerb = verbList[randNum2];
        String engVerb = randVerb.getInEnglish();
        if (randNum1 == 6 || randNum1 == 7)
            engVerb = engVerb + "s";

        // Display phrase
        String phrase = engSubject + " " + engVerb + ".";
        engPhrase.setText(phrase);
        spSubj.setText(spSubject);
    }

    public void onButtonPress(View v) {
        String answerString = answer.getText().toString();
        finalAnswer.setText(answerString);
        answer.setText("");

        //answer.setLayoutParams(positionRules);
        Animation animation=new TranslateAnimation(0,0,0,500);
        animation.setDuration(1000);
        finalAnswer.startAnimation(animation);
        finalAnswer.setVisibility(View.INVISIBLE);
    }
}
