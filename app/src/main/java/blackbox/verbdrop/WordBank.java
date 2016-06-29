package blackbox.verbdrop;

import java.util.ArrayList;

/**
 * Created by tricia on 3/21/16.
 */
public class WordBank {
    private static int numWords;
    private static Verb[] allVerbs;
    private final static int NUM_GROUPS = 4;
    private final static int NUM_VERBS_PER_GROUP = 5;

    private static final Verb[] Group1Present = {
            new IrregVerbPresent("be", "ser", "soy", "eres", "es", "somos", "son",
                                "am", "are", "is", "are", "are"),
            new RegVerbPresent("eat", "comer"),
            new RegVerbPresent("listen", "escuchar"),
            new RegVerbPresent("live", "vivir"),
            new RegVerbPresent("speak", "hablar")
   };

    private static final Verb[] Group2Present = {
            new RegVerbPresent("help", "ayudar"),
            new RegVerbPresent("read", "leer"),
            new RegVerbPresent("run", "correr"),
            new IrregVerbPresent("see", "ver", "veo", "ves", "ve", "vemos", "ven"),
            new IrregVerbPresent("think", "pensar", "pienso", "piensas", "piensa", "pensamos", "piensan")
    };

    private static final Verb[] Group3Present = {
            new RegVerbPresent("arrive", "llegar"),
            new RegVerbPresent("believe", "creer"),
            new RegVerbPresent("call", "llamar"),
            new RegVerbPresent("wear", "llevar"),
            new IrregVerbPresent("go", "ir", "voy", "vas", "va", "vamos", "van",
                                "go", "go", "goes", "go", "go"),
    };

    private static final Verb[] Group4Present = {
            new IrregVerbPresent("have", "tener", "tengo", "tienes", "tiene", "tenemos", "tienen",
                    "have", "have", "has", "have", "have"),
            new RegVerbPresent("pay", "pagar"),
            new RegVerbPresent("study", "estudiar", "studies"),
            new IrregVerbPresent("want", "querer", "quiero", "quieres", "quiere", "queremos", "quieren"),
            new RegVerbPresent("work", "trabajar")
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

    public Verb[] removeTense(Verb[] verbList, boolean isRegPres, boolean isIrregPres) {
        ArrayList<Verb> newList = new ArrayList<Verb>();
        for (int i = 0; i < verbList.length; i++) {
            if (verbList[i].getClass().toString().equals("class blackbox.verbdrop.RegVerbPresent") && isRegPres)
                newList.add(verbList[i]);
            if (verbList[i].getClass().toString().equals("class blackbox.verbdrop.IrregVerbPresent") && isIrregPres)
                newList.add(verbList[i]);
        }
        return newList.toArray(new Verb[newList.size()]);
    }

}
