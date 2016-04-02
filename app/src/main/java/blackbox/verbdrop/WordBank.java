package blackbox.verbdrop;

import java.security.acl.Group;

/**
 * Created by tricia on 3/21/16.
 */
public class WordBank {
    private static int numWords;

    private static final Verb[] Group1Present = {
            new IrregVerbPres  ("be", "ser", "soy", "eres", "es", "somos", "son",
                                "am", "are", "is", "are", "are"),
            new RegularVerbPres("eat", "comer"),
            new RegularVerbPres("help", "ayudar"),
            new RegularVerbPres("listen", "escuchar"),
            new RegularVerbPres("live", "vivir"),
            new RegularVerbPres("read", "leer"),
            new RegularVerbPres("run", "correr"),
            new RegularVerbPres("speak", "hablar"),
            new IrregVerbPres  ("see", "ver", "veo", "ves", "ve", "vemos", "ven"),
            new IrregVerbPres("think", "pensar", "pienso", "piensas", "piensa", "pensamos", "piensan")
   };

    private static final Verb[] Group2Present = {
            new RegularVerbPres("arrive", "llegar"),
            new RegularVerbPres("believe", "creer"),
            new RegularVerbPres("call", "llamar"),
            new RegularVerbPres("carry/wear", "llevar"),
            new IrregVerbPres  ("go", "ir", "voy", "vas", "va", "vamos", "van",
                                "go", "go", "goes", "go", "go"),
            new IrregVerbPres  ("have", "tener", "tengo", "tienes", "tiene", "tenemos", "tienen",
                                "have", "have", "has", "have", "have"),
            new RegularVerbPres("pay", "pagar"),
            new RegularVerbPres("study", "estudiar", "studies"),
            new IrregVerbPres  ("want", "querer", "quiero", "quieres", "quiere", "queremos", "quieren"),
            new RegularVerbPres("work", "trabajar")
    };



    public WordBank() {
        numWords = Group1Present.length + Group2Present.length;
    }

    public int getNumWords() {
        return numWords;
    }

    public Verb[] getAllVerbs() {
        Verb[] allVerbs = new Verb[numWords];
        int i;

        for (i = 0; i < Group1Present.length; i++) {
            allVerbs[i] = Group1Present[i];
        }

        for (int j = 0; j < Group2Present.length; j++) {
            allVerbs[i] = Group2Present[j];
            ++i;
        }
        return allVerbs;
    }

}
