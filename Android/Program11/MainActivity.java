package com.example.facebook;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView l;
    ImageView img;
    TextView txt;

    String[] fruits = {"Apple","Orange","Grapes","Strawberry","Blueberry","Kiwi"};
    int[] fruitsimg = {R.drawable.apple,R.drawable.orange,R.drawable.grapes,R.drawable.strawberry,R.drawable.blueberry,R.drawable.kiwi};

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

        l = (ListView) findViewById(R.id.list);
        txt = (TextView)findViewById(R.id.name);
        img = (ImageView) findViewById(R.id.img);


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,fruits);
        l.setAdapter(adapter);
        l.setOnItemClickListener(this);
        }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            txt.setText(fruits[i]);
            img.setImageResource(fruitsimg[i]);
    }
}
