package com.example.swigato;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Snacks extends AppCompatActivity {

    ArrayList<ListModel> obj = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snacks);

        RecyclerView recyclerView=findViewById(R.id.recyclerViewSnacks);
         recyclerView.setLayoutManager(new LinearLayoutManager(this));

        obj.add(new ListModel("80","Burger",R.drawable.burger));
        obj.add(new ListModel("120","Noodles",R.drawable.noodles));
        obj.add(new ListModel("180","Pizza",R.drawable.pizza));
        obj.add(new ListModel("220","Manchurian",R.drawable.manchurian));



      Snacks_Adapter adapter = new Snacks_Adapter(this,obj);
      recyclerView.setAdapter(adapter);
    }
}