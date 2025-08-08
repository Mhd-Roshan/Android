package com.example.p6;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton; 
import android.widget.RadioGroup;
import android.widget.Toast;
import android.util.Patterns;
import android.text.TextUtils;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etName, etEmail, etPassword;
    RadioButton rbMale, rbFemale;
    RadioGroup genderGroup;
    CheckBox cbTerms;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        rbMale = findViewById(R.id.rbMale);
        rbFemale = findViewById(R.id.rbFemale);
        genderGroup = findViewById(R.id.genderGroup);
        cbTerms = findViewById(R.id.cbTerms);
        btnSubmit = findViewById(R.id.btnSubmit);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateForm();
            }
        });
    }

    private void validateForm() {
        String name = etName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString();


        if (TextUtils.isEmpty(name)) {
            etName.setError("Name is required");
            return;
        }


        if (TextUtils.isEmpty(email) || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Enter a valid email");
            return;
        }


        if (TextUtils.isEmpty(password) || password.length() < 6) {
            etPassword.setError("Password must be at least 6 characters");
            return;
        }


        int selectedGenderId = genderGroup.getCheckedRadioButtonId();
        if (selectedGenderId == -1) {
            Toast.makeText(this, "Select your gender", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!cbTerms.isChecked()) {
            Toast.makeText(this, "Please accept Terms & Conditions", Toast.LENGTH_SHORT).show();
            return;
        }

        RadioButton selectedGender = findViewById(selectedGenderId);
        String gender = selectedGender.getText().toString();

        String message = "Form Submitted!\nName: " + name +
                "\nEmail: " + email +
                "\nGender: " + gender;
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}

