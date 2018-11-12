package com.example.taruc.lab3_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinnerAge;
    private RadioGroup radioGroupGender;
    private RadioButton radioButtonMale,
            radioButtonFemale;
    private CheckBox checkBoxSmoker;
    private TextView textViewPremium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerAge = findViewById(R.id.spinnerAge);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        radioButtonFemale = findViewById(R.id.radioButtonFemale);
        radioButtonMale = findViewById(R.id.radioButtonMale);
        checkBoxSmoker = findViewById(R.id.checkBoxSmoker);
        textViewPremium = findViewById(R.id.textViewPremium);

        ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource
                (this, R.array.age_group,android.R.layout.simple_spinner_dropdown_item);
        spinnerAge.setAdapter(adapter);
        spinnerAge.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,"Item selected" + position,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void calculatePremium(View view){
        int position;
        int premium = 0;
        position = spinnerAge.getSelectedItemPosition();

        if(position == 0){
            premium = 50;
        }
        else if(position == 1){
            premium = 55;
        }
        else if(position == 2){
            premium = 60;
        }
        else if(position == 3){
            premium = 70;
        }
        else if(position == 4){
            premium = 120;
        }
        else if(position == 5){
            premium = 160;
        }
        else if(position == 6){
            premium = 200;
        }
        else if(position == 7){
            premium = 250;
        }

        //TODO:calculate the basic premium

        int gender;

        gender = radioGroupGender.getCheckedRadioButtonId();
        if(gender == R.id.radioButtonMale){
            //TODO : calculate extra premium for male
            if(position == 2){
                premium += 50;
            }
            else if(position == 3){
                premium += 100;
            }
            else if(position == 4){
                premium += 100;
            }
            else if(position == 5) {
                premium += 50;
            }
        }
        if(checkBoxSmoker.isChecked()){
            //TODO: calculate extra premium for smoker
            if(position == 3){
                premium += 100;
            }
            else if(position == 4){
                premium += 150;
            }
            else if(position == 5){
                premium += 150;
            }
            else if(position == 6){
                premium += 250;
            }
            else if(position == 7) {
                premium += 250;
            }
        }
        textViewPremium.setText(getString(R.string.premium)+"RM" + premium);
    }

    public void resetButton(View view){

    }

}
