package blackbox.verbdrill;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

/**
 *  Translate from English to Spanish by filling in the blank with the correct
 *  form of the verb.
 */

public class ActivityFillNBlank extends ActivityGame {
    private EditText answerET; // answer that user types into blank
    TextView contextTV, contextTV2;

    public void setupUI() {
        setContentView(R.layout.activity_fillnblank);
        MODE = 1;
        answerET = (EditText) findViewById(R.id.editTxtAnswer);
        contextTV = (TextView) findViewById(R.id.txtViewExtraContext);
        contextTV2 = (TextView) findViewById(R.id.txtViewExtraContext2Bottom);
    }

    public void updateQuestion() {
        generatePhrase();

        // DISPLAY ENGLISH PHRASE AND SPANISH SUBJECT
        engPhraseTV.setText(engPhrase);
        spSubjTV.setText(spSubject);

        // IF PRESENT SUBJUNCTIVE, SET CONTEXT
        if ((randVerb.getVerbTense()).equals("present subj."))
            contextTV.setText("(It's recommended/best/desirable that...)");
        // IF IMPERFECT IND, SET CONTEXT
        if ((randVerb.getVerbTense()).equals("imperfect ind."))
            contextTV2.setText("(used to)");

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
        contextTV.setText("");
        contextTV2.setText("");
        String userAnswer = answerET.getText().toString();
        userPhrase = spSubject + " " + userAnswer;
        if (isAnswerCorrect(userAnswer)) {
            answerET.setText("");
            playSound();
            ++streak;
            streakNumTV.setText(String.format(Locale.US, "%d", streak));
            updateQuestion();
        }
        else {
            onIncorrectAnswer();
        }
    }

    // ACTIONS FOR SPECIAL-CHARACTER KEYS/BUTTONS
    public void onA(View v) { answerET.append("\u00E1"); }
    public void onE(View v) { answerET.append("\u00E9"); }
    public void onI(View v) { answerET.append("\u00ED"); }
    public void onO(View v) { answerET.append("\u00F3"); }
    public void onU(View v) { answerET.append("\u00FA"); }
    public void onN(View v) { answerET.append("\u00F1"); }
}
