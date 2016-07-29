package blackbox.verbdrop;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
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
    SharedPreferences hiscoreDatabase;

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
        hiscoreDatabase = PreferenceManager.getDefaultSharedPreferences(this.getActivity());
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hiscore, container, false);
        TextView tvLabel = (TextView) view.findViewById(R.id.tvLabel);
        tvLabel.setText(title);
        return view;
    }
}