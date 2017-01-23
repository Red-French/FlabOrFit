package net.redfrench.flaborfit;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // DOM references
        TextView exerciseText = (TextView)findViewById(R.id.exerciseTitle);  // heading
        ImageView exerciseImg = (ImageView)findViewById(R.id.exerciseImage);
        LinearLayout mainBG = (LinearLayout)findViewById(R.id.mainBG);

        // update heading
        String exerciseTitle = getIntent().getStringExtra(MainActivity.EXTRA_ITEM_TITLE);  // retrieve value of key (EXTRA_ITEM_TITLE) from MainActivity
        exerciseText.setText(exerciseTitle);

        // update image and background color
        if (exerciseTitle.equalsIgnoreCase(MainActivity.EXERCISE_WEIGHTS)) {
            exerciseImg.setImageDrawable(getResources().getDrawable(R.drawable.weight, getApplicationContext().getTheme()));
                                      // getResources() - grabs the resources from your bundle where images, etc. are stored.
                                      // getDrawable(R.drawable.weight) - Gets the weight image from the drawable resources
                                      // The 2nd parameter (REQUIRED) of getDrawable() is the theme you want to apply.
                                      // getApplicationContext() gets the main context of the app, and getTheme() is your main theme.
            mainBG.setBackgroundColor(Color.parseColor("#2ca5f5"));  // parseColor turns the hex into a color
        } else if (exerciseTitle.equalsIgnoreCase(MainActivity.EXERCISE_YOGA)) {
            exerciseImg.setImageDrawable(getResources().getDrawable(R.drawable.lotus, getApplicationContext().getTheme()));
            mainBG.setBackgroundColor(Color.parseColor("#916bcd"));
        } else {
            exerciseImg.setImageDrawable(getResources().getDrawable(R.drawable.heart, getApplicationContext().getTheme()));
            mainBG.setBackgroundColor(Color.parseColor("#52ad56"));
        }
    }
}
