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

    public String getYoForm() {
        String base = spInfinitive.substring(0, spInfinitive.length() - 2);
        String yo = base + "o";
        return yo;
    }

    public String getTuForm() {
        String base = spInfinitive.substring(0, spInfinitive.length() - 2);
        String end = spInfinitive.substring(spInfinitive.length() - 2);
        String tu;
        if (end.equals("ar"))
            tu = base + "as";
        else
            tu = base + "es";
        return tu;
    }

    public String getUstedForm() {
        String base = spInfinitive.substring(0, spInfinitive.length() - 2);
        String end = spInfinitive.substring(spInfinitive.length() - 2);
        String usted;
        if (end.equals("ar"))
            usted = base + "a";
        else
            usted = base + "e";
        return usted;
    }

    public String getNosotrosForm() {
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

    public String getUstedesForm() {
        String base = spInfinitive.substring(0, spInfinitive.length() - 2);
        String end = spInfinitive.substring(spInfinitive.length() - 2);
        String ustedes;
        if (end.equals("ar"))
            ustedes = base + "an";
        else
            ustedes = base + "en";
        return ustedes;
    }


}
