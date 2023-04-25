package com.example.swigato;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txtSnacks=findViewById(R.id.txtSnacks);
        TextView txtMainCourse=findViewById(R.id.txtMainCourse);
        TextView txtDesert = findViewById(R.id.txtDesert);
        TextView txtPayBill= findViewById(R.id.txtPayBill);
        txtSnacks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,Snacks.class);
                startActivity(intent);

            }
        });

        txtMainCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,MainCourse.class);
                startActivity(intent);

            }
        });

        txtDesert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,Desert.class);
                startActivity(intent);
            }
        });

        txtPayBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent= new Intent(MainActivity.this,BillPayment.class);
                startActivity(intent);
            }
        });





    }
}