package com.benjaminantell.inclassassignment04_benjamina;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity
{
    private TextView mainText;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mainText = (TextView) findViewById(R.id.maintext);
        Intent intent = getIntent();
        String title = intent.getStringExtra("TITLE_STRING");
        String message = intent.getStringExtra("MESSAGE_STRING");
        setTitle(title);
        mainText.setText(message);
    }
}
