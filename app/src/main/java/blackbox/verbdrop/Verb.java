package blackbox.verbdrop;

/**
 * Created by tricia on 3/21/16.
 */
public class Verb {
    private String inEnglish;
    private String spInfinitive;
    //boolean isIrregular;
    // boolean isChecked;
    // int numTimesCorrect;

    public Verb (String inEnglish, String spInfinitive) {
        this.inEnglish = inEnglish;
        this.spInfinitive = spInfinitive;
    }

    public String getInEnglish() { return inEnglish; }

    public String getSpanishInfinitive() { return spInfinitive; }

}
