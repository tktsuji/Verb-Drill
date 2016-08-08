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
    private final static int NUM_VERBS_PER_GROUP = 15;

    private static final Verb[] Group1Present = {
            // PRESENT
            new RegVerbPresent("eat", "comer"),
            new RegVerbPresent("speak", "hablar"),
            new RegVerbPresent("listen", "escuchar"),
            new RegVerbPresent("study", "estudiar", "studies"),
            new IrregVerbPresent("be", "ser", "soy", "eres", "es", "somos", "son",
                                              "am", "are", "is", "are", "are"),

            // PRETERITE
            new RegVerbPreterite("ate", "comer"),
            new RegVerbPreterite("spoke", "hablar"),
            new RegVerbPreterite("listened", "escuchar"),
            new RegVerbPreterite("studied", "estudiar"),
            new IrregVerbPreterite("be", "ser", "fui", "fuiste", "fue", "fuimos", "fueron",
                    "was", "were", "was", "were", "were"),

            // FUTURE
            new RegVerbFuture("will eat", "comer"),
            new RegVerbFuture("will speak", "hablar"),
            new RegVerbFuture("will listen", "escuchar"),
            new RegVerbFuture("will study", "estudiar"),
            new RegVerbFuture("will be", "ser")
   };

    private static final Verb[] Group2Present = {
            // PRESENT
            new IrregVerbPresent("be", "estar", "estoy", "estás", "está", "estamos", "están",
                    "am", "are", "is", "are", "are"),
            new RegVerbPresent("read", "leer"),
            new RegVerbPresent("call", "llamar"),
            new RegVerbPresent("work", "trabajar"),
            new RegVerbPresent("live", "vivir"),

            // PRETERITE
            new IrregVerbPreterite("be", "estar", "estuve", "estuviste", "estuvo", "estuvimos", "estuvieron",
                    "was", "were", "was", "were", "were"),
            new IrregVerbPreterite("read", "leer", "leí", "leíste", "leyó", "leímos", "leyeron"),
            new RegVerbPreterite("called", "llamar"),
            new RegVerbPreterite("worked", "trabajar"),
            new RegVerbPreterite("lived", "vivir"),

            // FUTURE
            new RegVerbFuture("will be", "estar"),
            new RegVerbFuture("will read", "leer"),
            new RegVerbFuture("will call", "llamar"),
            new RegVerbFuture("will work", "trabajar"),
            new RegVerbFuture("will live", "vivir")
    };

    private static final Verb[] Group3Present = {
            // PRESENT
            new RegVerbPresent("help", "ayudar"),
            new RegVerbPresent("write", "escribir"),
            new IrregVerbPresent("go", "ir", "voy", "vas", "va", "vamos", "van",
                                "go", "go", "goes", "go", "go"),
            new RegVerbPresent("arrive", "llegar"),
            new IrregVerbPresent("see", "ver", "veo", "ves", "ve", "vemos", "ven"),

            // PRETERITE
            new RegVerbPreterite("helped", "ayudar"),
            new RegVerbPreterite("wrote", "escribir"),
            new IrregVerbPreterite("went", "ir", "fui", "fuiste", "fue", "fuimos", "fueron"),
            new IrregVerbPreterite("arrived", "llegar", "llegué", "llegaste", "llegó", "llegamos", "llegaron"),
            new IrregVerbPreterite("saw", "ver", "vi", "viste", "vio", "vimos", "vieron"),

            // FUTURE
            new RegVerbFuture("will help", "ayudar"),
            new RegVerbFuture("will write", "escribir"),
            new RegVerbFuture("will go", "ir"),
            new RegVerbFuture("will arrive", "llegar"),
            new RegVerbFuture("will see", "ver")
    };

    private static final Verb[] Group4Present = {
            // PRESENT
            new RegVerbPresent("walk", "caminar"),
            new RegVerbPresent("wear", "llevar"),
            new RegVerbPresent("pay", "pagar"),
            new IrregVerbPresent("have", "tener", "tengo", "tienes", "tiene", "tenemos", "tienen",
                    "have", "have", "has", "have", "have"),
            new IrregVerbPresent("want", "querer", "quiero", "quieres", "quiere", "queremos", "quieren"),


            // PRETERITE
            new RegVerbPreterite("walked", "caminar"),
            new RegVerbPreterite("wore", "llevar"),
            new IrregVerbPreterite("paid", "pagar", "pagué", "pagaste", "pagó", "pagamos", "pagaron"),
            new IrregVerbPreterite("had", "tener", "tuve", "tuviste", "tuvo", "tuvimos", "tuvieron"),
            new IrregVerbPreterite("wanted", "querer", "quise", "quisiste", "quiso", "quisimos", "quisieron"),

            // FUTURE
            new RegVerbFuture("will walk", "caminar"),
            new RegVerbFuture("will wear", "llevar"),
            new RegVerbFuture("will pay", "pagar"),
            new IrregVerbFuture("will have", "tener", "tendré", "tendrás", "tendrá", "tendremos", "tendrán"),
            new IrregVerbFuture("will want", "querer", "querré", "querrás", "querrá", "querremos", "querrán")
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

    public Verb[] removeTense(Verb[] verbList, boolean isRegPres, boolean isIrregPres, boolean isRegPret, boolean isIrregPret,
                                boolean isRegFut, boolean isIrregFut) {
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
            if (verbList[i].getClass().toString().equals("class blackbox.verbdrop.RegVerbFuture") && isRegFut)
                newList.add(verbList[i]);
            if (verbList[i].getClass().toString().equals("class blackbox.verbdrop.IrregVerbFuture") && isIrregFut)
                newList.add(verbList[i]);
        }
        return newList.toArray(new Verb[newList.size()]);
    }

}
