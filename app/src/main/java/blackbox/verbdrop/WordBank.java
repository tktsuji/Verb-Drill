package blackbox.verbdrop;

import java.util.ArrayList;

/**
 *  Contains all verbs that can be used in Game, divided into groups that
 *  can be selected on/off through Settings.
 */
public class WordBank {
    private static int numWords;
    private static Verb[] allVerbs;
        private final static int NUM_GROUPS = 20;
    private final static int NUM_VERBS_PER_GROUP = 15;

        private static final Verb[] Group1 = {
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

        private static final Verb[] Group2 = {
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

        private static final Verb[] Group3 = {
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

        private static final Verb[] Group4 = {
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

        private static final Verb[] Group5 = {
                // PRESENT
                new RegVerbPresent("drink", "beber"),
                new RegVerbPresent("cook", "cocinar"),
                new IrregVerbPresent("say", "decir", "digo", "dices", "dice", "decimos", "dicen"),
                new IrregVerbPresent("understand", "entender", "entiendo", "entiendes", "entiende", "entendemos", "entienden"),
                new RegVerbPresent("ask", "preguntar"),

                // PRETERITE
                new RegVerbPreterite("drank", "beber"),
                new RegVerbPreterite("cooked", "cocinar"),
                new IrregVerbPreterite("said", "decir", "dije", "dijiste", "dijo", "dijimos", "dijeron"),
                new RegVerbPreterite("understood", "entender"),
                new RegVerbPreterite("asked", "preguntar"),

                // FUTURE
                new RegVerbFuture("will drink", "beber"),
                new RegVerbFuture("will cook", "cocinar"),
                new IrregVerbFuture("will say", "decir", "diré", "dirás", "dirá", "diremos", "dirán"),
                new RegVerbFuture("will understand", "entender"),
                new RegVerbFuture("will ask", "preguntar")
        };

        private static final Verb[] Group6 = {
                // PRESENT
                new RegVerbPresent("search", "buscar", "searches"),
                new RegVerbPresent("run", "correr"),
                new IrregVerbPresent("do", "hacer", "hago", "haces", "hace", "hacemos", "hacen",
                        "do", "do", "does", "do", "do"),
                new RegVerbPresent("swim", "nadar"),
                new IrregVerbPresent("hear", "oír", "oigo", "oyes", "oye", "oímos", "oyen"),

                // PRETERITE
                new IrregVerbPreterite("searched", "buscar", "busqué", "buscaste", "buscó", "buscamos", "buscaron"),
                new RegVerbPreterite("ran", "correr"),
                new IrregVerbPreterite("did", "hacer", "hice", "hiciste", "hizo", "hicimos", "hicieron"),
                new RegVerbPreterite("swam", "nadar"),
                new IrregVerbPreterite("heard", "oír", "oí", "oíste", "oyó", "oímos", "oyeron"),

                // FUTURE
                new RegVerbFuture("will search", "buscar"),
                new RegVerbFuture("will run", "correr"),
                new IrregVerbFuture("will do", "hacer", "haré", "harás", "hará", "haremos", "harán"),
                new RegVerbFuture("will swim", "nadar"),
                new IrregVerbFuture("will hear", "oír", "oiré", "oirás", "oirá", "oiremos", "oirán"),
        };

        private static final Verb[] Group7 = {
                // PRESENT
                new RegVerbPresent("learn", "aprender"),
                new IrregVerbPresent("know", "conocer", "conozco", "conoces", "conoce", "conocemos", "conocen"),
                new RegVerbPresent("need", "necesitar"),
                new IrregVerbPresent("know", "saber", "sé", "sabes", "sabe", "sabemos", "saben"),
                new RegVerbPresent("touch", "tocar", "touches"),

                // PRETERITE
                new RegVerbPreterite("learned", "aprender"),
                new RegVerbPreterite("knew", "conocer"),
                new RegVerbPreterite("needed", "necesitar"),
                new IrregVerbPreterite("knew", "saber", "supe", "supiste", "supo", "supimos", "supieron"),
                new IrregVerbPreterite("touched", "tocar", "toqué", "tocaste", "tocó", "tocamos", "tocaron"),

                // FUTURE
                new RegVerbFuture("will learn", "aprender"),
                new RegVerbFuture("will know", "conocer"),
                new RegVerbFuture("will need", "necesitar"),
                new IrregVerbFuture("will know", "saber", "sabré", "sabrás", "sabrá", "sabremos", "sabrán"),
                new RegVerbFuture("will touch", "tocar")
        };

        private static final Verb[] Group8 = {
                // PRESENT
                new IrregVerbPresent("sleep", "dormir", "duermo", "duermes", "duerme", "dormimos", "duermen"),
                new IrregVerbPresent("find", "encontrar", "encuentro", "encuentras", "encuentra", "encontramos", "encuentran"),
                new IrregVerbPresent("play", "jugar", "juego", "juegas", "juega", "jugamos", "juegan"),
                new RegVerbPresent("pass", "pasar", "passes"),
                new RegVerbPresent("take", "tomar"),

                // PRETERITE
                new IrregVerbPreterite("slept", "dormir", "dormí", "dormiste", "durmió", "dormimos", "durmieron"),
                new RegVerbPreterite("found", "encontrar"),
                new IrregVerbPreterite("played", "jugar", "jugué", "jugaste", "jugó", "jugamos", "jugaron"),
                new RegVerbPreterite("passed", "pasar"),
                new RegVerbPreterite("took", "tomar"),

                // FUTURE
                new RegVerbFuture("will sleep", "dormir"),
                new RegVerbFuture("will find", "encontrar"),
                new RegVerbFuture("will play", "jugar"),
                new RegVerbFuture("will pass", "pasar"),
                new RegVerbFuture("will take", "tomar")
        };

        private static final Verb[] Group9 = {
                // PRESENT
                new IrregVerbPresent("begin", "comenzar", "comienzo", "comienzas", "comienza", "comenzamos", "comienzan"),
                new IrregVerbPresent("begin", "empezar", "empiezo", "empiezas", "empieza", "empezamos", "empiezan"),
                new IrregVerbPresent("think", "pensar", "pienso", "piensas", "piensa", "pensamos", "piensan"),
                new IrregVerbPresent("be able to", "poder", "puedo", "puedes", "puede", "podemos", "pueden",
                        "can", "can", "can", "can", "can"),
                new RegVerbPresent("end", "terminar"),

                // PRETERITE
                new IrregVerbPreterite("began", "comenzar", "comencé", "comenzaste", "comenzó", "comenzamos", "comenzaron"),
                new IrregVerbPreterite("began", "empezar", "empecé", "empezaste", "empezó", "empezamos", "empezaron"),
                new RegVerbPreterite("thought", "pensar"),
                new IrregVerbPreterite("was able to", "poder", "pude", "pudiste", "pudo", "pudimos", "pudieron"),
                new RegVerbPreterite("ended", "terminar"),

                // FUTURE
                new RegVerbFuture("will begin", "comenzar"),
                new RegVerbFuture("will begin", "empezar"),
                new RegVerbFuture("will think", "pensar"),
                new IrregVerbFuture("will be able to", "poder", "podré", "podrás", "podrá", "podremos", "podrán"),
                new RegVerbFuture("will end", "terminar")
        };

        private static final Verb[] Group10 = {
                // PRESENT
                new RegVerbPresent("open", "abrir"),
                new IrregVerbPresent("close", "cerrar", "cierro", "cierras", "cierra", "cerramos", "cierran"),
                new RegVerbPresent("buy", "comprar"),
                new IrregVerbPresent("come", "venir", "vengo", "vienes", "viene", "venimos", "vienen"),
                new IrregVerbPresent("leave", "salir", "salgo", "sales", "sale", "salimos", "salen"),

                // PRETERITE
                new RegVerbPreterite("opened", "abrir"),
                new RegVerbPreterite("closed", "cerrar"),
                new RegVerbPreterite("bought", "comprar"),
                new IrregVerbPreterite("came", "venir", "vine", "viniste", "vino", "vinimos", "vinieron"),
                new RegVerbPreterite("left", "salir"),

                // FUTURE
                new RegVerbFuture("will open", "abrir"),
                new RegVerbFuture("will close", "cerrar"),
                new RegVerbFuture("will buy", "comprar"),
                new IrregVerbFuture("will come", "venir", "vendré", "vendrás", "vendrá", "vendremos", "vendrán"),
                new IrregVerbFuture("will leave", "salir", "saldré", "saldrás", "saldrá", "saldremos", "saldrán")
        };

        private static final Verb[] Group11 = {
                // PRESENT
                new RegVerbPresent("answer", "contestar"),
                new RegVerbPresent("draw", "dibujar"),
                new RegVerbPresent("teach", "enseñar", "teaches"),
                new RegVerbPresent("explain", "explicar"),
                new RegVerbPresent("sign", "firmar"),

                // PRETERITE
                new RegVerbPreterite("answered", "contestar"),
                new RegVerbPreterite("drew", "dibujar"),
                new RegVerbPreterite("taught", "enseñar"),
                new IrregVerbPreterite("explained", "explicar", "expliqué", "explicaste", "explicó", "explicamos", "explicaron"),
                new RegVerbPreterite("signed", "firmar"),

                // FUTURE
                new RegVerbFuture("will answer", "contestar"),
                new RegVerbFuture("will draw", "dibujar"),
                new RegVerbFuture("will teach", "enseñar"),
                new RegVerbFuture("will explain", "explicar"),
                new RegVerbFuture("will sign", "firmar")
        };

        private static final Verb[] Group12 = {
                // PRESENT
                new RegVerbPresent("accept", "aceptar"),
                new IrregVerbPresent("give", "dar", "doy", "das", "da", "damos", "dan"),
                new RegVerbPresent("leave", "dejar"),
                new RegVerbPresent("present", "presentar"),
                new RegVerbPresent("receive", "recibir"),

                // PRETERITE
                new RegVerbPreterite("accepted", "aceptar"),
                new IrregVerbPreterite("gave", "dar", "di", "diste", "dio", "dimos", "dieron"),
                new RegVerbPreterite("left", "dejar"),
                new RegVerbPreterite("presented", "presentar"),
                new RegVerbPreterite("received", "recibir"),

                // FUTURE
                new RegVerbFuture("will accept", "aceptar"),
                new RegVerbFuture("will give", "dar"),
                new RegVerbFuture("will leave", "dejar"),
                new RegVerbFuture("will present", "presentar"),
                new RegVerbFuture("will receive", "recibir")
        };

        private static final Verb[] Group13 = {
                // PRESENT
                new RegVerbPresent("wait", "esperar"),
                new RegVerbPresent("look", "mirar"),
                new RegVerbPresent("allow", "permitir"),
                new IrregVerbPresent("put", "poner", "pongo", "pones", "pone", "ponemos", "ponen"),
                new RegVerbPresent("treat", "tratar"),

                // PRETERITE
                new RegVerbPreterite("waited", "esperar"),
                new RegVerbPreterite("looked", "mirar"),
                new RegVerbPreterite("allowed", "permitir"),
                new IrregVerbPreterite("put", "poner", "puse", "pusiste", "puso", "pusimos", "pusieron"),
                new RegVerbPreterite("treated", "tratar"),

                // FUTURE
                new RegVerbFuture("will wait", "esperar"),
                new RegVerbFuture("will look", "mirar"),
                new RegVerbFuture("will allow", "permitir"),
                new IrregVerbFuture("will put", "poner", "pondré", "pondrás", "pondrá", "pondremos", "pondrán"),
                new RegVerbFuture("will treat", "tratar")
        };

        private static final Verb[] Group14 = {
                // PRESENT
                new RegVerbPresent("believe", "creer"),
                new RegVerbPresent("owe", "deber"),
                new IrregVerbPresent("seem", "parecer", "parezco", "pareces", "parece", "parecemos", "parecen"),
                new IrregVerbPresent("feel", "sentir", "siento", "sientes", "siente", "sentimos", "sienten"),
                new IrregVerbPresent("dream", "soñar", "sueño", "sueñas", "sueña", "soñamos", "sueñan"),

                // PRETERITE
                new IrregVerbPreterite("believed", "creer", "creí", "creíste", "creyó", "creímos", "creyeron"),
                new RegVerbPreterite("owed", "deber"),
                new RegVerbPreterite("seemed", "parecer"),
                new IrregVerbPreterite("felt", "sentir", "sentí", "sentiste", "sintió", "sentimos", "sintieron"),
                new RegVerbPreterite("dreamt", "soñar"),

                // FUTURE
                new RegVerbFuture("will believe", "creer"),
                new RegVerbFuture("will owe", "deber"),
                new RegVerbFuture("will seem", "parecer"),
                new RegVerbFuture("will feel", "sentir"),
                new RegVerbFuture("will dream", "soñar")
        };

        private static final Verb[] Group15 = {
                // PRESENT
                new IrregVerbPresent("drive", "conducir", "conduzco", "conduces", "conduce", "conducimos", "conducen"),
                new RegVerbPresent("enter", "entrar"),
                new IrregVerbPresent("follow", "seguir", "sigo", "sigues", "sigue", "seguimos", "siguen"),
                new RegVerbPresent("visit", "visitar"),
                new IrregVerbPresent("return", "volver", "vuelvo", "vuelves", "vuelve", "volvemos", "vuelven"),

                // PRETERITE
                new IrregVerbPreterite("drove", "conducir", "conduje", "condujiste", "condujo", "condujimos", "condujeron"),
                new RegVerbPreterite("entered", "entrar"),
                new IrregVerbPreterite("followed", "seguir", "seguí", "seguiste", "siguió", "seguimos", "siguieron"),
                new RegVerbPreterite("visited", "visitar"),
                new RegVerbPreterite("returned", "volver"),

                // FUTURE
                new RegVerbFuture("will drive", "conducir"),
                new RegVerbFuture("will enter", "entrar"),
                new RegVerbFuture("will follow", "seguir"),
                new RegVerbFuture("will visit", "visitar"),
                new RegVerbFuture("will return", "volver")
        };

        private static final Verb[] Group16 = {
                // PRESENT
                new RegVerbPresent("dance", "bailar"),
                new RegVerbPresent("sing", "cantar"),
                new RegVerbPresent("win", "ganar"),
                new RegVerbPresent("try", "intentar", "tries"),
                new IrregVerbPresent("lose", "perder", "pierdo", "pierdes", "pierde", "perdemos", "pierden"),

                // PRETERITE
                new RegVerbPreterite("danced", "bailar"),
                new RegVerbPreterite("sang", "cantar"),
                new RegVerbPreterite("won", "ganar"),
                new RegVerbPreterite("tried", "intentar"),
                new RegVerbPreterite("lost", "perder"),

                // FUTURE
                new RegVerbFuture("will dance", "bailar"),
                new RegVerbFuture("will sing", "cantar"),
                new RegVerbFuture("will win", "ganar"),
                new RegVerbFuture("will try", "intentar"),
                new RegVerbFuture("will lose", "perder")
        };

        private static final Verb[] Group17 = {
                // PRESENT
                new RegVerbPresent("cut", "cortar"),
                new RegVerbPresent("clean", "limpiar"),
                new RegVerbPresent("forget", "olvidar"),
                new RegVerbPresent("break", "romper"),
                new IrregVerbPresent("remember", "recordar", "recuerdo", "recuerdas", "recuerda", "recordamos", "recuerdan"),

                // PRETERITE
                new RegVerbPreterite("cut", "cortar"),
                new RegVerbPreterite("cleaned", "limpiar"),
                new RegVerbPreterite("forgot", "olvidar"),
                new RegVerbPreterite("broke", "romper"),
                new RegVerbPreterite("remembered", "recordar"),

                // FUTURE
                new RegVerbFuture("will cut", "cortar"),
                new RegVerbFuture("will clean", "limpiar"),
                new RegVerbFuture("will forget", "olvidar"),
                new RegVerbFuture("will break", "romper"),
                new RegVerbFuture("will remember", "recordar")
        };

        private static final Verb[] Group18 = {
                // PRESENT
                new RegVerbPresent("consider", "considerar"),
                new IrregVerbPresent("count", "contar", "cuento", "cuentas", "cuenta", "contamos", "cuentan"),
                new IrregVerbPresent("ask for", "pedir", "pido", "pides", "pide", "pedimos", "piden",
                        "ask for", "ask for", "asks for", "ask for", "ask for"),
                new IrregVerbPresent("serve", "servir", "sirvo", "sirves", "sirve", "servimos", "sirven"),
                new RegVerbPresent("sell", "vender"),

                // PRETERITE
                new RegVerbPreterite("considered", "considerar"),
                new RegVerbPreterite("counted", "contar"),
                new IrregVerbPreterite("asked for", "pedir", "pedí", "pediste", "pidió", "pedimos", "pidieron"),
                new IrregVerbPreterite("served", "servir", "serví", "serviste", "sirvió", "servimos", "sirvieron"),
                new RegVerbPreterite("sold", "vender"),

                // FUTURE
                new RegVerbFuture("will consider", "considerar"),
                new RegVerbFuture("will count", "contar"),
                new RegVerbFuture("will ask for", "pedir"),
                new RegVerbFuture("will serve", "servir"),
                new RegVerbFuture("will sell", "vender")
        };

        private static final Verb[] Group19 = {
                // PRESENT
                new RegVerbPresent("change", "cambiar"),
                new RegVerbPresent("depend", "depender"),
                new IrregVerbPresent("include", "incluir", "incluyo", "incluyes", "incluye", "incluimos", "incluyen"),
                new RegVerbPresent("achieve", "lograr"),
                new IrregVerbPresent("bring", "traer", "traigo", "traes", "trae", "traemos", "traen"),

                // PRETERITE
                new RegVerbPreterite("changed", "cambiar"),
                new RegVerbPreterite("depended", "depender"),
                new IrregVerbPreterite("included", "incluir", "incluí", "incluiste", "incluyó", "incluimos", "incluyeron"),
                new RegVerbPreterite("achieved", "lograr"),
                new IrregVerbPreterite("brought", "traer", "traje", "trajiste", "trajo", "trajimos", "trajeron"),

                // FUTURE
                new RegVerbFuture("will change", "cambiar"),
                new RegVerbFuture("will depend", "depender"),
                new RegVerbFuture("will include", "incluir"),
                new RegVerbFuture("will achieve", "lograr"),
                new RegVerbFuture("will bring", "traer")
        };

        private static final Verb[] Group20 = {
                // PRESENT
                new RegVerbPresent("exist", "existir"),
                new RegVerbPresent("fill", "llenar"),
                new RegVerbPresent("stop", "parar"),
                new IrregVerbPresent("produce", "producir", "produzco", "produces", "produce", "producimos", "producen"),
                new RegVerbPresent("use", "usar"),

                // PRETERITE
                new RegVerbPreterite("existed", "existir"),
                new RegVerbPreterite("filled", "llenar"),
                new RegVerbPreterite("stopped", "parar"),
                new IrregVerbPreterite("produced", "producir", "produje", "produjiste", "produjo", "produjimos", "produjeron"),
                new RegVerbPreterite("used", "usar"),

                // FUTURE
                new RegVerbFuture("will exist", "existir"),
                new RegVerbFuture("will fill", "llenar"),
                new RegVerbFuture("will stop", "parar"),
                new RegVerbFuture("will produce", "producir"),
                new RegVerbFuture("will use", "usar")
        };

    public WordBank() {
            numWords = NUM_GROUPS * NUM_VERBS_PER_GROUP;
        allVerbs = getAllVerbs();
    }

    public int getNumWords() {
        return numWords;
    }

    public Verb[] getAllVerbs() {
        Verb[] allVerbs = new Verb[numWords];
        int i = 0;
            for (int j = 0; j < Group1.length; j++) {
                    allVerbs[i++] = Group1[j];
            }
            for (int j = 0; j < Group2.length; j++) {
                    allVerbs[i++] = Group2[j];
            }
            for (int j = 0; j < Group3.length; j++) {
                    allVerbs[i++] = Group3[j];
            }
            for (int j = 0; j < Group4.length; j++) {
                    allVerbs[i++] = Group4[j];
            }
            for (int j = 0; j < Group5.length; j++) {
                    allVerbs[i++] = Group5[j];
            }
            for (int j = 0; j < Group6.length; j++) {
                    allVerbs[i++] = Group6[j];
            }
            for (int j = 0; j < Group7.length; j++) {
                    allVerbs[i++] = Group7[j];
            }
            for (int j = 0; j < Group8.length; j++) {
                    allVerbs[i++] = Group8[j];
            }
            for (int j = 0; j < Group9.length; j++) {
                    allVerbs[i++] = Group9[j];
            }
            for (int j = 0; j < Group10.length; j++) {
                    allVerbs[i++] = Group10[j];
            }
            for (int j = 0; j < Group11.length; j++) {
                    allVerbs[i++] = Group11[j];
            }
            for (int j = 0; j < Group12.length; j++) {
                    allVerbs[i++] = Group12[j];
            }
            for (int j = 0; j < Group13.length; j++) {
                    allVerbs[i++] = Group13[j];
            }
            for (int j = 0; j < Group14.length; j++) {
                    allVerbs[i++] = Group14[j];
            }
            for (int j = 0; j < Group15.length; j++) {
                    allVerbs[i++] = Group15[j];
            }
            for (int j = 0; j < Group16.length; j++) {
                    allVerbs[i++] = Group16[j];
            }
            for (int j = 0; j < Group17.length; j++) {
                    allVerbs[i++] = Group17[j];
            }
            for (int j = 0; j < Group18.length; j++) {
                    allVerbs[i++] = Group18[j];
            }
            for (int j = 0; j < Group19.length; j++) {
                    allVerbs[i++] = Group19[j];
            }
            for (int j = 0; j < Group20.length; j++) {
                    allVerbs[i++] = Group20[j];
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
