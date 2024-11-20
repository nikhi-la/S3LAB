package com.example.exam;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class display extends AppCompatActivity {

    TextView title,author,category,price;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_display);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        title = findViewById(R.id.title);
        author = findViewById(R.id.author);
        category = findViewById(R.id.category);
        price = findViewById(R.id.price);
        img=findViewById(R.id.img);


        SharedPreferences sp = getSharedPreferences("MyPref",MODE_PRIVATE);
        img.setImageResource(R.drawable.happy);
        if(sp.contains("Title")){
            title.setText("Title : "+sp.getString("Title","").toString());
        }
        if(sp.contains("Author")){
            author.setText("Author : "+sp.getString("Author","").toString());
        }
        if(sp.contains("Category")){
            category.setText("Category : "+sp.getString("Category","").toString());
        }
        if(sp.contains("Price")){
            price.setText("Price : "+sp.getString("Price","").toString());
        }
    }
}