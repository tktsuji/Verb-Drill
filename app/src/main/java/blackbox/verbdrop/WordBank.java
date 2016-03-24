package blackbox.verbdrop;

/**
 * Created by tricia on 3/21/16.
 */
public class WordBank {
    private static int numWords;
   // Regular -ar verbs
    private static final Verb[] regArVerbs = {
           new Verb("arrive", "llegar"),
           new Verb("help", "ayudar"),
           new Verb("listen", "escuchar"),
           new Verb("speak", "hablar"),
           new Verb("work", "trabajar")

   };

    // Regular -er verbs
    private static final Verb[] regErVerbs = {
            new Verb("believe", "creer"),
            new Verb("eat", "comer"),
            new Verb("read", "leer"),
            new Verb("run", "correr")
    };

    // Regular -ir verbs
    private static final Verb[] regIrVerbs = {
            new Verb("live", "vivir")
    };

    public WordBank() {
        numWords = regArVerbs.length + regErVerbs.length + regIrVerbs.length;
    }

    public int getNumWords() {
        return numWords;
    }

    public Verb[] getAllVerbs() {
        Verb[] allVerbs = new Verb[numWords];
        int i;

        for (i = 0; i < regArVerbs.length; i++) {
            allVerbs[i] = regArVerbs[i];
        }

        for (int j = 0; j < regErVerbs.length; j++) {
            allVerbs[i] = regErVerbs[j];
            ++i;
        }

        for (int k = 0; k < regIrVerbs.length; k++) {
            allVerbs[i] = regIrVerbs[k];
            ++i;
        }

        return allVerbs;
    }

    public Verb[] getRegArVerbs() {
        return regArVerbs;
    }

    public Verb[] getRegErVerbs() {
        return regErVerbs;
    }

    public Verb[] getRegIrVerbs() {
        return regIrVerbs;
    }

}
