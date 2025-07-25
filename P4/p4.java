package com.example.p4;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity { 
    EditText num1, num2;
    TextView tvResult;
    Button btnAdd, btnSubtract, btnMultiply, btnDivide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        tvResult = findViewById(R.id.tvResult);
        btnAdd = findViewById(R.id.btnAdd);
        btnSubtract = findViewById(R.id.btnSubtract);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);

        btnAdd.setOnClickListener(v -> calculate('+'));
        btnSubtract.setOnClickListener(v -> calculate('-'));
        btnMultiply.setOnClickListener(v -> calculate('*'));
        btnDivide.setOnClickListener(v -> calculate('/'));
    }

    private void calculate(char operator) {
        try {
            double number1 = Double.parseDouble(num1.getText().toString());
            double number2 = Double.parseDouble(num2.getText().toString());
            double result = 0;

            switch (operator) {
                case '+': result = number1 + number2; break;
                case '-': result = number1 - number2; break;
                case '*': result = number1 * number2; break;
                case '/': result = number2 != 0 ? number1 / number2 : 0; break;
            }

            tvResult.setText("Result: " + result);
        } catch (NumberFormatException e) {
            tvResult.setText("Please enter valid numbers");
        }
    }
}

