package blackbox.verbdrill;

import java.util.ArrayList;

/**
 *  Contains all verbs that can be used in ActivityGame, divided into groups that
 *  can be selected on/off through ActivitySettings.
 */
public class WordBank {
    private static int numWords;
    private static Verb[] allVerbs;
    private final static int NUM_GROUPS = 30;
    private final static int NUM_VERBS_PER_GROUP = 25;

    private static final Verb[] Group1 = {
            // PRESENT
            new RegPresentIndic("eat", "comer"),
            new RegPresentIndic("speak", "hablar"),
            new RegPresentIndic("listen", "escuchar"),
            new RegPresentIndic("study", "estudiar", "studies"),
            new IrregPresentIndic("be", "ser", "soy", "eres", "es", "somos", "son",
                    "am", "are", "is", "are", "are"),

            // PRETERITE
            new RegPreteriteIndic("ate", "comer"),
            new RegPreteriteIndic("spoke", "hablar"),
            new RegPreteriteIndic("listened", "escuchar"),
            new RegPreteriteIndic("studied", "estudiar"),
            new IrregPreteriteIndic("be", "ser", "fui", "fuiste", "fue", "fuimos", "fueron",
                    "was", "were", "was", "were", "were"),

            // FUTURE
            new RegFutureIndic("will eat", "comer"),
            new RegFutureIndic("will speak", "hablar"),
            new RegFutureIndic("will listen", "escuchar"),
            new RegFutureIndic("will study", "estudiar"),
            new RegFutureIndic("will be", "ser"),

            // IMPERFECT
            new RegImperfectIndic("ate", "comer"),
            new RegImperfectIndic("spoke", "hablar"),
            new RegImperfectIndic("listened", "escuchar"),
            new RegImperfectIndic("studied", "estudiar"),
            new IrregImperfectIndic("was", "ser", "era", "eras", "era", "éramos", "eran",
                    "was", "were", "was", "were", "were"),

            // PRESENT SUBJUNCTIVE
            new RegPresentSubj("eat", "comer"),
            new RegPresentSubj("speak", "hablar"),
            new RegPresentSubj("listen", "escuchar"),
            new RegPresentSubj("study", "estudiar"),
            new IrregPresentSubj("be", "ser", "sea", "seas", "sea", "seamos", "sean")
    };

    private static final Verb[] Group2 = {
            // PRESENT
            new IrregPresentIndic("be", "estar", "estoy", "estás", "está", "estamos", "están",
                    "am", "are", "is", "are", "are"),
            new RegPresentIndic("read", "leer"),
            new RegPresentIndic("call", "llamar"),
            new RegPresentIndic("work", "trabajar"),
            new RegPresentIndic("live", "vivir"),

            // PRETERITE
            new IrregPreteriteIndic("be", "estar", "estuve", "estuviste", "estuvo", "estuvimos", "estuvieron",
                    "was", "were", "was", "were", "were"),
            new IrregPreteriteIndic("read", "leer", "leí", "leíste", "leyó", "leímos", "leyeron"),
            new RegPreteriteIndic("called", "llamar"),
            new RegPreteriteIndic("worked", "trabajar"),
            new RegPreteriteIndic("lived", "vivir"),

            // FUTURE
            new RegFutureIndic("will be", "estar"),
            new RegFutureIndic("will read", "leer"),
            new RegFutureIndic("will call", "llamar"),
            new RegFutureIndic("will work", "trabajar"),
            new RegFutureIndic("will live", "vivir"),

            // IMPERFECT
            new RegImperfectIndic("was", "estar", "was", "were", "was",
                    "were", "were"),
            new RegImperfectIndic("read", "leer"),
            new RegImperfectIndic("called", "llamar"),
            new RegImperfectIndic("worked", "trabajar"),
            new RegImperfectIndic("lived", "vivir"),

            // PRESENT SUBJUNCTIVE
            new IrregPresentSubj("be", "estar", "esté", "estés", "esté", "estemos", "estén"),
            new RegPresentSubj("read", "leer"),
            new RegPresentSubj("call", "llamar"),
            new RegPresentSubj("work", "trabajar"),
            new RegPresentSubj("live", "vivir")
    };

    private static final Verb[] Group3 = {
            // PRESENT
            new RegPresentIndic("help", "ayudar"),
            new RegPresentIndic("write", "escribir"),
            new IrregPresentIndic("go", "ir", "voy", "vas", "va", "vamos", "van",
                    "go", "go", "goes", "go", "go"),
            new RegPresentIndic("arrive", "llegar"),
            new IrregPresentIndic("see", "ver", "veo", "ves", "ve", "vemos", "ven"),

            // PRETERITE
            new RegPreteriteIndic("helped", "ayudar"),
            new RegPreteriteIndic("wrote", "escribir"),
            new IrregPreteriteIndic("went", "ir", "fui", "fuiste", "fue", "fuimos", "fueron"),
            new IrregPreteriteIndic("arrived", "llegar", "llegué", "llegaste", "llegó", "llegamos", "llegaron"),
            new IrregPreteriteIndic("saw", "ver", "vi", "viste", "vio", "vimos", "vieron"),

            // FUTURE
            new RegFutureIndic("will help", "ayudar"),
            new RegFutureIndic("will write", "escribir"),
            new RegFutureIndic("will go", "ir"),
            new RegFutureIndic("will arrive", "llegar"),
            new RegFutureIndic("will see", "ver"),

            // IMPERFECT
            new RegImperfectIndic("helped", "ayudar"),
            new RegImperfectIndic("wrote", "escribir"),
            new IrregImperfectIndic("went", "ir", "iba", "ibas", "iba", "íbamos", "iban"),
            new RegImperfectIndic("arrived", "llegar"),
            new IrregImperfectIndic("saw", "ver", "veía", "veías", "veía", "veíamos", "veían"),

            // PRESENT SUBJUNCTIVE
            new RegPresentSubj("help", "ayudar"),
            new RegPresentSubj("write", "escribir"),
            new IrregPresentSubj("go", "ir", "vaya", "vayas", "vaya", "vayamos", "vayan"),
            new IrregPresentSubj("arrive", "llegar", "llegue", "llegues", "llegue", "lleguemos", "lleguen"),
            new IrregPresentSubj("see", "ver", "vea", "veas", "vea", "veamos", "vean")
    };

    private static final Verb[] Group4 = {
            // PRESENT
            new RegPresentIndic("walk", "caminar"),
            new RegPresentIndic("wear", "llevar"),
            new RegPresentIndic("pay", "pagar"),
            new IrregPresentIndic("have", "tener", "tengo", "tienes", "tiene", "tenemos", "tienen",
                    "have", "have", "has", "have", "have"),
            new IrregPresentIndic("want", "querer", "quiero", "quieres", "quiere", "queremos", "quieren"),

            // PRETERITE
            new RegPreteriteIndic("walked", "caminar"),
            new RegPreteriteIndic("wore", "llevar"),
            new IrregPreteriteIndic("paid", "pagar", "pagué", "pagaste", "pagó", "pagamos", "pagaron"),
            new IrregPreteriteIndic("had", "tener", "tuve", "tuviste", "tuvo", "tuvimos", "tuvieron"),
            new IrregPreteriteIndic("wanted", "querer", "quise", "quisiste", "quiso", "quisimos", "quisieron"),

            // FUTURE
            new RegFutureIndic("will walk", "caminar"),
            new RegFutureIndic("will wear", "llevar"),
            new RegFutureIndic("will pay", "pagar"),
            new IrregFutureIndic("will have", "tener", "tendré", "tendrás", "tendrá", "tendremos", "tendrán"),
            new IrregFutureIndic("will want", "querer", "querré", "querrás", "querrá", "querremos", "querrán"),

            // IMPERFECT
            new RegImperfectIndic("walked", "caminar"),
            new RegImperfectIndic("wore", "llevar"),
            new RegImperfectIndic("paid", "pagar"),
            new RegImperfectIndic("had", "tener"),
            new RegImperfectIndic("wanted", "querer"),

            // PRESENT SUBJUNCTIVE
            new RegPresentSubj("walk", "caminar"),
            new RegPresentSubj("wear", "llevar"),
            new IrregPresentSubj("pay", "pagar", "pague", "pagues", "pague", "paguemos", "paguen"),
            new IrregPresentSubj("have", "tener", "tenga", "tengas", "tenga", "tengamos", "tengan"),
            new IrregPresentSubj("want", "querer", "quiera", "quieras", "quiera", "queramos", "quieran")
    };

    private static final Verb[] Group5 = {
            // PRESENT
            new RegPresentIndic("drink", "beber"),
            new RegPresentIndic("cook", "cocinar"),
            new IrregPresentIndic("say", "decir", "digo", "dices", "dice", "decimos", "dicen"),
            new IrregPresentIndic("understand", "entender", "entiendo", "entiendes", "entiende", "entendemos", "entienden"),
            new RegPresentIndic("ask", "preguntar"),

            // PRETERITE
            new RegPreteriteIndic("drank", "beber"),
            new RegPreteriteIndic("cooked", "cocinar"),
            new IrregPreteriteIndic("said", "decir", "dije", "dijiste", "dijo", "dijimos", "dijeron"),
            new RegPreteriteIndic("understood", "entender"),
            new RegPreteriteIndic("asked", "preguntar"),

            // FUTURE
            new RegFutureIndic("will drink", "beber"),
            new RegFutureIndic("will cook", "cocinar"),
            new IrregFutureIndic("will say", "decir", "diré", "dirás", "dirá", "diremos", "dirán"),
            new RegFutureIndic("will understand", "entender"),
            new RegFutureIndic("will ask", "preguntar"),

            // IMPERFECT
            new RegImperfectIndic("drank", "beber"),
            new RegImperfectIndic("cooked", "cocinar"),
            new RegImperfectIndic("said", "decir"),
            new RegImperfectIndic("understood", "entender"),
            new RegImperfectIndic("asked", "preguntar"),

            // PRESENT SUBJUNCTIVE
            new RegPresentSubj("drink", "beber"),
            new RegPresentSubj("cook", "cocinar"),
            new IrregPresentSubj("say", "decir", "diga", "digas", "diga", "digamos", "digan"),
            new IrregPresentSubj("understand", "entender", "entienda", "entiendas", "entienda", "entendamos", "entiendan"),
            new RegPresentSubj("ask", "preguntar")
    };

    private static final Verb[] Group6 = {
            // PRESENT
            new RegPresentIndic("search", "buscar", "searches"),
            new RegPresentIndic("run", "correr"),
            new IrregPresentIndic("do", "hacer", "hago", "haces", "hace", "hacemos", "hacen",
                    "do", "do", "does", "do", "do"),
            new RegPresentIndic("swim", "nadar"),
            new IrregPresentIndic("hear", "oír", "oigo", "oyes", "oye", "oímos", "oyen"),

            // PRETERITE
            new IrregPreteriteIndic("searched", "buscar", "busqué", "buscaste", "buscó", "buscamos", "buscaron"),
            new RegPreteriteIndic("ran", "correr"),
            new IrregPreteriteIndic("did", "hacer", "hice", "hiciste", "hizo", "hicimos", "hicieron"),
            new RegPreteriteIndic("swam", "nadar"),
            new IrregPreteriteIndic("heard", "oír", "oí", "oíste", "oyó", "oímos", "oyeron"),

            // FUTURE
            new RegFutureIndic("will search", "buscar"),
            new RegFutureIndic("will run", "correr"),
            new IrregFutureIndic("will do", "hacer", "haré", "harás", "hará", "haremos", "harán"),
            new RegFutureIndic("will swim", "nadar"),
            new IrregFutureIndic("will hear", "oír", "oiré", "oirás", "oirá", "oiremos", "oirán"),

            // IMPERFECT
            new RegImperfectIndic("searched", "buscar"),
            new RegImperfectIndic("ran", "correr"),
            new RegImperfectIndic("did", "hacer"),
            new RegImperfectIndic("swam", "nadar"),
            new RegImperfectIndic("heard", "oír"),

            // PRESENT SUBJUNCTIVE
            new IrregPresentSubj("search", "buscar", "busque", "busques", "busque", "busquemos", "busquen"),
            new RegPresentSubj("run", "correr"),
            new IrregPresentSubj("do", "hacer", "haga", "hagas", "haga", "hagamos", "hagan"),
            new RegPresentSubj("swim", "nadar"),
            new IrregPresentSubj("hear", "oír", "oiga", "oigas", "oiga", "oigamos", "oigan")

    };

    private static final Verb[] Group7 = {
            // PRESENT
            new RegPresentIndic("learn", "aprender"),
            new IrregPresentIndic("know", "conocer", "conozco", "conoces", "conoce", "conocemos", "conocen"),
            new RegPresentIndic("need", "necesitar"),
            new IrregPresentIndic("know", "saber", "sé", "sabes", "sabe", "sabemos", "saben"),
            new RegPresentIndic("touch", "tocar", "touches"),

            // PRETERITE
            new RegPreteriteIndic("learned", "aprender"),
            new RegPreteriteIndic("knew", "conocer"),
            new RegPreteriteIndic("needed", "necesitar"),
            new IrregPreteriteIndic("knew", "saber", "supe", "supiste", "supo", "supimos", "supieron"),
            new IrregPreteriteIndic("touched", "tocar", "toqué", "tocaste", "tocó", "tocamos", "tocaron"),

            // FUTURE
            new RegFutureIndic("will learn", "aprender"),
            new RegFutureIndic("will know", "conocer"),
            new RegFutureIndic("will need", "necesitar"),
            new IrregFutureIndic("will know", "saber", "sabré", "sabrás", "sabrá", "sabremos", "sabrán"),
            new RegFutureIndic("will touch", "tocar"),

            // IMPERFECT
            new RegImperfectIndic("learned", "aprender"),
            new RegImperfectIndic("knew", "conocer"),
            new RegImperfectIndic("needed", "necesitar"),
            new RegImperfectIndic("knew", "saber"),
            new RegImperfectIndic("touched", "tocar"),

            // PRESENT SUBJUNCTIVE
            new RegPresentSubj("learn", "aprender"),
            new IrregPresentSubj("know", "conocer", "conozca", "conozcas", "conozca", "conozcamos", "conozcan"),
            new RegPresentSubj("need", "necesitar"),
            new IrregPresentSubj("know", "saber", "sepa", "sepas", "sepa", "sepamos", "sepan"),
            new IrregPresentSubj("touch", "tocar", "toque", "toques", "toque", "toquemos", "toquen")
    };

    private static final Verb[] Group8 = {
            // PRESENT
            new IrregPresentIndic("sleep", "dormir", "duermo", "duermes", "duerme", "dormimos", "duermen"),
            new IrregPresentIndic("find", "encontrar", "encuentro", "encuentras", "encuentra", "encontramos", "encuentran"),
            new IrregPresentIndic("play", "jugar", "juego", "juegas", "juega", "jugamos", "juegan"),
            new RegPresentIndic("pass", "pasar", "passes"),
            new RegPresentIndic("take", "tomar"),

            // PRETERITE
            new IrregPreteriteIndic("slept", "dormir", "dormí", "dormiste", "durmió", "dormimos", "durmieron"),
            new RegPreteriteIndic("found", "encontrar"),
            new IrregPreteriteIndic("played", "jugar", "jugué", "jugaste", "jugó", "jugamos", "jugaron"),
            new RegPreteriteIndic("passed", "pasar"),
            new RegPreteriteIndic("took", "tomar"),

            // FUTURE
            new RegFutureIndic("will sleep", "dormir"),
            new RegFutureIndic("will find", "encontrar"),
            new RegFutureIndic("will play", "jugar"),
            new RegFutureIndic("will pass", "pasar"),
            new RegFutureIndic("will take", "tomar"),

            // IMPERFECT
            new RegImperfectIndic("slept", "dormir"),
            new RegImperfectIndic("found", "encontrar"),
            new RegImperfectIndic("played", "jugar"),
            new RegImperfectIndic("passed", "pasar"),
            new RegImperfectIndic("took", "tomar"),

            // PRESENT SUBJUNCTIVE
            new IrregPresentSubj("sleep", "dormir", "duerma", "duermas", "duerma", "durmamos", "duerman"),
            new IrregPresentSubj("find", "encontrar", "encuentre", "encuentres", "encuentre", "encontremos", "encuentren"),
            new IrregPresentSubj("play", "jugar", "juegue", "juegues", "juegue", "juguemos", "jueguen"),
            new RegPresentSubj("pass", "pasar"),
            new RegPresentSubj("take", "tomar")
    };

    private static final Verb[] Group9 = {
            // PRESENT
            new IrregPresentIndic("begin", "comenzar", "comienzo", "comienzas", "comienza", "comenzamos", "comienzan"),
            new IrregPresentIndic("begin", "empezar", "empiezo", "empiezas", "empieza", "empezamos", "empiezan"),
            new IrregPresentIndic("think", "pensar", "pienso", "piensas", "piensa", "pensamos", "piensan"),
            new IrregPresentIndic("be able to", "poder", "puedo", "puedes", "puede", "podemos", "pueden",
                    "can", "can", "can", "can", "can"),
            new RegPresentIndic("end", "terminar"),

            // PRETERITE
            new IrregPreteriteIndic("began", "comenzar", "comencé", "comenzaste", "comenzó", "comenzamos", "comenzaron"),
            new IrregPreteriteIndic("began", "empezar", "empecé", "empezaste", "empezó", "empezamos", "empezaron"),
            new RegPreteriteIndic("thought", "pensar"),
            new IrregPreteriteIndic("was able", "poder", "pude", "pudiste", "pudo", "pudimos", "pudieron", "was able",
                    "were able", "was able", "were able", "were able"),
            new RegPreteriteIndic("ended", "terminar"),

            // FUTURE
            new RegFutureIndic("will begin", "comenzar"),
            new RegFutureIndic("will begin", "empezar"),
            new RegFutureIndic("will think", "pensar"),
            new IrregFutureIndic("will be able to", "poder", "podré", "podrás", "podrá", "podremos", "podrán"),
            new RegFutureIndic("will end", "terminar"),

            // IMPERFECT
            new RegImperfectIndic("began", "comenzar"),
            new RegImperfectIndic("began", "empezar"),
            new RegImperfectIndic("thought", "pensar"),
            new RegImperfectIndic("could", "poder"),
            new RegImperfectIndic("ended", "terminar"),

            // PRESENT SUBJUNCTIVE
            new IrregPresentSubj("begin", "comenzar", "comience", "comiences", "comience", "comencemos", "comiencen"),
            new IrregPresentSubj("begin", "empezar", "empiece", "empieces", "empiece", "empecemos", "empiecen"),
            new IrregPresentSubj("think", "pensar", "piense", "pienses", "piense", "pensemos", "piensen"),
            new IrregPresentSubj("can", "poder", "pueda", "puedas", "pueda", "podamos", "puedan"),
            new RegPresentSubj("end", "terminar")
    };

    private static final Verb[] Group10 = {
            // PRESENT
            new RegPresentIndic("open", "abrir"),
            new IrregPresentIndic("close", "cerrar", "cierro", "cierras", "cierra", "cerramos", "cierran"),
            new RegPresentIndic("buy", "comprar"),
            new IrregPresentIndic("come", "venir", "vengo", "vienes", "viene", "venimos", "vienen"),
            new IrregPresentIndic("leave", "salir", "salgo", "sales", "sale", "salimos", "salen"),

            // PRETERITE
            new RegPreteriteIndic("opened", "abrir"),
            new RegPreteriteIndic("closed", "cerrar"),
            new RegPreteriteIndic("bought", "comprar"),
            new IrregPreteriteIndic("came", "venir", "vine", "viniste", "vino", "vinimos", "vinieron"),
            new RegPreteriteIndic("left", "salir"),

            // FUTURE
            new RegFutureIndic("will open", "abrir"),
            new RegFutureIndic("will close", "cerrar"),
            new RegFutureIndic("will buy", "comprar"),
            new IrregFutureIndic("will come", "venir", "vendré", "vendrás", "vendrá", "vendremos", "vendrán"),
            new IrregFutureIndic("will leave", "salir", "saldré", "saldrás", "saldrá", "saldremos", "saldrán"),

            // IMPERFECT
            new RegImperfectIndic("opened", "abrir"),
            new RegImperfectIndic("closed", "cerrar"),
            new RegImperfectIndic("bought", "comprar"),
            new RegImperfectIndic("came", "venir"),
            new RegImperfectIndic("left", "salir"),

            // PRESENT SUBJUNCTIVE
            new RegPresentSubj("open", "abrir"),
            new IrregPresentSubj("close", "cerrar", "cierre", "cierres", "cierre", "cerremos", "cierren"),
            new RegPresentSubj("buy", "comprar"),
            new IrregPresentSubj("come", "venir", "venga", "vengas", "venga", "vengamos", "vengan"),
            new IrregPresentSubj("leave", "salir", "salga", "salgas", "salga", "salgamos", "salgan")
    };

    private static final Verb[] Group11 = {
            // PRESENT
            new RegPresentIndic("answer", "contestar"),
            new RegPresentIndic("draw", "dibujar"),
            new RegPresentIndic("teach", "enseñar", "teaches"),
            new RegPresentIndic("explain", "explicar"),
            new RegPresentIndic("sign", "firmar"),

            // PRETERITE
            new RegPreteriteIndic("answered", "contestar"),
            new RegPreteriteIndic("drew", "dibujar"),
            new RegPreteriteIndic("taught", "enseñar"),
            new IrregPreteriteIndic("explained", "explicar", "expliqué", "explicaste", "explicó", "explicamos", "explicaron"),
            new RegPreteriteIndic("signed", "firmar"),

            // FUTURE
            new RegFutureIndic("will answer", "contestar"),
            new RegFutureIndic("will draw", "dibujar"),
            new RegFutureIndic("will teach", "enseñar"),
            new RegFutureIndic("will explain", "explicar"),
            new RegFutureIndic("will sign", "firmar"),

            // IMPERFECT
            new RegImperfectIndic("answered", "contestar"),
            new RegImperfectIndic("drew", "dibujar"),
            new RegImperfectIndic("taught", "enseñar"),
            new RegImperfectIndic("explained", "explicar"),
            new RegImperfectIndic("signed", "firmar"),

            // PRESENT SUBJUNCTIVE
            new RegPresentSubj("answer", "contestar"),
            new RegPresentSubj("draw", "dibujar"),
            new RegPresentSubj("teach", "enseñar"),
            new IrregPresentSubj("explain", "explicar", "explique", "expliques", "explique", "expliquemos", "expliquen"),
            new RegPresentSubj("sign", "firmar")
    };

    private static final Verb[] Group12 = {
            // PRESENT
            new RegPresentIndic("accept", "aceptar"),
            new IrregPresentIndic("give", "dar", "doy", "das", "da", "damos", "dan"),
            new RegPresentIndic("leave", "dejar"),
            new RegPresentIndic("present", "presentar"),
            new RegPresentIndic("receive", "recibir"),

            // PRETERITE
            new RegPreteriteIndic("accepted", "aceptar"),
            new IrregPreteriteIndic("gave", "dar", "di", "diste", "dio", "dimos", "dieron"),
            new RegPreteriteIndic("left", "dejar"),
            new RegPreteriteIndic("presented", "presentar"),
            new RegPreteriteIndic("received", "recibir"),

            // FUTURE
            new RegFutureIndic("will accept", "aceptar"),
            new RegFutureIndic("will give", "dar"),
            new RegFutureIndic("will leave", "dejar"),
            new RegFutureIndic("will present", "presentar"),
            new RegFutureIndic("will receive", "recibir"),

            // IMPERFECT
            new RegImperfectIndic("accepted", "aceptar"),
            new RegImperfectIndic("gave", "dar"),
            new RegImperfectIndic("left", "dejar"),
            new RegImperfectIndic("presented", "presentar"),
            new RegImperfectIndic("received", "recibir"),

            // PRESENT SUBJUNCTIVE
            new RegPresentSubj("accept", "aceptar"),
            new IrregPresentSubj("give", "dar", "dé", "des", "dé", "demos", "den"),
            new RegPresentSubj("leave", "dejar"),
            new RegPresentSubj("present", "presentar"),
            new RegPresentSubj("receive", "recibir")
    };

    private static final Verb[] Group13 = {
            // PRESENT
            new RegPresentIndic("wait", "esperar"),
            new RegPresentIndic("look", "mirar"),
            new RegPresentIndic("allow", "permitir"),
            new IrregPresentIndic("put", "poner", "pongo", "pones", "pone", "ponemos", "ponen"),
            new RegPresentIndic("treat", "tratar"),

            // PRETERITE
            new RegPreteriteIndic("waited", "esperar"),
            new RegPreteriteIndic("looked", "mirar"),
            new RegPreteriteIndic("allowed", "permitir"),
            new IrregPreteriteIndic("put", "poner", "puse", "pusiste", "puso", "pusimos", "pusieron"),
            new RegPreteriteIndic("treated", "tratar"),

            // FUTURE
            new RegFutureIndic("will wait", "esperar"),
            new RegFutureIndic("will look", "mirar"),
            new RegFutureIndic("will allow", "permitir"),
            new IrregFutureIndic("will put", "poner", "pondré", "pondrás", "pondrá", "pondremos", "pondrán"),
            new RegFutureIndic("will treat", "tratar"),

            // IMPERFECT
            new RegImperfectIndic("waited", "esperar"),
            new RegImperfectIndic("looked", "mirar"),
            new RegImperfectIndic("allowed", "permitir"),
            new RegImperfectIndic("put", "poner"),
            new RegImperfectIndic("treated", "tratar"),

            // PRESENT SUBJUNCTIVE
            new RegPresentSubj("wait", "esperar"),
            new RegPresentSubj("look", "mirar"),
            new RegPresentSubj("allow", "permitir"),
            new IrregPresentSubj("put", "poner", "ponga", "pongas", "ponga", "pongamos", "pongan"),
            new RegPresentSubj("treat", "tratar")
    };

    private static final Verb[] Group14 = {
            // PRESENT
            new RegPresentIndic("believe", "creer"),
            new RegPresentIndic("owe", "deber"),
            new IrregPresentIndic("seem", "parecer", "parezco", "pareces", "parece", "parecemos", "parecen"),
            new IrregPresentIndic("feel", "sentir", "siento", "sientes", "siente", "sentimos", "sienten"),
            new IrregPresentIndic("dream", "soñar", "sueño", "sueñas", "sueña", "soñamos", "sueñan"),

            // PRETERITE
            new IrregPreteriteIndic("believed", "creer", "creí", "creíste", "creyó", "creímos", "creyeron"),
            new RegPreteriteIndic("owed", "deber"),
            new RegPreteriteIndic("seemed", "parecer"),
            new IrregPreteriteIndic("felt", "sentir", "sentí", "sentiste", "sintió", "sentimos", "sintieron"),
            new RegPreteriteIndic("dreamt", "soñar"),

            // FUTURE
            new RegFutureIndic("will believe", "creer"),
            new RegFutureIndic("will owe", "deber"),
            new RegFutureIndic("will seem", "parecer"),
            new RegFutureIndic("will feel", "sentir"),
            new RegFutureIndic("will dream", "soñar"),

            // IMPERFECT
            new RegImperfectIndic("believed", "creer"),
            new RegImperfectIndic("owed", "deber"),
            new RegImperfectIndic("seemed", "parecer"),
            new RegImperfectIndic("felt", "sentir"),
            new RegImperfectIndic("dreamt", "soñar"),

            // PRESENT SUBJUNCTIVE
            new RegPresentSubj("believe", "creer"),
            new RegPresentSubj("owe", "deber"),
            new IrregPresentSubj("seem", "parecer", "parezca", "parezcas", "parezca", "parezcamos", "parezcan"),
            new IrregPresentSubj("feel", "sentir", "sienta", "sientas", "sienta", "sintamos", "sientan"),
            new IrregPresentSubj("dream", "soñar", "sueñe", "sueñes", "sueñe", "soñemos", "sueñen")
    };

    private static final Verb[] Group15 = {
            // PRESENT
            new IrregPresentIndic("drive", "conducir", "conduzco", "conduces", "conduce", "conducimos", "conducen"),
            new RegPresentIndic("enter", "entrar"),
            new IrregPresentIndic("follow", "seguir", "sigo", "sigues", "sigue", "seguimos", "siguen"),
            new RegPresentIndic("visit", "visitar"),
            new IrregPresentIndic("return", "volver", "vuelvo", "vuelves", "vuelve", "volvemos", "vuelven"),

            // PRETERITE
            new IrregPreteriteIndic("drove", "conducir", "conduje", "condujiste", "condujo", "condujimos", "condujeron"),
            new RegPreteriteIndic("entered", "entrar"),
            new IrregPreteriteIndic("followed", "seguir", "seguí", "seguiste", "siguió", "seguimos", "siguieron"),
            new RegPreteriteIndic("visited", "visitar"),
            new RegPreteriteIndic("returned", "volver"),

            // FUTURE
            new RegFutureIndic("will drive", "conducir"),
            new RegFutureIndic("will enter", "entrar"),
            new RegFutureIndic("will follow", "seguir"),
            new RegFutureIndic("will visit", "visitar"),
            new RegFutureIndic("will return", "volver"),

            // IMPERFECT
            new RegImperfectIndic("drove", "conducir"),
            new RegImperfectIndic("entered", "entrar"),
            new RegImperfectIndic("followed", "seguir"),
            new RegImperfectIndic("visited", "visitar"),
            new RegImperfectIndic("returned", "volver"),

            // PRESENT SUBJUNCTIVE
            new IrregPresentSubj("drive", "conducir", "conduzca", "conduzcas", "conduzca", "conduzcamos", "conduzcan"),
            new RegPresentSubj("enter", "entrar"),
            new IrregPresentSubj("follow", "seguir", "siga", "sigas", "siga", "sigamos", "sigan"),
            new RegPresentSubj("visit", "visitar"),
            new IrregPresentSubj("return", "volver", "vuelva", "vuelvas", "vuelva", "volvamos", "vuelvan")
    };

    private static final Verb[] Group16 = {
            // PRESENT
            new RegPresentIndic("dance", "bailar"),
            new RegPresentIndic("sing", "cantar"),
            new RegPresentIndic("win", "ganar"),
            new RegPresentIndic("try", "intentar", "tries"),
            new IrregPresentIndic("lose", "perder", "pierdo", "pierdes", "pierde", "perdemos", "pierden"),

            // PRETERITE
            new RegPreteriteIndic("danced", "bailar"),
            new RegPreteriteIndic("sang", "cantar"),
            new RegPreteriteIndic("won", "ganar"),
            new RegPreteriteIndic("tried", "intentar"),
            new RegPreteriteIndic("lost", "perder"),

            // FUTURE
            new RegFutureIndic("will dance", "bailar"),
            new RegFutureIndic("will sing", "cantar"),
            new RegFutureIndic("will win", "ganar"),
            new RegFutureIndic("will try", "intentar"),
            new RegFutureIndic("will lose", "perder"),

            // IMPERFECT
            new RegImperfectIndic("danced", "bailar"),
            new RegImperfectIndic("sang", "cantar"),
            new RegImperfectIndic("won", "ganar"),
            new RegImperfectIndic("tried", "intentar"),
            new RegImperfectIndic("lost", "perder"),

            // PRESENT SUBJUNCTIVE
            new RegPresentSubj("dance", "bailar"),
            new RegPresentSubj("sing", "cantar"),
            new RegPresentSubj("win", "ganar"),
            new RegPresentSubj("try", "intentar"),
            new IrregPresentSubj("lose", "perder", "pierda", "pierdas", "pierda", "perdamos", "pierdan")
    };

    private static final Verb[] Group17 = {
            // PRESENT
            new RegPresentIndic("cut", "cortar"),
            new RegPresentIndic("clean", "limpiar"),
            new RegPresentIndic("forget", "olvidar"),
            new RegPresentIndic("break", "romper"),
            new IrregPresentIndic("remember", "recordar", "recuerdo", "recuerdas", "recuerda", "recordamos", "recuerdan"),

            // PRETERITE
            new RegPreteriteIndic("cut", "cortar"),
            new RegPreteriteIndic("cleaned", "limpiar"),
            new RegPreteriteIndic("forgot", "olvidar"),
            new RegPreteriteIndic("broke", "romper"),
            new RegPreteriteIndic("remembered", "recordar"),

            // FUTURE
            new RegFutureIndic("will cut", "cortar"),
            new RegFutureIndic("will clean", "limpiar"),
            new RegFutureIndic("will forget", "olvidar"),
            new RegFutureIndic("will break", "romper"),
            new RegFutureIndic("will remember", "recordar"),

            // IMPERFECT
            new RegImperfectIndic("cut", "cortar"),
            new RegImperfectIndic("cleaned", "limpiar"),
            new RegImperfectIndic("forgot", "olvidar"),
            new RegImperfectIndic("broke", "romper"),
            new RegImperfectIndic("remembered", "recordar"),

            // PRESENT SUBJUNCTIVE
            new RegPresentSubj("cut", "cortar"),
            new RegPresentSubj("clean", "limpiar"),
            new RegPresentSubj("forget", "olvidar"),
            new RegPresentSubj("break", "romper"),
            new IrregPresentSubj("remember", "recordar", "recuerde", "recuerdes", "recuerde", "recordemos", "recuerden")
    };

    private static final Verb[] Group18 = {
            // PRESENT
            new RegPresentIndic("consider", "considerar"),
            new IrregPresentIndic("count", "contar", "cuento", "cuentas", "cuenta", "contamos", "cuentan"),
            new IrregPresentIndic("ask for", "pedir", "pido", "pides", "pide", "pedimos", "piden",
                    "ask for", "ask for", "asks for", "ask for", "ask for"),
            new IrregPresentIndic("serve", "servir", "sirvo", "sirves", "sirve", "servimos", "sirven"),
            new RegPresentIndic("sell", "vender"),

            // PRETERITE
            new RegPreteriteIndic("considered", "considerar"),
            new RegPreteriteIndic("counted", "contar"),
            new IrregPreteriteIndic("asked for", "pedir", "pedí", "pediste", "pidió", "pedimos", "pidieron"),
            new IrregPreteriteIndic("served", "servir", "serví", "serviste", "sirvió", "servimos", "sirvieron"),
            new RegPreteriteIndic("sold", "vender"),

            // FUTURE
            new RegFutureIndic("will consider", "considerar"),
            new RegFutureIndic("will count", "contar"),
            new RegFutureIndic("will ask for", "pedir"),
            new RegFutureIndic("will serve", "servir"),
            new RegFutureIndic("will sell", "vender"),

            // IMPERFECT
            new RegImperfectIndic("considered", "considerar"),
            new RegImperfectIndic("counted", "contar"),
            new RegImperfectIndic("asked for", "pedir"),
            new RegImperfectIndic("served", "servir"),
            new RegImperfectIndic("sold", "vender"),

            // PRESENT SUBJUNCTIVE
            new RegPresentSubj("consider", "considerar"),
            new IrregPresentSubj("count", "contar", "cuente", "cuentes", "cuente", "contemos", "cuenten"),
            new IrregPresentSubj("ask for", "pedir", "pida", "pidas", "pida", "pidamos", "pidan"),
            new IrregPresentSubj("serve", "servir", "sirva", "sirvas", "sirva", "sirvamos", "sirvan"),
            new RegPresentSubj("sell", "vender")
    };

    private static final Verb[] Group19 = {
            // PRESENT
            new RegPresentIndic("change", "cambiar"),
            new RegPresentIndic("depend", "depender"),
            new IrregPresentIndic("include", "incluir", "incluyo", "incluyes", "incluye", "incluimos", "incluyen"),
            new RegPresentIndic("achieve", "lograr"),
            new IrregPresentIndic("bring", "traer", "traigo", "traes", "trae", "traemos", "traen"),

            // PRETERITE
            new RegPreteriteIndic("changed", "cambiar"),
            new RegPreteriteIndic("depended", "depender"),
            new IrregPreteriteIndic("included", "incluir", "incluí", "incluiste", "incluyó", "incluimos", "incluyeron"),
            new RegPreteriteIndic("achieved", "lograr"),
            new IrregPreteriteIndic("brought", "traer", "traje", "trajiste", "trajo", "trajimos", "trajeron"),

            // FUTURE
            new RegFutureIndic("will change", "cambiar"),
            new RegFutureIndic("will depend", "depender"),
            new RegFutureIndic("will include", "incluir"),
            new RegFutureIndic("will achieve", "lograr"),
            new RegFutureIndic("will bring", "traer"),

            // IMPERFECT
            new RegImperfectIndic("changed", "cambiar"),
            new RegImperfectIndic("depended", "depender"),
            new RegImperfectIndic("included", "incluir"),
            new RegImperfectIndic("achieved", "lograr"),
            new RegImperfectIndic("brought", "traer"),

            // PRESENT SUBJUNCTIVE
            new RegPresentSubj("change", "cambiar"),
            new RegPresentSubj("depend", "depender"),
            new IrregPresentSubj("include", "incluir", "incluya", "incluyas", "incluya", "incluyamos", "incluyan"),
            new RegPresentSubj("achieve", "lograr"),
            new IrregPresentSubj("bring", "traer", "traiga", "traigas", "traiga", "traigamos", "traigan")
    };

    private static final Verb[] Group20 = {
            // PRESENT
            new RegPresentIndic("exist", "existir"),
            new RegPresentIndic("fill", "llenar"),
            new RegPresentIndic("stop", "parar"),
            new IrregPresentIndic("produce", "producir", "produzco", "produces", "produce", "producimos", "producen"),
            new RegPresentIndic("use", "usar"),

            // PRETERITE
            new RegPreteriteIndic("existed", "existir"),
            new RegPreteriteIndic("filled", "llenar"),
            new RegPreteriteIndic("stopped", "parar"),
            new IrregPreteriteIndic("produced", "producir", "produje", "produjiste", "produjo", "produjimos", "produjeron"),
            new RegPreteriteIndic("used", "usar"),

            // FUTURE
            new RegFutureIndic("will exist", "existir"),
            new RegFutureIndic("will fill", "llenar"),
            new RegFutureIndic("will stop", "parar"),
            new RegFutureIndic("will produce", "producir"),
            new RegFutureIndic("will use", "usar"),

            // IMPERFECT
            new RegImperfectIndic("existed", "existir"),
            new RegImperfectIndic("filled", "llenar"),
            new RegImperfectIndic("stopped", "parar"),
            new RegImperfectIndic("produced", "producir"),
            new RegImperfectIndic("used", "usar"),

            //  PRESENT SUBJUNCTIVE
            new RegPresentSubj("exist", "existir"),
            new RegPresentSubj("fill", "llenar"),
            new RegPresentSubj("stop", "parar"),
            new IrregPresentSubj("produce", "producir", "produzca", "produzcas", "produzca", "produzcamos", "produzcan"),
            new RegPresentSubj("use", "usar")
    };

    private static final Verb[] Group21 = {
            // PRESENT
            new RegPresentIndic("understand", "comprender"),
            new RegPresentIndic("discover", "descubrir"),
            new RegPresentIndic("wish", "desear", "wishes"),
            new IrregPresentIndic("suppose", "suponer", "supongo", "supones",
                    "supone", "suponemos", "suponen"),
            new IrregPresentIndic("recognize", "reconocer", "reconozco", "reconoces",
                    "reconoce", "reconocemos", "reconocen"),

            // PRETERITE
            new RegPreteriteIndic("understood", "comprender"),
            new RegPreteriteIndic("discovered", "descubrir"),
            new RegPreteriteIndic("wished", "desear"),
            new IrregPreteriteIndic("supposed", "suponer", "supuse", "supusiste",
                    "supuso", "supusimos", "supusieron"),
            new RegPreteriteIndic("recognized", "reconocer"),

            // FUTURE
            new RegFutureIndic("will understand", "comprender"),
            new RegFutureIndic("will discover", "descubrir"),
            new RegFutureIndic("will wish", "desear"),
            new IrregFutureIndic("will suppose", "suponer", "supondré", "supondrás",
                    "supondrá", "supondremos", "supondrán"),
            new RegFutureIndic("will recognize", "reconocer"),

            // IMPERFECT
            new RegImperfectIndic("understood", "comprender"),
            new RegImperfectIndic("discovered", "descubrir"),
            new RegImperfectIndic("wished", "desear"),
            new RegImperfectIndic("supposed", "suponer"),
            new RegImperfectIndic("recognized", "reconocer"),

            // PRESENT SUBJUNCTIVE
            new RegPresentSubj("understand", "comprender"),
            new RegPresentSubj("discover", "descubrir"),
            new RegPresentSubj("wish", "desear"),
            new IrregPresentSubj("suppose", "suponer", "suponga", "supongas", "suponga", "supongamos", "supongan"),
            new IrregPresentSubj("recognize", "reconocer", "reconozca", "reconozcas", "reconozca", "reconozcamos", "reconozcan")
    };

    private static final Verb[] Group22 = {
            // PRESENT
            new IrregPresentIndic("correct", "corregir", "corrijo", "corriges",
                    "corrige", "corregimos", "corrigen"),
            new IrregPresentIndic("grow", "crecer", "crezco", "creces",
                    "crece", "crecemos", "crecen"),
            new RegPresentIndic("fulfill", "cumplir"),
            new IrregPresentIndic("repeat", "repetir", "repito", "repites", "repite",
                    "repetimos", "repiten"),
            new RegPresentIndic("practice", "practicar"),

            // PRETERITE
            new IrregPreteriteIndic("corrected", "corregir", "corregí", "corregiste",
                    "corrigió", "corregimos", "corrigieron"),
            new RegPreteriteIndic("grew", "crecer"),
            new RegPreteriteIndic("fulfilled", "cumplir"),
            new IrregPreteriteIndic("repeated", "repetir", "repetí", "repetiste", "repitió",
                    "repetimos", "repitieron"),
            new IrregPreteriteIndic("practiced", "practicar", "practiqué", "practicaste",
                    "practicó", "practicamos", "practicaron"),

            // FUTURE
            new RegFutureIndic("will correct", "corregir"),
            new RegFutureIndic("will grow", "crecer"),
            new RegFutureIndic("will fulfill", "cumplir"),
            new RegFutureIndic("will repeat", "repetir"),
            new RegFutureIndic("will practice", "practicar"),

            // IMPERFECT
            new RegImperfectIndic("corrected", "corregir"),
            new RegImperfectIndic("grew", "crecer"),
            new RegImperfectIndic("fulfilled", "cumplir"),
            new RegImperfectIndic("repeated", "repetir"),
            new RegImperfectIndic("practiced", "practicar"),

            // PRESENT SUBJUNCTIVE
            new IrregPresentSubj("correct", "corregir", "corrija", "corrijas", "corrija", "corrijamos", "corrijan"),
            new IrregPresentSubj("grow", "crecer", "crezca", "crezcas", "crezca", "crezcamos", "crezcan"),
            new RegPresentSubj("fulfill", "cumplir"),
            new IrregPresentSubj("repeat", "repetir", "repita", "repitas", "repita", "repitamos", "repitan"),
            new IrregPresentSubj("practice", "practicar", "practique", "practiques", "practique", "practiquemos", "practiquen")
    };

    private static final Verb[] Group23 = {
            // PRESENT
            new IrregPresentIndic("destroy", "destruir", "destruyo", "destruyes", "destruye",
                    "destruimos", "destruyen"),
            new IrregPresentIndic("die", "morir", "muero", "mueres", "muere", "morimos", "mueren"),
            new RegPresentIndic("hit", "pegar"),
            new RegPresentIndic("burn", "quemar"),
            new RegPresentIndic("steal", "robar"),


            // PRETERITE
            new IrregPreteriteIndic("destroyed", "destruir", "destruí", "destruiste", "destruyó",
                    "destruimos", "destruyeron"),
            new IrregPreteriteIndic("died", "morir", "morí", "moriste", "murió", "morimos", "murieron"),
            new IrregPreteriteIndic("hit", "pegar", "pegué", "pegaste", "pegó", "pegamos", "pegaron"),
            new RegPreteriteIndic("burned", "quemar"),
            new RegPreteriteIndic("stole", "robar"),

            // FUTURE
            new RegFutureIndic("will destroy", "destruir"),
            new RegFutureIndic("will die", "morir"),
            new RegFutureIndic("will hit", "pegar"),
            new RegFutureIndic("will burn", "quemar"),
            new RegFutureIndic("will steal", "robar"),

            // IMPERFECT
            new RegImperfectIndic("destroyed", "destruir"),
            new RegImperfectIndic("died", "morir"),
            new RegImperfectIndic("hit", "pegar"),
            new RegImperfectIndic("burned", "quemar"),
            new RegImperfectIndic("stole", "robar"),

            // PRESENT SUBJUNCTIVE
            new IrregPresentSubj("destroy", "destruir", "destruya", "destruyas", "destruya", "destruyamos", "destruyan"),
            new IrregPresentSubj("die", "morir", "muera", "mueras", "muera", "muramos", "mueran"),
            new IrregPresentSubj("hit", "pegar", "pegue", "pegues", "pegue", "peguemos", "peguen"),
            new RegPresentSubj("burn", "quemar"),
            new RegPresentSubj("steal", "robar")
    };

    private static final Verb[] Group24 = {
            // PRESENT
            new RegPresentIndic("create", "crear"),
            new RegPresentIndic("criticize", "criticar"),
            new RegPresentIndic("color", "colorear"),
            new IrregPresentIndic("show", "mostrar", "muestro", "muestras", "muestra", "mostramos",
                    "muestran"),
            new RegPresentIndic("paint", "pintar"),


            // PRETERITE
            new RegPreteriteIndic("created", "crear"),
            new IrregPreteriteIndic("criticized", "criticar", "critiqué", "criticaste", "criticó",
                    "criticamos", "criticaron"),
            new RegPreteriteIndic("colored", "colorear"),
            new RegPreteriteIndic("showed", "mostrar"),
            new RegPreteriteIndic("painted", "pintar"),


            // FUTURE
            new RegFutureIndic("will create", "crear"),
            new RegFutureIndic("will criticize", "criticar"),
            new RegFutureIndic("will color", "colorear"),
            new RegFutureIndic("will show", "mostrar"),
            new RegFutureIndic("will paint", "pintar"),

            // IMPERFECT
            new RegImperfectIndic("created", "crear"),
            new RegImperfectIndic("criticized", "criticar"),
            new RegImperfectIndic("colored", "colorear"),
            new RegImperfectIndic("showed", "mostrar"),
            new RegImperfectIndic("painted", "pintar"),

            // PRESENT SUBJUNCTIVE
            new RegPresentSubj("create", "crear"),
            new IrregPresentSubj("criticize", "criticar", "critique", "critiques", "critique", "critiquemos", "critiquen"),
            new RegPresentSubj("color", "colorear"),
            new IrregPresentSubj("show", "mostrar", "muestre", "muestres", "muestre", "mostremos", "muestren"),
            new RegPresentSubj("paint", "pintar")
    };

    private static final Verb[] Group25 = {
            // PRESENT
            new RegPresentIndic("admit", "admitir"),
            new IrregPresentIndic("confess", "confesar", "confieso", "confiesas",
                    "confiesa", "confesamos", "confiesan", "confess", "confess",
                    "confesses", "confess", "confess"),
            new RegPresentIndic("shout", "gritar"),
            new RegPresentIndic("cry", "llorar", "cries"),
            new RegPresentIndic("whisper", "susurrar"),

            // PRETERITE
            new RegPreteriteIndic("admitted", "admitir"),
            new RegPreteriteIndic("confessed", "confesar"),
            new RegPreteriteIndic("shouted", "gritar"),
            new RegPreteriteIndic("cried", "llorar"),
            new RegPreteriteIndic("whispered", "susurrar"),

            // FUTURE
            new RegFutureIndic("will admit", "admitir"),
            new RegFutureIndic("will confess", "confesar"),
            new RegFutureIndic("will shout", "gritar"),
            new RegFutureIndic("will cry", "llorar"),
            new RegFutureIndic("will whisper", "susurrar"),

            // IMPERFECT
            new RegImperfectIndic("admitted", "admitir"),
            new RegImperfectIndic("confessed", "confesar"),
            new RegImperfectIndic("shouted", "gritar"),
            new RegImperfectIndic("cried", "llorar"),
            new RegImperfectIndic("whispered", "susurrar"),

            // PRESENT SUBJUNCTIVE
            new RegPresentSubj("admit", "admitir"),
            new IrregPresentSubj("confess", "confesar", "confiese", "confieses", "confiese", "confesemos", "confiesen"),
            new RegPresentSubj("shout", "gritar"),
            new RegPresentSubj("cry", "llorar"),
            new RegPresentSubj("whisper", "susurrar")
    };

    private static final Verb[] Group26 = {
            // PRESENT
            new IrregPresentIndic("continue", "continuar", "continúo", "continúas", "continúa",
                    "continuamos", "continúan"),
            new IrregPresentIndic("maintain", "mantener", "mantengo", "mantienes", "mantiene", "mantenemos", "mantienen"),
            new IrregPresentIndic("choose", "escoger", "escojo", "escoges", "escoge", "escogemos", "escogen"),
            new RegPresentIndic("take out", "sacar", "takes out"),
            new RegPresentIndic("utilize", "utilizar"),

            // PRETERITE
            new RegPreteriteIndic("continued", "continuar"),
            new IrregPreteriteIndic("maintained", "mantener", "mantuve", "mantuviste", "mantuvo", "mantuvimos", "mantuvieron"),
            new RegPreteriteIndic("chose", "escoger"),
            new IrregPreteriteIndic("took out", "sacar", "saqué", "sacaste", "sacó", "sacamos", "sacaron"),
            new IrregPreteriteIndic("utilized", "utilizar", "utilicé", "utilizaste", "utilizó", "utilizamos", "utilizaron"),

            // FUTURE
            new RegFutureIndic("will continue", "continuar"),
            new IrregFutureIndic("will maintain", "mantener", "mantendré", "mantendrás", "mantendrá", "mantendremos", "mantendrán"),
            new RegFutureIndic("will choose", "escoger"),
            new RegFutureIndic("will take out", "sacar"),
            new RegFutureIndic("will utilize", "utilizar"),

            // IMPERFECT
            new RegImperfectIndic("continued", "continuar"),
            new RegImperfectIndic("maintained", "mantener"),
            new RegImperfectIndic("chose", "escoger"),
            new RegImperfectIndic("took out", "sacar"),
            new RegImperfectIndic("utilized", "utilizar"),

            // PRESENT SUBJUNCTIVE
            new IrregPresentSubj("continue", "continuar", "continúe", "continúes", "continúe", "continuemos", "continúen"),
            new IrregPresentSubj("maintain", "mantener", "mantenga", "mantengas", "mantenga", "mantengamos", "mantengan"),
            new IrregPresentSubj("choose", "escoger", "escoja", "escojas", "escoja", "escojamos", "escojan"),
            new IrregPresentSubj("take out", "sacar", "saque", "saques", "saque", "saquemos", "saquen"),
            new IrregPresentSubj("utilize", "utilizar", "utilice", "utilices", "utilice", "utilicemos", "utilicen")
    };

    private static final Verb[] Group27 = {
            // PRESENT
            new RegPresentIndic("compare", "comparar"),
            new RegPresentIndic("raise", "levantar"),
            new IrregPresentIndic("measure", "medir", "mido", "mides", "mide", "medimos", "miden"),
            new RegPresentIndic("cut", "partir"),
            new RegPresentIndic("weigh", "pesar"),

            // PRETERITE
            new RegPreteriteIndic("compared", "comparar"),
            new RegPreteriteIndic("raised", "levantar"),
            new IrregPreteriteIndic("measured", "medir", "medí", "mediste", "midió", "medimos", "midieron"),
            new RegPreteriteIndic("cut", "partir"),
            new RegPreteriteIndic("weighed", "pesar"),

            // FUTURE
            new RegFutureIndic("will compare", "comparar"),
            new RegFutureIndic("will raise", "levantar"),
            new RegFutureIndic("will measure", "medir"),
            new RegFutureIndic("will cut", "partir"),
            new RegFutureIndic("will weigh", "pesar"),

            // IMPERFECT
            new RegImperfectIndic("compared", "comparar"),
            new RegImperfectIndic("raised", "levantar"),
            new RegImperfectIndic("measured", "medir"),
            new RegImperfectIndic("cut", "partir"),
            new RegImperfectIndic("weighed", "pesar"),

            // PRESENT SUBJUNCTIVE
            new RegPresentSubj("compare", "comparar"),
            new RegPresentSubj("raise", "levantar"),
            new IrregPresentSubj("measure", "medir", "mida", "midas", "mida", "midamos", "midan"),
            new RegPresentSubj("cut", "partir"),
            new RegPresentSubj("weigh", "pesar")
    };

    private static final Verb[] Group28 = {
            // PRESENT
            new IrregPresentIndic("defend", "defender", "defiendo", "defiendes", "defiende", "defendemos",
                    "defienden"),
            new RegPresentIndic("avoid", "evitar"),
            new RegPresentIndic("fight", "luchar"),
            new RegPresentIndic("kill", "matar"),
            new RegPresentIndic("rescue", "rescatar"),

            // PRETERITE
            new RegPreteriteIndic("defended", "defender"),
            new RegPreteriteIndic("avoided", "evitar"),
            new RegPreteriteIndic("fought", "luchar"),
            new RegPreteriteIndic("killed", "matar"),
            new RegPreteriteIndic("rescued", "rescatar"),

            // FUTURE
            new RegFutureIndic("will defend", "defender"),
            new RegFutureIndic("will avoid", "evitar"),
            new RegFutureIndic("will fight", "luchar"),
            new RegFutureIndic("will kill", "matar"),
            new RegFutureIndic("will rescue", "rescatar"),

            // IMPERFECT
            new RegImperfectIndic("defended", "defender"),
            new RegImperfectIndic("avoided", "evitar"),
            new RegImperfectIndic("fought", "luchar"),
            new RegImperfectIndic("killed", "matar"),
            new RegImperfectIndic("rescued", "rescatar"),

            // PRESENT SUBJUNCTIVE
            new IrregPresentSubj("defend", "defender", "defienda", "defiendas", "defienda", "defendamos", "defiendan"),
            new RegPresentSubj("avoid", "evitar"),
            new RegPresentSubj("fight", "luchar"),
            new RegPresentSubj("kill", "matar"),
            new RegPresentSubj("rescue", "rescatar")
    };

    private static final Verb[] Group29 = {
            // PRESENT
            new RegPresentIndic("hug", "abrazar"),
            new RegPresentIndic("love", "amar"),
            new RegPresentIndic("share", "compartir"),
            new RegPresentIndic("invite", "invitar"),
            new IrregPresentIndic("offer", "ofrecer", "ofrezco", "ofreces", "ofrece", "ofrecemos", "ofrecen"),

            // PRETERITE
            new IrregPreteriteIndic("hugged", "abrazar", "abracé", "abrazaste", "abrazó", "abrazamos",
                    "abrazaron"),
            new RegPreteriteIndic("loved", "amar"),
            new RegPreteriteIndic("shared", "compartir"),
            new RegPreteriteIndic("invited", "invitar"),
            new RegPreteriteIndic("offered", "ofrecer"),

            // FUTURE
            new RegFutureIndic("will hug", "abrazar"),
            new RegFutureIndic("will love", "amar"),
            new RegFutureIndic("will share", "compartir"),
            new RegFutureIndic("will invite", "invitar"),
            new RegFutureIndic("will offer", "ofrecer"),

            // IMPERFECT
            new RegImperfectIndic("hugged", "abrazar"),
            new RegImperfectIndic("loved", "amar"),
            new RegImperfectIndic("shared", "compartir"),
            new RegImperfectIndic("invited", "invitar"),
            new RegImperfectIndic("offered", "ofrecer"),

            // PRESENT SUBJUNCTIVE
            new IrregPresentSubj("hug", "abrazar", "abrace", "abraces", "abrace", "abracemos", "abracen"),
            new RegPresentSubj("love", "amar"),
            new RegPresentSubj("share", "compartir"),
            new RegPresentSubj("invite", "invitar"),
            new IrregPresentSubj("offer", "ofrecer", "ofrezca", "ofrezcas", "ofrezca", "ofrezcamos", "ofrezcan")
    };

    private static final Verb[] Group30 = {
            // PRESENT
            new RegPresentIndic("grab", "agarrar"),
            new RegPresentIndic("reach", "alcanzar", "reaches"),
            new IrregPresentIndic("pick up", "recoger", "recojo", "recoges",
                    "recoge", "recogemos", "recogen", "pick up", "pick up",
                    "picks up", "pick up", "pick up"),
            new RegPresentIndic("jump", "saltar"),
            new RegPresentIndic("throw", "tirar"),

            // PRETERITE
            new RegPreteriteIndic("grabbed", "agarrar"),
            new IrregPreteriteIndic("reached", "alcanzar", "alcancé", "alcanzaste", "alcanzó", "alcanzamos",
                    "alcanzaron"),
            new RegPreteriteIndic("picked up", "recoger"),
            new RegPreteriteIndic("jumped", "saltar"),
            new RegPreteriteIndic("threw", "tirar"),

            // FUTURE
            new RegFutureIndic("will grab", "agarrar"),
            new RegFutureIndic("will reach", "alcanzar"),
            new RegFutureIndic("will pick up", "recoger"),
            new RegFutureIndic("will jump", "saltar"),
            new RegFutureIndic("will throw", "tirar"),

            // IMPERFECT
            new RegImperfectIndic("grabbed", "agarrar"),
            new RegImperfectIndic("reached", "alcanzar"),
            new RegImperfectIndic("picked up", "recoger"),
            new RegImperfectIndic("jumped", "saltar"),
            new RegImperfectIndic("threw", "tirar"),

            // PRESENT SUBJUNCTIVE
            new RegPresentSubj("grab", "agarrar"),
            new IrregPresentSubj("reach", "alcanzar", "alcance", "alcances", "alcance", "alcancemos", "alcancen"),
            new IrregPresentSubj("pick up", "recoger", "recoja", "recojas", "recoja", "recojamos", "recojan"),
            new RegPresentSubj("jump", "saltar"),
            new RegPresentSubj("throw", "tirar")
    };


    public WordBank() {
        numWords = NUM_GROUPS * NUM_VERBS_PER_GROUP;
        allVerbs = getAllVerbs();
    }

    public int getNumWords() {
        return numWords;
    }

    public int getNumGroups() { return NUM_GROUPS; }

    public Verb[] getAllVerbs() {
        Verb[] allVerbs = new Verb[numWords];
        int i = 0;
        for (int j = 0; j < Group1.length; j++) { allVerbs[i++] = Group1[j]; }
        for (int j = 0; j < Group2.length; j++) { allVerbs[i++] = Group2[j]; }
        for (int j = 0; j < Group3.length; j++) { allVerbs[i++] = Group3[j]; }
        for (int j = 0; j < Group4.length; j++) { allVerbs[i++] = Group4[j]; }
        for (int j = 0; j < Group5.length; j++) { allVerbs[i++] = Group5[j]; }
        for (int j = 0; j < Group6.length; j++) { allVerbs[i++] = Group6[j]; }
        for (int j = 0; j < Group7.length; j++) { allVerbs[i++] = Group7[j]; }
        for (int j = 0; j < Group8.length; j++) { allVerbs[i++] = Group8[j]; }
        for (int j = 0; j < Group9.length; j++) { allVerbs[i++] = Group9[j]; }
        for (int j = 0; j < Group10.length; j++) { allVerbs[i++] = Group10[j]; }
        for (int j = 0; j < Group11.length; j++) { allVerbs[i++] = Group11[j]; }
        for (int j = 0; j < Group12.length; j++) { allVerbs[i++] = Group12[j]; }
        for (int j = 0; j < Group13.length; j++) { allVerbs[i++] = Group13[j]; }
        for (int j = 0; j < Group14.length; j++) { allVerbs[i++] = Group14[j]; }
        for (int j = 0; j < Group15.length; j++) { allVerbs[i++] = Group15[j]; }
        for (int j = 0; j < Group16.length; j++) { allVerbs[i++] = Group16[j]; }
        for (int j = 0; j < Group17.length; j++) { allVerbs[i++] = Group17[j]; }
        for (int j = 0; j < Group18.length; j++) { allVerbs[i++] = Group18[j]; }
        for (int j = 0; j < Group19.length; j++) { allVerbs[i++] = Group19[j]; }
        for (int j = 0; j < Group20.length; j++) { allVerbs[i++] = Group20[j]; }
        for (int j = 0; j < Group21.length; j++) { allVerbs[i++] = Group21[j]; }
        for (int j = 0; j < Group22.length; j++) { allVerbs[i++] = Group22[j]; }
        for (int j = 0; j < Group23.length; j++) { allVerbs[i++] = Group23[j]; }
        for (int j = 0; j < Group24.length; j++) { allVerbs[i++] = Group24[j]; }
        for (int j = 0; j < Group25.length; j++) { allVerbs[i++] = Group25[j]; }
        for (int j = 0; j < Group26.length; j++) { allVerbs[i++] = Group26[j]; }
        for (int j = 0; j < Group27.length; j++) { allVerbs[i++] = Group27[j]; }
        for (int j = 0; j < Group28.length; j++) { allVerbs[i++] = Group28[j]; }
        for (int j = 0; j < Group29.length; j++) { allVerbs[i++] = Group29[j]; }
        for (int j = 0; j < Group30.length; j++) { allVerbs[i++] = Group30[j]; }
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
                              boolean isRegFut, boolean isIrregFut, boolean isRegImpInd, boolean isIrregImpInd,
                              boolean isRegPresSubj, boolean isIrregPresSubj) {
        ArrayList<Verb> newList = new ArrayList<Verb>();
        for (int i = 0; i < verbList.length; i++) {
            if (verbList[i].getClass().toString().equals("class blackbox.verbdrill.RegPresentIndic") && isRegPres)
                newList.add(verbList[i]);
            if (verbList[i].getClass().toString().equals("class blackbox.verbdrill.IrregPresentIndic") && isIrregPres)
                newList.add(verbList[i]);
            if (verbList[i].getClass().toString().equals("class blackbox.verbdrill.RegPreteriteIndic") && isRegPret)
                newList.add(verbList[i]);
            if (verbList[i].getClass().toString().equals("class blackbox.verbdrill.IrregPreteriteIndic") && isIrregPret)
                newList.add(verbList[i]);
            if (verbList[i].getClass().toString().equals("class blackbox.verbdrill.RegFutureIndic") && isRegFut)
                newList.add(verbList[i]);
            if (verbList[i].getClass().toString().equals("class blackbox.verbdrill.IrregFutureIndic") && isIrregFut)
                newList.add(verbList[i]);
            if (verbList[i].getClass().toString().equals("class blackbox.verbdrill.RegImperfectIndic") && isRegImpInd)
                newList.add(verbList[i]);
            if (verbList[i].getClass().toString().equals("class blackbox.verbdrill.IrregImperfectIndic") && isIrregImpInd)
                newList.add(verbList[i]);
            if (verbList[i].getClass().toString().equals("class blackbox.verbdrill.RegPresentSubj") && isRegPresSubj)
                newList.add(verbList[i]);
            if (verbList[i].getClass().toString().equals("class blackbox.verbdrill.IrregPresentSubj") && isIrregPresSubj)
                newList.add(verbList[i]);
        }
        return newList.toArray(new Verb[newList.size()]);
    }

}
