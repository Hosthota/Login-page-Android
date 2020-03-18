package com.example.task3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText userName,password;
    Button btnlogin;
    int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = findViewById(R.id.userName);
        password = findViewById(R.id.password);
        btnlogin = findViewById(R.id.btn);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int counter = 0;
                if (userName.getText().toString().equals("admin") && password.getText().toString().equals("admin"))
                {
                    Toast.makeText(getApplication(), "Login Successfull", Toast.LENGTH_LONG).show();
                    Intent I = new Intent(MainActivity.this, LoginSuccessfull.class);
                    startActivity(I);
                }
                else
                {
                    count++;
                    if (userName.getText().toString().equals("admin") && password.getText().toString().length() == 0)
                        Toast.makeText(getApplicationContext(), "Enter password", Toast.LENGTH_SHORT).show();

                    if (userName.getText().toString().length() == 0 && password.getText().toString().equals("admin"))
                        Toast.makeText(getApplicationContext(), "Enter UserName", Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplication(), "Login UnSuccessfull", Toast.LENGTH_LONG).show();
                    if (count == 3)
                        Toast.makeText(getApplicationContext(),"Retry after 30 seconds",Toast.LENGTH_SHORT).show();
                        countDown();

                }
            }
        });



    }
    public void countDown() {
        new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                btnlogin.setEnabled(false);
            }

            @Override
            public void onFinish() {
                btnlogin.setEnabled(true);
                userName.requestFocus();
            }
        }.start();
    }
}
