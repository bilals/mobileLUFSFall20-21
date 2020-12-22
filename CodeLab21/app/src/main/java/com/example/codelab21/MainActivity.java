package com.example.codelab21;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String GIVEN_MESSAGE_KEY = "GivenMessageKey";
    public static final int GET_REPLY_REQUEST_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openContactUs(View view) {
        Intent launchContactUsIntent = new Intent(this, ContactUs.class);
        EditText messageET = findViewById(R.id.messageET);
        String message = messageET.getText().toString();
        if(message != "")
        {
            launchContactUsIntent.putExtra(GIVEN_MESSAGE_KEY,message);
        }
        // startActivity(launchContactUsIntent);
        startActivityForResult(launchContactUsIntent, GET_REPLY_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent replyIntent) {
        super.onActivityResult(requestCode, resultCode, replyIntent);
        if(resultCode == RESULT_OK && requestCode == GET_REPLY_REQUEST_CODE)
        {
            String replyMessage = replyIntent.getStringExtra(ContactUs.REPLY_MESSAGE_KEY);
            TextView replyMsgTV = findViewById(R.id.replyMsgTV);
            replyMsgTV.setText(replyMessage);
        }
    }

    public void visitWebSite(View view) {
        Intent openWebSite = new Intent(
                Intent.ACTION_VIEW,
                Uri.parse("http://moodle.bilalsaid.com"));
        startActivity(openWebSite);
    }
}