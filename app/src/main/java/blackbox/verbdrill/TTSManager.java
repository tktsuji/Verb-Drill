package blackbox.verbdrill;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import java.util.Locale;

/**
 *  Created by Nilanchala
 *  http://www.javatechig.com
 *  To be used for text-to-speech
 */

public class TTSManager {

    private TextToSpeech mTts = null;
    private boolean isLoaded = false;
    private boolean isLangSupported = false;

    public void init(Context context) {
        try {
            mTts = new TextToSpeech(context, onInitListener);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private TextToSpeech.OnInitListener onInitListener = new TextToSpeech.OnInitListener() {
        @Override
        public void onInit(int status) {
            if (status == TextToSpeech.SUCCESS) {
                Locale locSpanish = new Locale("spa", "MEX");
                int result = mTts.setLanguage(locSpanish);
                mTts.setSpeechRate(0.8f);
                isLoaded = true;

                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    Log.e("error", "This Language is not supported");
                } else {
                    isLangSupported = true;
                }
            } else {
                Log.e("error", "Initialization Failed!");
            }
        }
    };

    public void shutDown() {
        mTts.shutdown();
    }

    public void addQueue(String text) {
        if (isLoaded)
            mTts.speak(text, TextToSpeech.QUEUE_ADD, null);
        else
            Log.e("error", "TTS Not Initialized");
    }

    public void initQueue(String text) {
        if (isLoaded)
            mTts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
        else
            Log.e("error", "TTS Not Initialized");
    }

    public boolean getIsLangSupported() {
        return isLangSupported;
    }

}