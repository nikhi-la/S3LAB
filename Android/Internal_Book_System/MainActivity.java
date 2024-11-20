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

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    EditText title,author;
    Button btn;
    Spinner sp;
    TextView price;
    int[] bprice = {100,200,300,400};
    String category_name[] ={"Novel","Comic","Horror","Crime"};
    String category_selected;

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
        title = findViewById(R.id.title);
        author = findViewById(R.id.author);
        btn = findViewById(R.id.btn);
        sp = findViewById(R.id.category);
        price = findViewById(R.id.price);

        sp.setOnItemSelectedListener(this);
        btn.setOnClickListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        price.setText(String.valueOf(bprice[i]));
        category_selected=category_name[i];
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {
        SharedPreferences sp = getSharedPreferences("MyPref",MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        ed.putString("Title",title.getText().toString());
        ed.putString("Author",author.getText().toString());
        ed.putString("Category",category_selected);
        ed.putString("Price",price.getText().toString());
        ed.apply();

        Intent i = new Intent(this,display.class);
        startActivity(i);

    }
}