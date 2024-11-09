package com.example.exam;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText email,pass;
    Button login;

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

        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        login = findViewById(R.id.login);
        login.setOnClickListener(this);


    }
    @Override
    public void onClick(View view) {
        if (view.getId() == login.getId()){

           if (email.getText().toString().equals("nikhila@gmail.com") && pass.getText().toString().equals("123456"))
            {
                Toast t = Toast.makeText(this,"",Toast.LENGTH_SHORT);
                LayoutInflater lin = getLayoutInflater();

                View appear = lin.inflate(R.layout.happy_toast,(ViewGroup) findViewById(R.id.ll1));
                t.setGravity(Gravity.TOP,200,200);
                t.setView(appear);
                t.show();
            }
            else{
                Toast t = Toast.makeText(this,"",Toast.LENGTH_SHORT);
                LayoutInflater lin = getLayoutInflater();

                View appear = lin.inflate(R.layout.sad_toast,(ViewGroup) findViewById(R.id.ll2));
               t.setGravity(Gravity.TOP,200,200);
                t.setView(appear);
                t.show();
            }



        }
    }
}