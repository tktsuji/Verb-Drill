package blackbox.verbdrill;

/**
 * Created by tricia on 7/3/17.
 */

public class RegImperfectIndic extends Verb {

    private String I;
    private String you;
    private String heShe;
    private String we;
    private String they;

    public RegImperfectIndic(String inEnglish, String spInfinitive) {
        super(inEnglish, spInfinitive);
        this.I = inEnglish;
        this.you = inEnglish;
        this.heShe = inEnglish;
        this.we = inEnglish;
        this.they = inEnglish;
        verbTense = "imperfect ind.";
    }

    public RegImperfectIndic(String inEnglish, String spInfinitive, String I, String you, String heShe, String we, String they) {
        super (inEnglish, spInfinitive);
        this.I = I;
        this.you = you;
        this.heShe = heShe;
        this.we = we;
        this.they = they;
        verbTense = "imperfect ind.";
    }

    public String getYo() {
        String base = spInfinitive.substring(0, spInfinitive.length() - 2);
        String end = spInfinitive.substring(spInfinitive.length() - 2);
        String yo;
        if (end.equals("ar"))
            yo = base + "aba";
        else
            yo = base + "ía";
        return yo;
    }


    public String getTu() {
        String base = spInfinitive.substring(0, spInfinitive.length() - 2);
        String end = spInfinitive.substring(spInfinitive.length() - 2);
        String tu;
        if (end.equals("ar"))
            tu = base + "abas";
        else
            tu = base + "ías";
        return tu;
    }

    public String getUsted() {
        String base = spInfinitive.substring(0, spInfinitive.length() - 2);
        String end = spInfinitive.substring(spInfinitive.length() - 2);
        String usted;
        if (end.equals("ar"))
            usted = base + "aba";
        else
            usted = base + "ía";
        return usted;
    }

    public String getNosotros() {
        String base = spInfinitive.substring(0, spInfinitive.length() - 2);
        String end = spInfinitive.substring(spInfinitive.length() - 2);
        String nosotros;
        if (end.equals("ar"))
            nosotros = base + "ábamos";
        else
            nosotros = base + "íamos";
        return nosotros;
    }

    public String getUstedes() {
        String base = spInfinitive.substring(0, spInfinitive.length() - 2);
        String end = spInfinitive.substring(spInfinitive.length() - 2);
        String ustedes;
        if (end.equals("ar"))
            ustedes = base + "aban";
        else
            ustedes = base + "ían";
        return ustedes;
    }

    public String getI() { return I; }

    public String getYou() {return you; }

    public String getHeShe() { return heShe; }

    public String getWe() { return we; }

    public String getThey() { return they; }
}