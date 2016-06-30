package blackbox.verbdrop;

/**
 * Abstract class for Verb objects
 */
public abstract class Verb {
    protected String inEnglish;
    protected String spInfinitive;
    protected String verbTense;

    public Verb(String inEnglish, String spInfinitive) {
        this.inEnglish = inEnglish;
        this.spInfinitive = spInfinitive;
    }

    public String getInEnglish() { return inEnglish; }
    public String getSpInfinitive() { return spInfinitive; }
    public String getVerbTense() { return verbTense; }

    abstract String getYo();
    abstract String getTu();
    abstract String getUsted();
    abstract String getNosotros();
    abstract String getUstedes();

    abstract String getI();
    abstract String getYou();
    abstract String getHeShe();
    abstract String getWe();
    abstract String getThey();
}
