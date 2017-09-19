package edu.tufts.cs.tinyapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioGroup;
import android.widget.RadioButton;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    public void onRollClick(View view) {
        Intent getResultScreenIntent = new Intent(this, ResultScreen.class);
        RadioGroup p1Group = (RadioGroup) findViewById(R.id.p1Group);
        RadioGroup p2Group = (RadioGroup) findViewById(R.id.p2Group);

        // get selected radio button from radioGroup
        int selectedIdP1 = p1Group.getCheckedRadioButtonId();
        int selectedIdP2 = p2Group.getCheckedRadioButtonId();

        // find the radiobutton by returned id
        RadioButton radioP1Button = (RadioButton) findViewById(selectedIdP1);
        RadioButton radioP2Button = (RadioButton) findViewById(selectedIdP2);

        String winOutput = "";
        int res = calculateWinner(radioP1Button.getText().toString(), radioP2Button.getText().toString());
        if (res == 0) {
            winOutput = "Both Players!";
        } else if (res == 1) {
            winOutput = "Player 1!";
        } else if (res == -1) {
            winOutput = "Player 2!";
        }
        getResultScreenIntent.putExtra("result", winOutput);
        startActivity(getResultScreenIntent);
    }

    public int calculateWinner(String guessP1, String guessP2) {
        Random generator = new Random();
        int i = generator.nextInt(32) + 1;
        int output = 0;

        if (i%2 == 0) {
            if (guessP1.equals("Even")) {
                output += 1;
            }
            if (guessP2.equals("Even")) {
                output -= 1;
            }
        } else {
            if (guessP1.equals("Odd")) {
                output += 1;
            }
            if (guessP2.equals("Odd")) {
                output -= 1;
            }
        }
        return output;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
