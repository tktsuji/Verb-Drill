package blackbox.verbdrill;

import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

import static android.R.id.button1;

public class ActivityMultipleChoice extends ActivityGame {
    private static int NUM_OPTIONS = 4;
    private int correctBttnNum; // index of button displaying theCorrectAnswer
    private String theCorrectAnswer; // the correct Spanish form of the verb

    private Button bttn0, bttn1, bttn2, bttn3;
    TextView contextTV, contextTV2;

    public void setupUI() {
        setContentView(R.layout.activity_multiplechoice);
        MODE = 2;
        bttn0 = (Button) findViewById(R.id.button0);
        bttn1 = (Button) findViewById(R.id.button1);
        bttn2 = (Button) findViewById(R.id.button2);
        bttn3 = (Button) findViewById(R.id.button3);
        contextTV = (TextView) findViewById(R.id.txtViewExtraContext);
        contextTV2 = (TextView) findViewById(R.id.txtViewExtraContext2Bottom);
    }

    public void updateQuestion() {
        generatePhrase();
        // DISPLAY ENGLISH PHRASE AND SP SUBJECT
        engPhraseTV.setText(engPhrase);
        spSubjTV.setText(spSubject);

        // IF SUBJUNCTIVE, SET CONTEXT
        if ((randVerb.getVerbTense()).equals("present subj."))
            contextTV.setText("(It's recommended/best/desirable that...)");
        // IF IMPERFECT IND, SET CONTEXT
        if ((randVerb.getVerbTense()).equals("imperfect ind."))
            contextTV2.setText("(used to)");

        // DISPLAY SPANISH INFINITIVE AND CURRENT TENSE TO USE
        String spInfinAndTense = "(" + randVerb.getSpInfinitive() + " - " + randVerb.getVerbTense() + ")";
        spInfinTV.setText(spInfinAndTense.toUpperCase());

        setCorrectButton();
        setOtherButtons();
    }

    public void onButtonClick(View v) {
        contextTV.setText("");
        contextTV2.setText("");
        correctPhrase = spSubject + " " + theCorrectAnswer;
        Button bttn = (Button)v;
        userPhrase = spSubject + " " + bttn.getText().toString();
        int viewId = v.getId();
        if ((viewId == R.id.button0) && (correctBttnNum == 0))
            onCorrectAnswer();
        else if ((viewId == R.id.button1) && (correctBttnNum == 1))
            onCorrectAnswer();
        else if ((viewId == R.id.button2) && (correctBttnNum == 2))
            onCorrectAnswer();
        else if ((viewId == R.id.button3) && (correctBttnNum == 3))
            onCorrectAnswer();
        else
            onIncorrectAnswer();
    }

    public void onCorrectAnswer() {
        playSound();
        ++streak;
        streakNumTV.setText(String.format(Locale.US, "%d", streak));
        updateQuestion();
    }

    public void setCorrectButton() {
        // RANDOMLY CHOOSE WHICH BUTTON WILL HAVE THE CORRECT ANSWER, AND SET ITS TEXT
        Random rand = new Random();
        correctBttnNum = rand.nextInt(NUM_OPTIONS);
        theCorrectAnswer = getCorrectAnswer();
        if (correctBttnNum == 0)
            bttn0.setText(theCorrectAnswer);
        else if (correctBttnNum == 1)
            bttn1.setText(theCorrectAnswer);
        else if (correctBttnNum == 2)
            bttn2.setText(theCorrectAnswer);
        else
            bttn3.setText(theCorrectAnswer);
    }

    public void setOtherButtons() {
        String yo = randVerb.getYo();
        String tu = randVerb.getTu();
        String usted = randVerb.getUsted();
        String nosotros = randVerb.getNosotros();
        String ustedes = randVerb.getUstedes();

        ArrayList<String> otherConjugations = new ArrayList<>();
        if ( !theCorrectAnswer.equals(yo) )
            otherConjugations.add(yo);
        if ( !theCorrectAnswer.equals(tu) )
            otherConjugations.add(tu);
        if ( !theCorrectAnswer.equals(usted) && !otherConjugations.contains(usted) )
            otherConjugations.add(usted);
        if ( !theCorrectAnswer.equals(nosotros) )
            otherConjugations.add(nosotros);
        if ( !theCorrectAnswer.equals(ustedes) )
            otherConjugations.add(ustedes);

        // SHUFFLE POSSIBILITIES SO CONJUGATIONS ARE NOT ALWAYS DISPLAYED IN SAME ORDER
        shuffleArrayList(otherConjugations);

        // PUT FIRST 3 INCORRECT CONJUGATIONS IN OTHER BUTTONS
        int conjIndx = 0;
        for (int i = 0; i < NUM_OPTIONS; i++) {
            if (i != correctBttnNum) {
                if (i == 0) {
                    bttn0.setText(otherConjugations.get(conjIndx));
                    conjIndx++;
                }
                else if (i == 1) {
                    bttn1.setText(otherConjugations.get(conjIndx));
                    conjIndx++;
                }
                else if (i == 2) {
                    bttn2.setText(otherConjugations.get(conjIndx));
                    conjIndx++;
                }
                else {
                    bttn3.setText(otherConjugations.get(conjIndx));
                    conjIndx++;
                }
            }
        }
    }

    private static void shuffleArrayList(ArrayList<String> myArrayList) {
        Random rand = new Random();
        String temp;
        int randIndx;
        for (int i = 0; i < myArrayList.size(); i++) {
            randIndx = rand.nextInt(myArrayList.size());
            temp = myArrayList.get(i);
            myArrayList.set(i, myArrayList.get(randIndx));
            myArrayList.set(randIndx, temp);
        }
    }


}
