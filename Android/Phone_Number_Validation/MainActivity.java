package com.example.exam;

import static java.lang.System.exit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.MenuCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText name,phone;
    Button register;

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
        
        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        register = findViewById(R.id.register);
        
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String phone_number = phone.getText().toString();

        if(phone_number.isEmpty() || phone_number.length()!=10 || (!phone_number.startsWith("9") && !phone_number.startsWith("8") && !phone_number.startsWith("7") )){
            Toast.makeText(this, "Enter valid Phone Number", Toast.LENGTH_SHORT).show();
        }
        else{
            String n = name.getText().toString();
            SharedPreferences sp = getSharedPreferences("MyPref",MODE_PRIVATE);

            SharedPreferences.Editor ed = sp.edit();
            ed.putString("Name",n);
            ed.apply();

            Intent i = new Intent(this,homepage.class);
            startActivity(i);
        }
    }
}