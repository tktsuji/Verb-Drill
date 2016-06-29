package blackbox.verbdrop;

/**
 * Regular Present Indicative
 */
public class RegVerbPresent extends Verb {
    private String heShe;

    public RegVerbPresent(String inEnglish, String spInfinitive) {
        super(inEnglish, spInfinitive);
        this.heShe = inEnglish + "s";
        verbTense = "present";
    }

    public RegVerbPresent(String inEnglish, String spInfinitive, String heShe) {
        super(inEnglish, spInfinitive);
        this.heShe = heShe;
        verbTense = "present";
    }

    public String getYo() {
        String base = spInfinitive.substring(0, spInfinitive.length() - 2);
        String yo = base + "o";
        return yo;
    }

    public String getTu() {
        String base = spInfinitive.substring(0, spInfinitive.length() - 2);
        String end = spInfinitive.substring(spInfinitive.length() - 2);
        String tu;
        if (end.equals("ar"))
            tu = base + "as";
        else
            tu = base + "es";
        return tu;
    }

    public String getUsted() {
        String base = spInfinitive.substring(0, spInfinitive.length() - 2);
        String end = spInfinitive.substring(spInfinitive.length() - 2);
        String usted;
        if (end.equals("ar"))
            usted = base + "a";
        else
            usted = base + "e";
        return usted;
    }

    public String getNosotros() {
        String base = spInfinitive.substring(0, spInfinitive.length() - 2);
        String end = spInfinitive.substring(spInfinitive.length() - 2);
        String nosotros;
        if (end.equals("ar"))
            nosotros = base + "amos";
        else if (end.equals("er"))
            nosotros = base + "emos";
        else
            nosotros = base + "imos";
        return nosotros;
    }

    public String getUstedes() {
        String base = spInfinitive.substring(0, spInfinitive.length() - 2);
        String end = spInfinitive.substring(spInfinitive.length() - 2);
        String ustedes;
        if (end.equals("ar"))
            ustedes = base + "an";
        else
            ustedes = base + "en";
        return ustedes;
    }

    public String getI() {
        return inEnglish;
    }
    public String getYou() {
        return inEnglish;
    }

    public String getHeShe() {
        return heShe;
    }
    public String getWe() {
        return inEnglish;
    }
    public String getThey() {
        return inEnglish;
    }
}
