package blackbox.verbdrill;

/**
 * Created by tricia on 7/4/17.
 */

public class RegPresentSubj extends Verb {

    public RegPresentSubj(String inEnglish, String spInfinitive) {
        super(inEnglish, spInfinitive);
        verbTense = "present subj.";
    }

    public String getYo() {
        String base = spInfinitive.substring(0, spInfinitive.length() - 2);
        String end = spInfinitive.substring(spInfinitive.length() - 2);
        String yo;
        if (end.equals("ar"))
            yo = base + "e";
        else
            yo = base + "a";
        return yo;
    }

    public String getTu() {
        String base = spInfinitive.substring(0, spInfinitive.length() - 2);
        String end = spInfinitive.substring(spInfinitive.length() - 2);
        String tu;
        if (end.equals("ar"))
            tu = base + "es";
        else
            tu = base + "as";
        return tu;
    }

    public String getUsted() {
        String base = spInfinitive.substring(0, spInfinitive.length() - 2);
        String end = spInfinitive.substring(spInfinitive.length() - 2);
        String usted;
        if (end.equals("ar"))
            usted = base + "e";
        else
            usted = base + "a";
        return usted;
    }

    public String getNosotros() {
        String base = spInfinitive.substring(0, spInfinitive.length() - 2);
        String end = spInfinitive.substring(spInfinitive.length() - 2);
        String nosotros;
        if (end.equals("ar"))
            nosotros = base + "emos";
        else
            nosotros = base + "amos";
        return nosotros;
    }

    public String getUstedes() {
        String base = spInfinitive.substring(0, spInfinitive.length() - 2);
        String end = spInfinitive.substring(spInfinitive.length() - 2);
        String ustedes;
        if (end.equals("ar"))
            ustedes = base + "en";
        else
            ustedes = base + "an";
        return ustedes;
    }

    public String getI() {
        return inEnglish;
    }
    public String getYou() {
        return inEnglish;
    }
    public String getHeShe() {
        return inEnglish;
    }
    public String getWe() {
        return inEnglish;
    }
    public String getThey() {
        return inEnglish;
    }
}
