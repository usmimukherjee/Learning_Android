package com.example.android_basics;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.snackbar.Snackbar;

// Define CalculatorActivity class, extending AppCompatActivity and implementing OnItemSelectedListener
public class CalculatorActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    // Array to store spinner options
    String spinlist[] = {"Select an option", "first", "second", "third"};
    Spinner spin;
    // Called when the activity is first created.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content view to the layout defined in calculator_layout.xml
        setContentView(R.layout.calculator_layout);

        // Initialize UI elements
        EditText num1 = findViewById(R.id.num1);
        EditText num2 = findViewById(R.id.num2);
        TextView result = findViewById(R.id.result);
        Button calculate = findViewById(R.id.calculate);

        // Initialize and set up the spinner
        spin = findViewById(R.id.spinner2);
        spin.setPrompt("Select an option");
//        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinlist);
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, spinlist) {
            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    return false;
                }
                return true;
            }

            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView textview = (TextView) view;
                if (position == 0) {
                    textview.setTextColor(Color.TRANSPARENT);
                } else {
                    textview.setTextColor(Color.BLACK);
                }
                return view;
            }
        };
        spin.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spin.setAdapter(aa);

        // Create a Snackbar for displaying success message
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content),"success", Snackbar.LENGTH_SHORT);

        // Add a click listener to the calculate button
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Retrieve values from input fields and perform the calculation
                int n1 = Integer.parseInt(num1.getText().toString());
                int n2 = Integer.parseInt(num2.getText().toString());

                // Display the result in the result TextView
                result.setText("Resulting sum is " + (n1 + n2));
                // Show the Snackbar indicating success
                snackbar.show();
            }
        });
    }

    // Callback method for item selection in the spinner
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        // Show a Toast indicating the selected item
//        Toast.makeText(this, "Selected item is "+spinlist[position], Toast.LENGTH_SHORT).show();
        String selectedItemText = spinlist[position];
        if (position > 0) {
            Toast.makeText(getApplicationContext(), "Selected:" + selectedItemText, Toast.LENGTH_SHORT).show();
        }
    }


    // Callback method for no item selected in the spinner
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // No action needed in this case
    }
}

