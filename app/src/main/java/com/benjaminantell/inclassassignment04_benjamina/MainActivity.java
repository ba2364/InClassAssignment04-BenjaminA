package com.benjaminantell.inclassassignment04_benjamina;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{
    private CheckBox checkBox;
    private EditText titleField;
    private EditText messageField;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkBox = (CheckBox) findViewById(R.id.titleCheck);
        titleField = (EditText) findViewById(R.id.title);
        messageField = (EditText) findViewById(R.id.message);
    }

    public void launchCamera(View view)
    {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null)
        {
            startActivity(intent);
        }
    }

    public void sendMail(View view)
    {
        EditText titleField = (EditText) findViewById(R.id.title);
        String title = titleField.getText().toString();

        EditText messageField = (EditText) findViewById(R.id.message);
        String message = messageField.getText().toString();

        CheckBox onlyTitle = (CheckBox) findViewById(R.id.titleCheck);
        boolean noMessage = onlyTitle.isChecked();

        if (noMessage)
        {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto: "));
            intent.putExtra(Intent.EXTRA_SUBJECT, title);
            if (intent.resolveActivity(getPackageManager()) != null)
            {
                startActivity(intent);
            }
        }
        else
        {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto: "));
            intent.putExtra(Intent.EXTRA_SUBJECT, title);
            intent.putExtra(Intent.EXTRA_TEXT, message);
            if (intent.resolveActivity(getPackageManager()) != null)
            {
                startActivity(intent);
            }
        }
    }

    public void launchActivity(View view)
    {
        CheckBox onlyTitle = (CheckBox) findViewById(R.id.titleCheck);
        boolean noMessage = onlyTitle.isChecked();
        Intent intent = new Intent(this, Main3Activity.class);
        if (noMessage)
        {
            intent.putExtra("TITLE_STRING", titleField.getText().toString());
            startActivity(intent);
        }
        else
        {
            intent.putExtra("TITLE_STRING", titleField.getText().toString());
            intent.putExtra("MESSAGE_STRING", messageField.getText().toString());
            startActivity(intent);
        }
    }
}