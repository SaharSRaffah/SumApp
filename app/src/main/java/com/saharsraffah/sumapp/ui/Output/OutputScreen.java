package com.saharsraffah.sumapp.ui.Output;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.saharsraffah.sumapp.R;

public class OutputScreen extends AppCompatActivity {

    //initiate UI variables
    TextView value_txt;
    Button back_btn;
    Intent getValue;
    //int result = 0;
    double result;
    ImageView imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output_screen);

        //initial views
        initViews();

        //make the image when clicked back to the previous screen
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        //get the result from the previous screen and display it here
        getValue = getIntent();
        result = getValue.getDoubleExtra("result", 0);
        value_txt.setText(result+"");
    }

    public void initViews(){
        value_txt = findViewById(R.id.txt_value);
        back_btn = findViewById(R.id.btn_back);
        imgBack = findViewById(R.id.backIcon);
    }
}