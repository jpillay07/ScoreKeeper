package com.codelabs.scorekeeper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final String STATE_SCORE_1 = "Team 1 Score";
    static final String STATE_SCORE_2 = "Team 2 Score";

    private int mScore1;
    private int mScore2;

    private TextView mScore1TextView;
    private TextView mScore2TextView;

    private ImageButton decreaseScore1;
    private ImageButton decreaseScore2;

    private ImageButton increaseScore1;
    private ImageButton increaseScore2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScore1 = 0;
        mScore2 = 0;

        mScore1TextView = findViewById(R.id.score_1);
        mScore1TextView.setText(String.valueOf(mScore1));
        mScore2TextView = findViewById(R.id.score_2);
        mScore2TextView.setText(String.valueOf(mScore2));

        decreaseScore1 = findViewById(R.id.decreaseTeam1);
        decreaseScore2 = findViewById(R.id.decreaseTeam2);

        increaseScore1 = findViewById(R.id.increaseTeam1);
        increaseScore2 = findViewById(R.id.increaseTeam2);

        decreaseScore1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mScore1--;
                mScore1TextView.setText(String.valueOf(mScore1));
            }
        });

        decreaseScore2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mScore2--;
                mScore2TextView.setText(String.valueOf(mScore2));
            }
        });

        increaseScore1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mScore1++;
                mScore1TextView.setText(String.valueOf(mScore1));
            }
        });

        increaseScore2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mScore2++;
                mScore2TextView.setText(String.valueOf(mScore2));
            }
        });

        if (savedInstanceState != null) {
            mScore1 = savedInstanceState.getInt(STATE_SCORE_1);
            mScore2 = savedInstanceState.getInt(STATE_SCORE_2);

            //Set the score text views
            mScore1TextView.setText(String.valueOf(mScore1));
            mScore2TextView.setText(String.valueOf(mScore2));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        //Check if the correct item was clicked
        if(item.getItemId()==R.id.night_mode){
            // Get the night mode state of the app.
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            //Set the theme mode for the restarted activity
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode
                        (AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode
                        (AppCompatDelegate.MODE_NIGHT_YES);
            }
// Recreate the activity for the theme change to take effect.
            recreate();
        }

        return true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // Save the scores.
        outState.putInt(STATE_SCORE_1, mScore1);
        outState.putInt(STATE_SCORE_2, mScore2);
        super.onSaveInstanceState(outState);
    }
}


