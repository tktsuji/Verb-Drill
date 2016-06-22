package blackbox.verbdrop;

import java.security.acl.Group;
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
            new IrregVerbPres  ("be", "ser", "soy", "eres", "es", "somos", "son",
                                "am", "are", "is", "are", "are"),
            new RegularVerbPres("eat", "comer"),
            new RegularVerbPres("listen", "escuchar"),
            new RegularVerbPres("live", "vivir"),
            new RegularVerbPres("speak", "hablar")
   };

    private static final Verb[] Group2Present = {
            new RegularVerbPres("help", "ayudar"),
            new RegularVerbPres("read", "leer"),
            new RegularVerbPres("run", "correr"),
            new IrregVerbPres  ("see", "ver", "veo", "ves", "ve", "vemos", "ven"),
            new IrregVerbPres("think", "pensar", "pienso", "piensas", "piensa", "pensamos", "piensan")
    };

    private static final Verb[] Group3Present = {
            new RegularVerbPres("arrive", "llegar"),
            new RegularVerbPres("believe", "creer"),
            new RegularVerbPres("call", "llamar"),
            new RegularVerbPres("wear", "llevar"),
            new IrregVerbPres  ("go", "ir", "voy", "vas", "va", "vamos", "van",
                                "go", "go", "goes", "go", "go"),
    };

    private static final Verb[] Group4Present = {
            new IrregVerbPres  ("have", "tener", "tengo", "tienes", "tiene", "tenemos", "tienen",
                    "have", "have", "has", "have", "have"),
            new RegularVerbPres("pay", "pagar"),
            new RegularVerbPres("study", "estudiar", "studies"),
            new IrregVerbPres  ("want", "querer", "quiero", "quieres", "quiere", "queremos", "quieren"),
            new RegularVerbPres("work", "trabajar")
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
            if (verbList[i].getClass().toString().equals("class blackbox.verbdrop.RegularVerbPres") && isRegPres)
                newList.add(verbList[i]);
            if (verbList[i].getClass().toString().equals("class blackbox.verbdrop.IrregVerbPres") && isIrregPres)
                newList.add(verbList[i]);
        }
        return newList.toArray(new Verb[newList.size()]);
    }

}
