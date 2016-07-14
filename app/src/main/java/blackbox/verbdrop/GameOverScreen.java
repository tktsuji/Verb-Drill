package blackbox.verbdrop;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

/**
 *  Displays Game Over screen.
 */
public class GameOverScreen extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_over);
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/chalkboard-bold.ttf");
        TextView gameOverTV = (TextView) findViewById(R.id.txtViewOver);
        gameOverTV.setTypeface(tf);
        TextView correctAnswTV = (TextView) findViewById(R.id.txtViewCorrect);
        correctAnswTV.setTypeface(tf);
        TextView yourResponseTV = (TextView) findViewById(R.id.txtViewYourResponse);
        yourResponseTV.setTypeface(tf);
        TextView streakTV = (TextView) findViewById(R.id.txtViewStreak);
        streakTV.setTypeface(tf);
        TextView highStreakTV = (TextView) findViewById(R.id.txtViewHighStreak);
        highStreakTV.setTypeface(tf);
        TextView promptTV = (TextView) findViewById(R.id.txtViewPrompt);
        promptTV.setTypeface(tf);
        TextView prompt2TV = (TextView) findViewById(R.id.txtViewPrompt2);
        TextView correctAnsw2TV = (TextView) findViewById(R.id.txtViewCorrect2);
        TextView yourResponse2TV = (TextView) findViewById(R.id.txtViewYourResponse2);
        TextView streak2TV = (TextView) findViewById(R.id.txtViewStreak2);
        TextView highStreak2TV = (TextView) findViewById(R.id.txtViewHighStreak2);
        Bundle extras = getIntent().getExtras();
        prompt2TV.setText(extras.getString("engPhrase"));
        correctAnsw2TV.setText(extras.getString("correctPhrase"));
        yourResponse2TV.setText(extras.getString("userPhrase"));
        streak2TV.setText(Integer.toString(extras.getInt("streak")));
    }
}
