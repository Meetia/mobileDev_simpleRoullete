package edu.tufts.cs.tinyapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

/**
 * Created by Meet Patel on 9/18/2017.
 */

public class ResultScreen extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.results);
        Intent getResult = getIntent();

        String result = getResult.getExtras().getString("result");
        TextView resultMsg = (TextView) findViewById(R.id.winnerText);

        resultMsg.append(result);
    }
}
