package com.example.swigato.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.swigato.Adapter.Desert_Adapter;
import com.example.swigato.Adapter.MainCourse_Adapter;
import com.example.swigato.Model.ListModelDesert;
import com.example.swigato.Model.ListModelMC;
import com.example.swigato.R;

import java.util.ArrayList;

public class Desert extends AppCompatActivity  {

    static boolean flag=false;
    ArrayList<ListModelDesert> objArrList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desert);

        RecyclerView recyclerView=findViewById(R.id.recyclerViewD);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        if(flag==false) {
            resetItems();
        }

        Desert_Adapter adapter = new Desert_Adapter(this,objArrList,this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void addItem(int position, String quantity) {
        ListModelMC listModelMC=objArrList.get(position);
        listModelMC.setQuantity(quantity);
        objArrList.remove(position);
        objArrList.add(position,listModelMC);
    }
    public void resetItems(){
        Log.e("check", "onCreate: ");
        objArrList=new ArrayList<>(5);

        objArrList.add(new ListModelDesert("30","Gulab Jaamun",R.drawable.gulab_jamun,"0"));
        objArrList.add(new ListModelDesert("60","Rabri",R.drawable.rabri,"0"));
        objArrList.add(new ListModelDesert("40","Kaju Katli",R.drawable.kaju_katli,"0"));

        flag=true;
    }

}



