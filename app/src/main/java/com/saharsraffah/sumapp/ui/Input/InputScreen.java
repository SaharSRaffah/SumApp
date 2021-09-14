package com.saharsraffah.sumapp.ui.Input;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.saharsraffah.sumapp.R;
import com.saharsraffah.sumapp.ui.Output.OutputScreen;

public class InputScreen extends AppCompatActivity {

    //initiate UI Elements variables
    EditText first_num, second_num;
    Button result_btn, clear_btn, add_btn, sub_btn, div_btn;
    Intent goToOutputScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_screen);
        //initial view
        initViews();

        goToOutputScreen = new Intent(InputScreen.this, OutputScreen.class);

        //Method for the add result button when clicked
        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number1, number2;
                number1 = first_num.getText().toString();
                number2 = second_num.getText().toString();

                //make sure there's number in both edit text, otherwise show an error message
                if(number1.isEmpty() || number2.isEmpty()){
                   Toast.makeText(InputScreen.this, "please enter the values", Toast.LENGTH_LONG).show();
                }
                else{
                    int num1 = Integer.parseInt(number1);
                    int num2 = Integer.parseInt(number2);
                    sum(num1, num2);
                }
            }
        });

        //Method for the sub result button when clicked
        sub_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number1, number2;
                number1 = first_num.getText().toString();
                number2 = second_num.getText().toString();

                //make sure there's number in both edit text, otherwise show an error message
                if(number1.isEmpty() || number2.isEmpty()){
                    Toast.makeText(InputScreen.this, "please enter the values", Toast.LENGTH_LONG).show();
                }

                /*//another approach for making the user enter the right sequence for numbers
                else if(Integer.parseInt(number1)<Integer.parseInt(number2)){
                    Toast.makeText(InputScreen.this, "invalid values. the first number must be the biggest ", Toast.LENGTH_LONG).show();
                }*/
                else{
                    int num1 = Integer.parseInt(number1);
                    int num2 = Integer.parseInt(number2);
                    sub(num1, num2);
                }
            }
        });

        //Method for the add result button when clicked
        div_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number1, number2;
                number1 = first_num.getText().toString();
                number2 = second_num.getText().toString();

                //make sure there's number in both edit text, otherwise show an error message
                if(number1.isEmpty() || number2.isEmpty()){
                    Toast.makeText(InputScreen.this, "please enter the values", Toast.LENGTH_LONG).show();
                }
                else{
                    double num1 = Double.parseDouble(number1);
                    double num2 = Double.parseDouble(number2);
                    div(num1, num2);
                }
            }
        });

        clear_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                first_num.setText("");
                second_num.setText("");
            }
        });
    }

    public void initViews(){
        //initial EditTexts
        first_num = findViewById(R.id.ed_fNum);
        second_num = findViewById(R.id.ed_sNum);

        //initial Buttons
        result_btn = findViewById(R.id.btn_result);
        clear_btn = findViewById(R.id.btn_clear);
        add_btn = findViewById(R.id.btn_add);
        sub_btn = findViewById(R.id.btn_sub);
        div_btn = findViewById(R.id.btn_div);
    }

    //function of the sums two numbers
    public void sum(double n1, double n2){
        double value = n1 + n2;

        goToOutputScreen.putExtra("result", value);
        startActivity(goToOutputScreen);

        //Toast.makeText(InputScreen.this, "The Result: "+value, Toast.LENGTH_LONG).show();

        /*Intent goToOutputScreen = new Intent(InputScreen.this, OutputScreen.class);

        goToOutputScreen.putExtra("sum", value);

        startActivity(goToOutputScreen);*/
    }

    //function of the subs two numbers
    public void sub(double n1, double n2){

        //check the result if minus then make it positive Integer number
        double value = n1 - n2;
        if(value < 0){
            value = value * -1;
        }

        /*//""trying other approaches""

        //check which number is bigger so the sub can take the right way
        int value;
        if(n2 > n1){
            value = n2 - n1;
        }
        else{
            value = n1 - n2;
        }*/



        goToOutputScreen.putExtra("result", value);
        startActivity(goToOutputScreen);
    }

    //function of the divs two numbers
    public void div(double n1, double n2){
        double value = n1 / n2;

        goToOutputScreen.putExtra("result", value);
        startActivity(goToOutputScreen);
    }
}