package net.redfrench.flaborfit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

    String exerciseTitle = getIntent().getStringExtra(MainActivity.EXTRA_ITEM_TITLE);  // retrieve value of key (EXTRA_ITEM_TITLE) from MainActivity
    exerciseText.setText(exerciseTitle);
    }
}
