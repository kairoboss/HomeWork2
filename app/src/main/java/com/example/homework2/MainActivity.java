package com.example.homework2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button addition;
    private EditText num1,num2,num3;
    private TextView amount;
    public static String KEY = "key";
    String saveAmount ;

    private void init(){
        addition = findViewById(R.id.btn_addition);
        num1 = findViewById(R.id.etext1);
        num2 = findViewById(R.id.etext2);
        num3 = findViewById(R.id.etext3);
        amount = findViewById(R.id.amount);
    }
    private void addition(){
        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number1 = Integer.parseInt(num1.getText().toString());
                int number2 = Integer.parseInt(num2.getText().toString());
                int number3 = Integer.parseInt(num3.getText().toString());
                int amountInt = number1 + number2 + number3;
                amount.setText(Integer.toString(amountInt));
                saveAmount = amount.getText().toString();
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        addition();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY,saveAmount);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        saveAmount = savedInstanceState.getString(KEY);
        amount.setText(saveAmount);
    }
}