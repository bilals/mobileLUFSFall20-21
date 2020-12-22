package com.example.codelab42_inputcontrols;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner countrySelector = findViewById(R.id.countrySelector);

        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(this,
                        R.array.countries, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countrySelector.setAdapter(adapter);

        countrySelector.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        String selectedCountryName = adapterView.getItemAtPosition(position).toString();
        TextView selectedValueTV = findViewById(R.id.selectedValue);
        String[] countriesNames = getResources().getStringArray(R.array.countries);
        String noSelectionLabel = countriesNames[0];
        if (selectedCountryName.equals(noSelectionLabel)) {
            selectedValueTV.setText("Please select a country name");
        }else{
            selectedValueTV.setText("You selected: " + selectedCountryName);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // not relevant in this exercise...
    }
}