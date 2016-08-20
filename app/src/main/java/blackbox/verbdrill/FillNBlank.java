package blackbox.verbdrill;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

/**
 *  Translate from English to Spanish by filling in the blank with the correct
 *  form of the verb.
 */

public class FillNBlank extends Game {
    private EditText answer; // answer that user types into blank
    private TextView finalAnswerTV;

    public void setupUI() {
        setContentView(R.layout.game);
        MODE = 1;
        answer = (EditText) findViewById(R.id.editTxtAnswer);
        finalAnswerTV = (TextView) findViewById(R.id.txtViewFinalAnswer);
    }

    public void updateQuestion() {
        generatePhrase();

        // DISPLAY ENGLISH PHRASE AND SPANISH SUBJECT
        engPhraseTV.setText(engPhrase);
        spSubjTV.setText(spSubject);

        // DISPLAY SPANISH INFINITIVE AND CURRENT TENSE TO USE
        String spInfinAndTense = "(" + randVerb.getSpInfinitive() + " - " + randVerb.getVerbTense() + ")";
        spInfinTV.setText(spInfinAndTense.toUpperCase());
    }

    public void onGo(View v) {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
        String userAnswer = answer.getText().toString();
        userPhrase = spSubject + " " + userAnswer;
        if (isAnswerCorrect(userAnswer)) {
            finalAnswerTV.setText(userAnswer);
            answer.setText("");
            playSound();
            Animation animation= new TranslateAnimation(0,0,0,1000);
            animation.setDuration(2000);
            finalAnswerTV.startAnimation(animation);
            finalAnswerTV.setVisibility(View.INVISIBLE);
            ++streak;
            streakNumTV.setText(Integer.toString(streak));
            updateQuestion();
        }
        else {
            onIncorrectAnswer();
        }
    }

    // ACTIONS FOR SPECIAL-CHARACTER KEYS/BUTTONS
    public void onA(View v) { answer.append("\u00E1"); }
    public void onE(View v) { answer.append("\u00E9"); }
    public void onI(View v) { answer.append("\u00ED"); }
    public void onO(View v) { answer.append("\u00F3"); }
    public void onU(View v) { answer.append("\u00FA"); }
    public void onN(View v) { answer.append("\u00F1"); }
}
