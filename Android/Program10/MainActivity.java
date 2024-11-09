package com.example.exam_calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView result;
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,badd,bsub,bmul,bdiv,bclr,beq;
    String input="",operator="";
    int value1,value2;
    String ans;


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

        result = findViewById(R.id.result);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
        b0 = findViewById(R.id.b0);
        badd = findViewById(R.id.badd);
        bsub = findViewById(R.id.bsub);
        bmul = findViewById(R.id.bmul);
        bdiv = findViewById(R.id.bdiv);
        beq = findViewById(R.id.beq);
        bclr = findViewById(R.id.bclr);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b0.setOnClickListener(this);
        badd.setOnClickListener(this);
        bsub.setOnClickListener(this);
        bmul.setOnClickListener(this);
        bdiv.setOnClickListener(this);
        beq.setOnClickListener(this);
        bclr.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id =view.getId();

        if (id == b1.getId() || id == b2.getId() ||id == b3.getId() ||id == b4.getId() ||id == b5.getId() ||id == b6.getId() ||id == b7.getId() ||id == b8.getId() ||id == b9.getId() ||id == b0.getId()){
           input = ((Button)view).getText().toString();
           result.setText(input);
        }
        else if (id == badd.getId() || id == bsub.getId() || id == bmul.getId() || id == bdiv.getId()){
            value1 = Integer.parseInt(input);
            input = "";
            operator = ((Button)view).getText().toString();
        }
        else if(id == beq.getId()){
            value2 = Integer.parseInt(input);

            switch(operator){
                case "+" : ans = String.valueOf(value1+value2);
                            break;
                case "-" : ans = String.valueOf(value1-value2);
                    break;
                case "*" : ans = String.valueOf(value1*value2);
                    break;
                case "/" : ans = String.valueOf(value1/value2);
                    break;
            }
            result.setText(ans);
            input = ans;
        }
        else if(id == bclr.getId()) {
            input="";
            operator="";
            result.setText("");
        }

    }
}