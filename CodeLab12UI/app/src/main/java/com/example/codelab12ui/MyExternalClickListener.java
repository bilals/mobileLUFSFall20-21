package com.example.codelab12ui;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

public class MyExternalClickListener implements View.OnClickListener {

    private int count = 0;
    private final Activity activity;

    public MyExternalClickListener(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        // Toast.makeText(activity,"Hello from external listener!",Toast.LENGTH_LONG).show();
        count++;
        TextView countTV = activity.findViewById(R.id.countTV);
        countTV.setText(""+count); // String.valueOf(count)
    }
}
