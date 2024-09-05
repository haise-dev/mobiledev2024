package vn.edu.usth.weather;

import android.os.Bundle;
import android.util.Log;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WeatherActivity extends AppCompatActivity {
    public static final String Command ="WeatherActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_weather);

        // Set up window insets handling for edge-to-edge layout
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Add fragment transaction code here
        if (findViewById(R.id.main) != null) {
            // Avoid adding fragment multiple times (e.g., on screen rotation)
            if (savedInstanceState != null) {
                return;
            }

            // Create a new instance of ForecastFragment
            ForecastFragment forecastFragment = new ForecastFragment();

            // Add the fragment to the 'fragment_container'
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.main, forecastFragment)
                    .commit();
        }

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