package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.example.converter.Setters.CurrentValuteCurs;
import com.example.converter.models.ValCurs;
import com.example.converter.models.Valute;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner_1, spinner_2;
    private EditText input_1, input_2;
    private ValCurs valCurs;
    private List<Valute> valCursList;
    private List<String> names = new ArrayList<>();
    private List<String> values = new ArrayList<>();
    private String input1, input2;
    private int chose_1, chose_2;
    private float value1, value2 = 1;
    private float valuteSpinner1, valuteSpinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner_1 = (Spinner) findViewById(R.id.spinner_1);
        spinner_2 = (Spinner) findViewById(R.id.spinner_2);
        input_1 = (EditText) findViewById(R.id.input_1);
        input_2 = (EditText) findViewById(R.id.input_2);
        valCurs = CurrentValuteCurs.getCurrentValuteCurs();
        valCursList = valCurs.addValute("Российский рубль", "1,0000","1");
        for (int i = 0; i < valCursList.size(); i++) {
            names.add(valCursList.get(i).getName());
            values.add(String.valueOf(Float.valueOf(valCursList.get(i).getValue().replace(",", "."))/Float.valueOf(valCursList.get(i).getNominal())));
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, names);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_1.setAdapter(adapter);
        spinner_2.setAdapter(adapter);

        if (input2 == null) {
            spinner_2.setSelection(11);
            getValuteCurs();
            input1 = spinner_1.getSelectedItem().toString();
            input_2.setText(value2 + "");
            updateStartText();
            chose_1 = spinner_1.getSelectedItemPosition();
            chose_2 = spinner_2.getSelectedItemPosition();
        }

        spinner_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                input1 = parent.getItemAtPosition(position).toString();
                if (input1.equals(input2)) {
                    spinner_2.setSelection(chose_1);
                } else if(!input_1.getText().toString().equals("")) {
                    getValuteCurs();
                    updateEndText();
                }
                chose_1 = spinner_1.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                input2 = parent.getItemAtPosition(position).toString();
                if (input1.equals(input2)) {
                    spinner_1.setSelection(chose_2);
                } else if(!input_2.getText().toString().equals("")) {
                    getValuteCurs();
                    updateEndText();
                }
                chose_2 = spinner_2.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        input_1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!input_1.getText().toString().equals("") && input_1.hasFocus()) {
                    value1 = Float.valueOf(input_1.getText().toString());
                    getValuteCurs();
                    updateEndText();
                }else if(input_1.hasFocus()){
                    input_2.setText("");
                }
            }
        });

        input_2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!input_2.getText().toString().equals("") && input_2.hasFocus()) {
                    value2 = Float.valueOf(input_2.getText().toString());
                    getValuteCurs();
                    updateStartText();
                }else if(input_2.hasFocus()){
                    input_1.setText("");
                }
            }
        });
    }

    private void getValuteCurs(){
        valuteSpinner1 = Float.valueOf(values.get(spinner_1.getSelectedItemPosition()));
        valuteSpinner2 = Float.valueOf(values.get(spinner_2.getSelectedItemPosition()));
    }

    private void updateStartText(){
        value1 = value2 * valuteSpinner2 / valuteSpinner1;
        input_1.setText(value1 + "");
    }

    private void updateEndText(){
        value2 = value1 * valuteSpinner1 / valuteSpinner2;
        input_2.setText(value2 + "");
    }

}
