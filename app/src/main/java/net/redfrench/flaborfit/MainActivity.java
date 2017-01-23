package net.redfrench.flaborfit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.RelativeLayout;

import static net.redfrench.flaborfit.R.id.gear;

public class MainActivity extends AppCompatActivity {

    // variables - these are constants ('final')
    public static final String EXTRA_ITEM_TITLE = "extra.item.title";  // 'public' means this is accessible outside of MainActivity
    public static final String EXERCISE_WEIGHTS = "Weight lifting";  // 'static' means there's only 1 instance of this in memory
    public static final String EXERCISE_YOGA = "Yoga";  // 'final' means it cannot be edited (it's a constant - value can't change after it's set)
    public static final String EXERCISE_CARDIO = "Cardio";  // starting these with 'EXERCISE' helps see them all when using autocomplete

    @Override
    protected void onCreate(Bundle savedInstanceState) {  // 'protected'-> only anything within this Java package has access
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // DOM references
        RelativeLayout weightBtn = (RelativeLayout) findViewById(R.id.weightBtn);  // note, clickable areas are a relative layout, not buttons
        RelativeLayout yogaBtn = (RelativeLayout) findViewById(R.id.yogaBtn);
        RelativeLayout cardioBtn = (RelativeLayout) findViewById(R.id.cardioBtn);
     ---> LAYOUT    settingsIcon = () findViewById(gear);


        //  click-event listeners
        weightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDetailActivity(MainActivity.EXERCISE_WEIGHTS);  // always access static variables using class name followed by variable name
            }                                                       // this would work passing in only 'EXERCISE_WEIGHTS', but it's not the proper way
        });                                                         // if calling this from another class, would have to use the variable's class name

        yogaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDetailActivity(MainActivity.EXERCISE_YOGA);
            }
        });

        cardioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDetailActivity(MainActivity.EXERCISE_CARDIO);
            }
        });

        settingsIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadSettingsActivity();
            }
        });
    }


    // function tells activity manager what activity to load
    private void loadDetailActivity(String exerciseTitle) {
        // load DetailActivity
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);  // The first parameter tells which activity (MainActivity) is
        // loading the new activity (DetailActivity).
        // pass in exerciseTitle (passed into loadDetailActivity())
        intent.putExtra(MainActivity.EXTRA_ITEM_TITLE, exerciseTitle);  // EXTRA_ITEM_TITLE is the key storing the value of exerciseTitle
        startActivity(intent);  // send the intent to activity manager (OS level) which decides how to start the activity
    }
    // An ‘Intent' is a messenger that can send data or messages to the operating system.
    // You can send data or a message and say, “hey, I have the intent to do this."


    private void loadSettingsActivity() {
        Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(intent);
    }


}