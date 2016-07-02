package com.dothejob.dothe.calculator;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button zeroBtn, oneBtn, towBtn, threBtn, foreBtn, fiveBtn, sixBtn, svenBtn, eightBtn, nienBtn, clearBtn, tempBtn;
    ImageButton diviedBtn, multiBut, subBtn, addBtn, calckBtn, imgTempBtn;
    TextView clackText;
    String tempText = "", operator = "" , operator2 = "";
    double leftNum = 0, rightNum = 0, runningNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Buttons 0 for 9 and CLEAR
        //and set the View.OnClickListener for them
        zeroBtn = (Button) findViewById(R.id.zeroBtn);
        zeroBtn.setOnClickListener(this);
        oneBtn = (Button) findViewById(R.id.oneBtn);
        oneBtn.setOnClickListener(this);
        towBtn = (Button) findViewById(R.id.towBtn);
        towBtn.setOnClickListener(this);
        threBtn = (Button) findViewById(R.id.threBtn);
        threBtn.setOnClickListener(this);
        foreBtn = (Button) findViewById(R.id.foreBtn);
        foreBtn.setOnClickListener(this);
        fiveBtn = (Button) findViewById(R.id.fiveBtn);
        fiveBtn.setOnClickListener(this);
        sixBtn = (Button) findViewById(R.id.sixBtn);
        sixBtn.setOnClickListener(this);
        svenBtn = (Button) findViewById(R.id.svenBtn);
        svenBtn.setOnClickListener(this);
        eightBtn = (Button) findViewById(R.id.eightBtn);
        eightBtn.setOnClickListener(this);
        nienBtn = (Button) findViewById(R.id.nienBtn);
        nienBtn.setOnClickListener(this);
        clearBtn = (Button) findViewById(R.id.clearBtn);
        clearBtn.setOnClickListener(this);

        //ImageButton for = + - * /
        //and set the View.OnClickListener for them
        diviedBtn = (ImageButton) findViewById(R.id.diviedBtn);
        diviedBtn.setOnClickListener(this);
        multiBut = (ImageButton) findViewById(R.id.multiBut);
        multiBut.setOnClickListener(this);
        subBtn = (ImageButton) findViewById(R.id.subBtn);
        subBtn.setOnClickListener(this);
        addBtn = (ImageButton) findViewById(R.id.addBtn);
        addBtn.setOnClickListener(this);
        calckBtn = (ImageButton) findViewById(R.id.calckBtn);
        calckBtn.setOnClickListener(this);

        //TextView for Resault
        clackText = (TextView) findViewById(R.id.calckText);
    }

    @Override
    public void onClick(View view) {


        if (view instanceof Button) {
            tempBtn = (Button) view;

            if (!tempBtn.getText().equals("Clear")) {
                tempText += tempBtn.getText();
                clackText.setText(tempText);
                runningNum = Double.parseDouble(tempText);
            }

        }

        if (view instanceof ImageButton) {
            imgTempBtn = (ImageButton) view;

            if(view == diviedBtn){
                operator = "/";
            }else if (view == multiBut){
                operator = "*";
            }else if (view == subBtn){
                operator = "-";
            }else if (view == addBtn){
                operator = "+";
            }



            if(! operator2.equals("")){
                if (operator2.equals("+")){
                    rightNum = runningNum;
                    runningNum = 0;
                    tempText = "";
                    doCalc("+");
                }
            }else {
                leftNum = runningNum;
                runningNum = 0;
                tempText = "";
            }

            operator2 = operator;

        }


    }

    public void doCalc(String op){

        switch (op){
            case "+":
                String temp = String.valueOf(leftNum + rightNum);
                leftNum += rightNum;
                clackText.setText(temp);
        }
    }

}
