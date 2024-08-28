package com.example.facebook;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements TextWatcher, View.OnClickListener, CompoundButton.OnCheckedChangeListener {

        LinearLayout ll1;
        TextView txt1;
        Button b;
        EditText percentage;
        CheckBox chck;
        ToggleButton tgle;

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

        ll1 = (LinearLayout)findViewById(R.id.main);
        txt1 = (TextView)findViewById(R.id.p);
        percentage = (EditText)findViewById(R.id.percentage);
        chck = (CheckBox) findViewById(R.id.chck);
        tgle = (ToggleButton)findViewById(R.id.tgle);

        percentage.addTextChangedListener(this);
        chck.setOnClickListener(this);
        tgle.setOnCheckedChangeListener(this);
   }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    @Override
    public void afterTextChanged(Editable editable) {
        Toast.makeText(this,"Percentage Changed",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        if(chck.isChecked()){
            Toast.makeText(this,"Terms and Conditions Accepted",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"Accept Terms and Conditions",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if(b){
            ll1.setBackgroundColor(Color.DKGRAY);
            chck.setTextColor(Color.WHITE);
            txt1.setTextColor(Color.WHITE);
            percentage.setTextColor(Color.WHITE);

        }
        else{
            ll1.setBackgroundColor(Color.WHITE);
            chck.setTextColor(Color.BLACK);
            txt1.setTextColor(Color.BLACK);
            percentage.setTextColor(Color.BLACK);
        }
    }
}