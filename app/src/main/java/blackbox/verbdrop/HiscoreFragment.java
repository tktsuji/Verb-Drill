package blackbox.verbdrop;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 *  A fragment for tabbed layout in UserLog that will show hiscore.
 *  Based off code from:
 * https://guides.codepath.com/android/ViewPager-with-FragmentPagerAdapter#layout-viewpager
 */
public class HiscoreFragment extends Fragment {
    private String title;
    SharedPreferences sharedPref;
    private int hiscoreFNB, ultHiscoreFNB, hiscoreMC, ultHiscoreMC;

    // newInstance constructor for creating fragment with arguments
    public static HiscoreFragment newInstance(String title) {
        HiscoreFragment fragmentFirst = new HiscoreFragment();
        Bundle args = new Bundle();
        args.putString("someTitle", title);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title = getArguments().getString("someTitle");
        sharedPref = this.getActivity().getSharedPreferences("hiscoreData", Context.MODE_PRIVATE);
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hiscore, container, false);
        Typeface tf = Typeface.createFromAsset(this.getActivity().getAssets(), "fonts/chalkboard-bold.ttf");
        TextView fillNBlankTV = (TextView) view.findViewById(R.id.textViewFillNBlank);
        TextView mcTV = (TextView) view.findViewById(R.id.textViewMC);
        TextView highStreakFNB = (TextView) view.findViewById(R.id.textViewHiscoreFNB);
        TextView ultHighStreakFNB = (TextView) view.findViewById(R.id.textViewUltimateHiscoreFNB);
        TextView highStreakMC = (TextView) view.findViewById(R.id.textViewHiscoreMC);
        TextView ultHighStreakMC = (TextView) view.findViewById(R.id.textViewUltimateHiscoreMC);
        fillNBlankTV.setTypeface(tf);
        mcTV.setTypeface(tf);
        highStreakFNB.setTypeface(tf);
        ultHighStreakFNB.setTypeface(tf);
        highStreakMC.setTypeface(tf);
        ultHighStreakMC.setTypeface(tf);

        getHiscoreData();
        TextView highStreakFNB2 = (TextView) view.findViewById(R.id.textViewHiscoreFNB2);
        TextView ultHighStreakFNB2 = (TextView) view.findViewById(R.id.textViewUltimateHiscoreFNB2);
        TextView highStreakMC2 = (TextView) view.findViewById(R.id.textViewHiscoreMC2);
        TextView ultHighStreakMC2 = (TextView) view.findViewById(R.id.textViewUltimateHiscoreMC2);
        highStreakFNB2.setText(Integer.toString(hiscoreFNB));
        ultHighStreakFNB2.setText(Integer.toString(ultHiscoreFNB));
        highStreakMC2.setText(Integer.toString(hiscoreMC));
        ultHighStreakMC2.setText(Integer.toString(ultHiscoreMC));
        return view;
    }

    public void getHiscoreData() {
        hiscoreFNB = sharedPref.getInt("hiscoreFNB", 0);
        ultHiscoreFNB = sharedPref.getInt("ultimateHiscoreFNB", 0);
        hiscoreMC = sharedPref.getInt("hiscoreMC", 0);
        ultHiscoreMC = sharedPref.getInt("ultimateHiscoreMC", 0);
    }
}