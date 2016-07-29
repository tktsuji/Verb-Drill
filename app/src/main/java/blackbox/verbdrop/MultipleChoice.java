package blackbox.verbdrop;

public class MultipleChoice extends Game {

    public void setupUI() {
        setContentView(R.layout.activity_multiple_choice);
    }

    public void displayPhrase()
    {
        // Display phrase
        engPhraseTV.setText(engPhrase);

        // Display Spanish infinitive and current tense to use
        String spInfinAndTense = "(" + randVerb.getSpInfinitive() + " - " + randVerb.getVerbTense() + " tense)";
        spInfinTV.setText(spInfinAndTense.toUpperCase());
    }

}
