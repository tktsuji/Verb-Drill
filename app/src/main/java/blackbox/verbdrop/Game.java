package blackbox.verbdrop;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by tricia on 3/21/16.
 */

public class Game extends Activity {

    private WordBank wordBank = new WordBank();

    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        generateVerb();
    }

    public void generateVerb() {

        TextView engPhrase = (TextView) findViewById(R.id.txtViewEngPhrase);
        engPhrase.setText("bleh");
    }
}
