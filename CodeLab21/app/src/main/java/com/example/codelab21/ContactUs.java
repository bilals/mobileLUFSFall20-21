package com.example.codelab21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ContactUs extends AppCompatActivity {

    public static final String REPLY_MESSAGE_KEY = "REPLY_MESSAGE_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contc_us);
        String message = getIntent().getStringExtra(MainActivity.GIVEN_MESSAGE_KEY);
        TextView givenMessageTV = findViewById(R.id.givenMessageTV);
        if(message != null)
        {
            givenMessageTV.setText(message);
        }else{
            givenMessageTV.setText(R.string.no_message);
        }
    }

    public void replyBack(View view) {
        Intent replyIntent = new Intent();
        EditText replyET = (EditText) findViewById(R.id.replyET);
        String replyMessage = replyET.getText().toString();
        replyIntent.putExtra(REPLY_MESSAGE_KEY, replyMessage);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}