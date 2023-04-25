package com.example.swigato;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Desert extends AppCompatActivity {

    ArrayList<ListModelDesert> obj = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desert);

        RecyclerView recyclerView=findViewById(R.id.recyclerViewD);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        obj.add(new ListModelDesert("30","Gulab Jaamun",R.drawable.gulab_jamun));
        obj.add(new ListModelDesert("60","Rabri",R.drawable.rabri));
        obj.add(new ListModelDesert("40","Kaju Katli",R.drawable.kaju_katli));



        Desert_Adapter adapter = new Desert_Adapter(this,obj);
        recyclerView.setAdapter(adapter);
    }
}