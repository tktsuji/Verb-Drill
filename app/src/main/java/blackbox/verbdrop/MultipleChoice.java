package blackbox.verbdrop;

import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Random;

public class MultipleChoice extends Game {
    private static int NUM_OPTIONS = 4;
    private int correctRadioBttn;    // index of button displaying theCorrectAnswer
    private String theCorrectAnswer; // the correct Spanish form of the verb

    private RadioGroup radioGroup;

    public void setupUI() {
        setContentView(R.layout.activity_multiple_choice);
        MODE = 2;
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        for (int i = 0; i < NUM_OPTIONS; i++) {
            ((RadioButton)radioGroup.getChildAt(i)).setTypeface(tf);
        }
    }

    public void updateQuestion() {
        generatePhrase();
        // DISPLAY ENGLISH PHRASE AND SP SUBJECT
        engPhraseTV.setText(engPhrase);
        spSubjTV.setText(spSubject);
        // DISPLAY SPANISH INFINITIVE AND CURRENT TENSE TO USE
        String spInfinAndTense = "(" + randVerb.getSpInfinitive() + " - " + randVerb.getVerbTense() + ")";
        spInfinTV.setText(spInfinAndTense.toUpperCase());

        setCorrectRadioButton();
        setOtherRadioButtons();
    }

    public void onGo(View v) {
        correctPhrase = spSubject + " " + theCorrectAnswer;
        int selectedBttnID = radioGroup.getCheckedRadioButtonId();
        RadioButton userSelectedBttn = (RadioButton) radioGroup.findViewById(selectedBttnID);
        int userSelectedBttnIndx = radioGroup.indexOfChild(userSelectedBttn);
        if (selectedBttnID == -1) {
            onIncorrectAnswer();
        } else {
            userPhrase = spSubject + " " + userSelectedBttn.getText().toString();
            if (userSelectedBttnIndx == correctRadioBttn) {
                playSound();
                ++streak;
                streakNumTV.setText(Integer.toString(streak));
                updateQuestion();
            } else {
                onIncorrectAnswer();
            }
        }
    }

    public void setCorrectRadioButton() {
        // RANDOMLY CHOOSE WHICH RADIO BUTTON WILL HAVE THE CORRECT ANSWER, AND SET ITS TEXT
        Random rand = new Random();
        correctRadioBttn = rand.nextInt(NUM_OPTIONS);
        theCorrectAnswer = getCorrectAnswer();
        for (int i = 0; i < NUM_OPTIONS; i++) {
            if (i == correctRadioBttn)
                ((RadioButton)radioGroup.getChildAt(i)).setText(theCorrectAnswer);
        }
    }

    public void setOtherRadioButtons() {
        String yo = randVerb.getYo();
        String tu = randVerb.getTu();
        String usted = randVerb.getUsted();
        String nosotros = randVerb.getNosotros();
        String ustedes = randVerb.getUstedes();

        // PUT THE INCORRECT FORMS OF THE VERB (FOR THE CURRENT QUESTION) INTO AN ARRAY
        String[] otherConjugations = {"", "", "", ""};
        int nextIndx = 0;
        if ( !theCorrectAnswer.equals(yo) )
            otherConjugations[nextIndx++] = yo;
        if ( !theCorrectAnswer.equals(tu) )
            otherConjugations[nextIndx++] = tu;
        if ( !theCorrectAnswer.equals(usted) )
            otherConjugations[nextIndx++] = usted;
        if ( !theCorrectAnswer.equals(nosotros) )
            otherConjugations[nextIndx++] = nosotros;
        if ( !theCorrectAnswer.equals(ustedes) )
            otherConjugations[nextIndx] = ustedes;

        // SHUFFLE POSSIBILITIES SO CONJUGATIONS ARE NOT ALWAYS DISPLAYED IN SAME ORDER
        shuffleStringArray(otherConjugations);

        // PUT FIRST 3 INCORRECT CONJUGATIONS IN OTHER RADIO BUTTONS
        int conjIndx = 0;
        for (int i = 0; i < 4; i++) {
            if (i != correctRadioBttn)
                ((RadioButton) radioGroup.getChildAt(i)).setText(otherConjugations[conjIndx++]);
        }
    }

    private static void shuffleStringArray(String[] myArray) {
        Random rand = new Random();
        String temp;
        int randIndx;
        for (int i = 0; i < myArray.length; i++) {
            randIndx = rand.nextInt(myArray.length);
            temp = myArray[i];
            myArray[i] = myArray[randIndx];
            myArray[randIndx] = temp;
        }
    }


}
