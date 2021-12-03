package com.example.currconvertion;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.security.PrivateKey;

public class Convertion extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    private double reference;
    private Button convert;
    private EditText txtEuro;
    private TextView txtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convertion);


        Spinner dropdown = findViewById(R.id.spinner);
        String[] items = new String[]{"USD", "R$",};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(this);

        txtEuro=findViewById(R.id.editTxtEuro);
        txtResult=findViewById(R.id.txtAns);
        convert=findViewById(R.id.btnConvert);
        convert.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        txtResult.setText(String.format("%.03f", Float.valueOf(txtEuro.getText().toString()) * reference));
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        switch (position) {
            case 0:
                reference=1.13;
                break;
            case 1:
                reference=6.38;
                break;


        }
    }


    @Override
    public void onNothingSelected (AdapterView < ? > adapterView){

    }

}