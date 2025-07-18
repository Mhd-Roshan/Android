package com.example.p2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Button btn=findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String gender;

                EditText n=findViewById(R.id.editTextText6);
                EditText p=findViewById(R.id.editTextTextPassword2);
                EditText a=findViewById(R.id.editTextText8);
                EditText ag=findViewById(R.id.editTextNumber2);
                RadioButton r=findViewById(R.id.radioButton);
                RadioButton r2=findViewById(R.id.radioButton2);
                RadioButton r3=findViewById(R.id.radioButton3);
                TextView tx=findViewById(R.id.textView2);
                String name=n.getText().toString();
                String age=ag.getText().toString();
                String password=p.getText().toString();
                String address=a.getText().toString();
                if(r.isChecked())
                    gender=r.getText().toString();
                else if (r2.isChecked()) {
                    gender=r2.getText().toString();
                }
                else {
                    gender=r3.getText().toString();
                }
                String message="Name :"+name+"\npassword :"+password+"\nage :"+age+"\naddress :"+address+"\ngender :"+gender;
                tx.setText(message);
            }
        });

    }
}
