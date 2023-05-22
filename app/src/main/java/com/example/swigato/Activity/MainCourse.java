package com.example.swigato;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainCourse extends AppCompatActivity {
    ArrayList<ListModelMC> obj = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_course);

        RecyclerView recyclerView=findViewById(R.id.recyclerViewMC);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        obj.add(new ListModelMC("350","Dal Makhani",R.drawable.dal_makhani));
        obj.add(new ListModelMC("650","Butter Chicken",R.drawable.butter_chicken));
        obj.add(new ListModelMC("500","Shahi Paneer",R.drawable.shahi_paneer));
        obj.add(new ListModelMC("50","Butter Naan",R.drawable.naan));
        obj.add(new ListModelMC("25","Butter Roti",R.drawable.chapaati));

        MainCourse_Adapter adapter = new MainCourse_Adapter(this,obj);
        recyclerView.setAdapter(adapter);

    }

}