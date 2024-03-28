package com.myapp.tdd_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etTextToUpdate;
    private Button btn;
    private TextView tvChangedText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etTextToUpdate = (EditText)findViewById(R.id.etTextToUpdate);
        btn = (Button)findViewById(R.id.btn);
        tvChangedText = (TextView)findViewById(R.id.tvChangedText);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvChangedText.setText(etTextToUpdate.getText().toString());
                Intent myIntent = new Intent(MainActivity.this, Welcome.class);
                myIntent.putExtra("key", etTextToUpdate.getText().toString()); //Optional parameters
                MainActivity.this.startActivity(myIntent);
            }
        });
    }
}