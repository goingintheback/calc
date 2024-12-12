package com.example.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonAdd, buttonSubtract, buttonDivide, buttonMultiply, buttonClean, buttonPower;
    private TextView operation, result;
    private EditText number1, number2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonSubtract = (Button) findViewById(R.id.buttonSubtract);
        buttonDivide = (Button) findViewById(R.id.buttonDivide);
        buttonMultiply = (Button) findViewById(R.id.buttonMultiply);
        buttonClean = (Button) findViewById(R.id.buttonClean);
        buttonPower = (Button) findViewById(R.id.buttonPower);

        operation = (TextView) findViewById(R.id.operation);
        result = (TextView) findViewById(R.id.result);

        number1 = (EditText) findViewById(R.id.number1);
        number2 = (EditText) findViewById(R.id.number2);

        buttonAdd.setOnClickListener(this);
        buttonSubtract.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);
        buttonMultiply.setOnClickListener(this);
        buttonClean.setOnClickListener(this);
        buttonPower.setOnClickListener(this);
     }

    @Override
    public void onClick(View v) {
        float num1 = 0;
        float num2 = 0;
        float res = 0;
        try {
            num1 = Float.parseFloat(number1.getText().toString());
            num2 = Float.parseFloat(number2.getText().toString());
        }catch (Exception e) {
            System.out.println("Ошибка");
            return;
        }



        if(v.getId() == R.id.buttonAdd) {
            operation.setText("+");
            res = num1 + num2;
        }else if(v.getId() == R.id.buttonMultiply) {
            operation.setText("*");
            res = num1 * num2;
        }else if(v.getId() == R.id.buttonClean) {
            number1.setText("");
            operation.setText("");
            number2.setText("");
            result.setText("");
        }else if(v.getId() == R.id.buttonDivide) {
            operation.setText("/");
            res = num1 / num2;
        }else if(v.getId() == R.id.buttonSubtract) {
            operation.setText("-");
            res = num1 - num2;
        }else if(v.getId() == R.id.buttonPower) {
            operation.setText("^");
            res = (float) Math.pow(num1, num2);
        }

        result.setText(res + "");
    }

}