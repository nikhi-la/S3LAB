package com.example.facebook;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class registration extends AppCompatActivity implements View.OnClickListener {

    EditText name,phn;
    CheckBox sing,dance,draw,read,movie,music;
    Button reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registration);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        name = (EditText) findViewById(R.id.name);
        phn = (EditText) findViewById(R.id.phone);
        sing = (CheckBox) findViewById(R.id.sing);
        dance = (CheckBox) findViewById(R.id.dance);
        draw = (CheckBox) findViewById(R.id.draw);
        read = (CheckBox) findViewById(R.id.read);
        movie = (CheckBox) findViewById(R.id.movie);
        music = (CheckBox) findViewById(R.id.music);

        reg = (Button) findViewById(R.id.regbtn);

        reg.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.regbtn){

            String n = name.getText().toString();
            int p = Integer.parseInt(phn.getText().toString());

            String interest[] = new String[6];

            if(sing.isChecked())
                interest[0]="Singing";
            if(dance.isChecked())
                interest[1]="Dancing";
            if(draw.isChecked())
                interest[2]="Drawing";
            if(read.isChecked())
                interest[3]="Reading";
            if(movie.isChecked())
                interest[4]="Movie";
            if(music.isChecked())
                interest[5]="Music";

            SharedPreferences sp = getSharedPreferences("MyPref",MODE_PRIVATE);

            SharedPreferences.Editor ed = sp.edit();
            ed.putString("Name",n);
            ed.putString("Phone",String.valueOf(p));
            Set<String> interestSet = new HashSet<>(Arrays.asList(interest));
            ed.putStringSet("Interest", interestSet);

            ed.apply();

            Intent i2  = new Intent(this,details.class);
            startActivity(i2);

        }
    }
}