package com.example.program13;

import static java.lang.System.exit;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.MenuCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    LinearLayout l1,l2;
    Spinner sp;
    TextView txt1,res;
    EditText edtxt;
    Button btn;
    String[] userarray={"Muhsina","Nafeesa","Nikhila","Nishal"};
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

        l1 = (LinearLayout) findViewById(R.id.l1);
        l2 = findViewById(R.id.l2);
        sp = findViewById(R.id.sp);
        txt1 = findViewById(R.id.txt1);
        edtxt = findViewById(R.id.edtxt1);
        btn = findViewById(R.id.fact);
        res = findViewById(R.id.res);

        btn.setOnClickListener(this);
        sp.setOnItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.options_menu,menu);
        MenuCompat.setGroupDividerEnabled(menu,true);
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        int id = item.getItemId();
        if (id == R.id.option1) {
            l1.setVisibility(View.VISIBLE);
            l2.setVisibility(View.GONE);

        } else if (id == R.id.option2) {
            l1.setVisibility(View.GONE);
            l2.setVisibility(View.VISIBLE);

        } else if (id == R.id.option3) {
            exit(0);
        }
        return true;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        txt1.setText(userarray[i]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {
        if(view.getId()==btn.getId()){
            int num = Integer.parseInt((edtxt.getText().toString()));
            int fact = 1;
            if(num > 1){
                for (int i= 2;i<=num;++i)
                fact = fact * i;
            }
            res.setText("Factorial : "+String.valueOf(fact));

            }
        }
}
