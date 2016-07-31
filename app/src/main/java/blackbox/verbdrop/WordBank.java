package blackbox.verbdrop;

import java.util.ArrayList;

/**
 *  Contains all verbs that can be used in Game, divided into groups that
 *  can be selected on/off through Settings.
 */
public class WordBank {
    private static int numWords;
    private static Verb[] allVerbs;
    private final static int NUM_GROUPS = 4;
    private final static int NUM_VERBS_PER_GROUP = 10;

    private static final Verb[] Group1Present = {
            // PRESENT
            new IrregVerbPresent("be", "ser", "soy", "eres", "es", "somos", "son",
                                              "am", "are", "is", "are", "are"),
            new RegVerbPresent("eat", "comer"),
            new RegVerbPresent("listen", "escuchar"),
            new RegVerbPresent("live", "vivir"),
            new RegVerbPresent("speak", "hablar"),

            // PRETERITE
            new IrregVerbPreterite("be", "ser", "fui", "fuiste", "fue", "fuimos", "fueron",
                                                "was", "were", "was", "were", "were"),
            new RegVerbPreterite("ate", "comer"),
            new RegVerbPreterite("listened", "escuchar"),
            new RegVerbPreterite("lived", "vivir"),
            new RegVerbPreterite("spoke", "hablar")
   };

    private static final Verb[] Group2Present = {
            // PRESENT
            new RegVerbPresent("help", "ayudar"),
            new RegVerbPresent("read", "leer"),
            new RegVerbPresent("run", "correr"),
            new IrregVerbPresent("see", "ver", "veo", "ves", "ve", "vemos", "ven"),
            new IrregVerbPresent("think", "pensar", "pienso", "piensas", "piensa", "pensamos", "piensan"),

            // PRETERITE
            new RegVerbPreterite("helped", "ayudar"),
            new IrregVerbPreterite("read", "leer", "le\u00ED", "le\u00EDste", "ley\u00F3", "le\u00EDmos", "leyeron"),
            new RegVerbPreterite("ran", "correr"),
            new IrregVerbPreterite("saw", "ver", "vi", "viste", "vio", "vimos", "vieron"),
            new RegVerbPreterite("thought", "pensar")
    };

    private static final Verb[] Group3Present = {
            // PRESENT
            new RegVerbPresent("arrive", "llegar"),
            new RegVerbPresent("believe", "creer"),
            new RegVerbPresent("call", "llamar"),
            new RegVerbPresent("wear", "llevar"),
            new IrregVerbPresent("go", "ir", "voy", "vas", "va", "vamos", "van",
                                "go", "go", "goes", "go", "go"),

            // PRETERITE
            new IrregVerbPreterite("arrived", "llegar", "llegu\u00E9", "llegaste", "lleg\u00F3", "llegamos", "llegaron"),
            new IrregVerbPreterite("believed", "creer", "cre\u00ED", "cre\u00EDste", "crey\u00F3", "cre\u00EDmos", "creyeron"),
            new RegVerbPreterite("called", "llamar"),
            new RegVerbPreterite("wore", "llevar"),
            new IrregVerbPreterite("went", "ir", "fui", "fuiste", "fue", "fuimos", "fueron")
    };

    private static final Verb[] Group4Present = {
            // PRESENT
            new IrregVerbPresent("have", "tener", "tengo", "tienes", "tiene", "tenemos", "tienen",
                    "have", "have", "has", "have", "have"),
            new RegVerbPresent("pay", "pagar"),
            new RegVerbPresent("study", "estudiar", "studies"),
            new IrregVerbPresent("want", "querer", "quiero", "quieres", "quiere", "queremos", "quieren"),
            new RegVerbPresent("work", "trabajar"),

            // PRETERITE
            new IrregVerbPreterite("had", "tener", "tuve", "tuviste", "tuvo", "tuvimos", "tuvieron"),
            new IrregVerbPreterite("paid", "pagar", "pagu\u00E9", "pagaste", "pag\u00F3", "pagamos", "pagaron"),
            new RegVerbPreterite("studied", "estudiar"),
            new IrregVerbPreterite("wanted", "querer", "quise", "quisiste", "quiso", "quisimos", "quisieron"),
            new RegVerbPreterite("worked", "trabajar")
    };

    public WordBank() {
        numWords = Group1Present.length +
                   Group2Present.length +
                   Group3Present.length +
                   Group4Present.length;
        allVerbs = getAllVerbs();
    }

    public int getNumWords() {
        return numWords;
    }

    public Verb[] getAllVerbs() {
        Verb[] allVerbs = new Verb[numWords];
        int i = 0;

        for (int j = 0; j < Group1Present.length; j++) {
            allVerbs[i++] = Group1Present[j];
        }

        for (int j = 0; j < Group2Present.length; j++) {
            allVerbs[i++] = Group2Present[j];
        }

        for (int j = 0; j< Group3Present.length; j++) {
            allVerbs[i++] = Group3Present[j];
        }

        for (int j = 0; j < Group4Present.length; j++) {
            allVerbs[i++] = Group4Present[j];
        }
        return allVerbs;
    }

    public Verb[] getSelectedVerbs(boolean[] isSelected, int groupsSelected) {
        Verb[] selectedVerbs = new Verb[groupsSelected * NUM_VERBS_PER_GROUP];
        int v = 0;
        for (int i = 0; i < NUM_GROUPS; i++) {
            if (isSelected[i]) {
                for (int j = i * NUM_VERBS_PER_GROUP; j < i * NUM_VERBS_PER_GROUP + NUM_VERBS_PER_GROUP; j++)
                    selectedVerbs[v++] = allVerbs[j];
            }
        }
        return selectedVerbs;
    }

    public Verb[] removeTense(Verb[] verbList, boolean isRegPres, boolean isIrregPres, boolean isRegPret, boolean isIrregPret) {
        ArrayList<Verb> newList = new ArrayList<Verb>();
        for (int i = 0; i < verbList.length; i++) {
            if (verbList[i].getClass().toString().equals("class blackbox.verbdrop.RegVerbPresent") && isRegPres)
                newList.add(verbList[i]);
            if (verbList[i].getClass().toString().equals("class blackbox.verbdrop.IrregVerbPresent") && isIrregPres)
                newList.add(verbList[i]);
            if (verbList[i].getClass().toString().equals("class blackbox.verbdrop.RegVerbPreterite") && isRegPret)
                newList.add(verbList[i]);
            if (verbList[i].getClass().toString().equals("class blackbox.verbdrop.IrregVerbPreterite") && isIrregPret)
                newList.add(verbList[i]);
        }
        return newList.toArray(new Verb[newList.size()]);
    }

}
