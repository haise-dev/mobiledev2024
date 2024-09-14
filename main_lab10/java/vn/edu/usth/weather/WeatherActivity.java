package vn.edu.usth.weather;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class WeatherActivity extends FragmentActivity {
    public static final String Command = "WeatherActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        // Set up window insets handling for edge-to-edge layout
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Find the TabLayout and ViewPager
        ViewPager viewPager = findViewById(R.id.view_pager);
        TabLayout tabLayout = findViewById(R.id.tab_layout);

        // Set up the ViewPager and its adapter
        FragmentStatePagerAdapter pagerAdapter = new FragmentStatePagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
            @Override
            public Fragment getItem(int position) {
                // Return different instance of WeatherAndForecastFragment based on position
                return WeatherAndForecastFragment.newInstance("Param1_" + position, "Param2_" + position);
            }

            @Override
            public int getCount() {
                // Number of pages (fragments) in the ViewPager (just duplicated for now)
                return 3;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                // Return the title for each tab
                switch (position) {
                    case 0:
                        return "Hanoi, Vietnam";
                    case 1:
                        return "Paris, France";
                    case 2:
                        return "Toulouse, France";
                    default:
                        return null;
                }
            }
        };

        // Set the adapter to the ViewPager
        viewPager.setAdapter(pagerAdapter);

        // Attach the TabLayout to the ViewPager
        tabLayout.setupWithViewPager(viewPager);

        Log.i(Command, "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(Command, "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(Command, "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(Command, "onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(Command, "onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(Command, "onStop");
    }
}
