package blackbox.verbdrill;

/**
 *  Regular Preterite Indiciative
 */
public class RegVerbPreterite extends Verb {
    public RegVerbPreterite(String inEnglish, String spInfinitive) {
        super(inEnglish, spInfinitive);
        verbTense = "preterite";
    }

    public String getYo() {
        String base = spInfinitive.substring(0, spInfinitive.length() - 2);
        String end = spInfinitive.substring(spInfinitive.length() - 2);
        String yo;
        if (end.equals("ar"))
            yo = base + "\u00E9";
        else
            yo = base + "\u00ED";
        return yo;
    }

    public String getTu() {
        String base = spInfinitive.substring(0, spInfinitive.length() - 2);
        String end = spInfinitive.substring(spInfinitive.length() - 2);
        String tu;
        if (end.equals("ar"))
            tu = base + "aste";
        else
            tu = base + "iste";
        return tu;
    }

    public String getUsted() {
        String base = spInfinitive.substring(0, spInfinitive.length() - 2);
        String end = spInfinitive.substring(spInfinitive.length() - 2);
        String usted;
        if (end.equals("ar"))
            usted = base + "\u00F3";
        else
            usted = base + "i\u00F3";
        return usted;
    }

    public String getNosotros() {
        String base = spInfinitive.substring(0, spInfinitive.length() - 2);
        String end = spInfinitive.substring(spInfinitive.length() - 2);
        String nosotros;
        if (end.equals("ar"))
            nosotros = base + "amos";
        else
            nosotros = base + "imos";
        return nosotros;
    }

    public String getUstedes() {
        String base = spInfinitive.substring(0, spInfinitive.length() - 2);
        String end = spInfinitive.substring(spInfinitive.length() - 2);
        String ustedes;
        if (end.equals("ar"))
            ustedes = base + "aron";
        else
            ustedes = base + "ieron";
        return ustedes;
    }

    public String getI() { return inEnglish; }
    public String getYou() { return inEnglish; }
    public String getHeShe() { return inEnglish; }
    public String getWe() { return inEnglish; }
    public String getThey() { return inEnglish; }
}
