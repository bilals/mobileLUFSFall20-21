package com.example.codelab12ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int count = 0;

    // this is the main callback method or hook that is triggered at startup of the app
    // the savedInstanceState param can be used to save data between 2 calls of the app onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("Launching","The app is calling this line at startup...");

        final TextView countTV = this.findViewById(R.id.countTV);

        Button countButton = findViewById(R.id.countButton);
//        countButton.setOnClickListener(new MyExternalClickListener(this));
//        countButton.setOnClickListener(new MyInternalClickListener());

        countButton.setOnClickListener(new View.OnClickListener() {
            // This is an anonymous inner class; besides methods and attributes,
            // it also has access to local variables
            @Override
            public void onClick(View v) {
                count++;
                countTV.setText(Integer.toString(count));
            }
        });
    }

    public void showToast(View view) {
        Toast.makeText(this, "Thank you for your attention!", Toast.LENGTH_LONG).show();
//        Button countButton = findViewById(R.id.countButton);
//        countButton.setText("Great!");
    }

    private class MyInternalClickListener implements View.OnClickListener {
        // Inner classes have access to the methods and attributes of the outer class
        // BUT not to the local variables in other methods

        @Override
        public void onClick(View v) {
            count++;
            TextView countTV = MainActivity.this.findViewById(R.id.countTV);
            countTV.setText(""+count); // String.valueOf(count)
        }
    }
}