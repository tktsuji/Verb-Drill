package blackbox.verbdrop;

/**
 * Irregular Preterite
 */
public class IrregVerbPreterite extends Verb {
    private String yo;
    private String tu;
    private String usted;
    private String nosotros;
    private String ustedes;

    private String I;
    private String you;
    private String heShe;
    private String we;
    private String they;

    public IrregVerbPreterite(String inEnglish, String spInfinitive, String yo, String tu,
                            String usted, String nosotros, String ustedes) {
        super(inEnglish, spInfinitive);
        this.yo = yo;
        this.tu = tu;
        this.usted = usted;
        this.nosotros = nosotros;
        this.ustedes = ustedes;
        this.I = inEnglish;
        this.you = inEnglish;
        this.heShe = inEnglish;
        this.we = inEnglish;
        this.they = inEnglish;
        verbTense = "preterite";
    }

    public String getYo() {
        return yo;
    }

    public String getTu() {
        return tu;
    }

    public String getUsted() {
        return usted;
    }

    public String getNosotros() {
        return nosotros;
    }

    public String getUstedes() {
        return ustedes;
    }

    public String getI() { return I; }

    public String getYou() {return you; }

    public String getHeShe() { return heShe; }

    public String getWe() { return we; }

    public String getThey() { return they; }
}

