package com.example.swigato.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.swigato.Model.ListModel;
import com.example.swigato.Model.ListModelMC;
import com.example.swigato.Adapter.MainCourse_Adapter;
import com.example.swigato.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainCourse extends AppCompatActivity implements MainCourse_Adapter.ItemClickListener {
    static ArrayList<ListModelMC> objArrList;
     static boolean flag=false;

    static Double sumTotal=0.0;

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_course);
        RecyclerView recyclerView = findViewById(R.id.recyclerViewMC);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Button btnPayBillMC=findViewById(R.id.btnPayBillMainCourse);
        if (flag == false) {
            resetItems();
        }
        MainCourse_Adapter adapter = new MainCourse_Adapter(this, objArrList, this);
        recyclerView.setAdapter(adapter);

        sumTotal = findTotal(objArrList);

        intent= new Intent(this, BillPayment.class);

        btnPayBillMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });

    }

    @Override
    public void addItem(int position, String quantity) {
           ListModelMC listModelMC=objArrList.get(position);
           listModelMC.setQuantity(quantity);
           objArrList.remove(position);
           objArrList.add(position,listModelMC);
           sumTotal = findTotal(objArrList);
           intent.putExtra("mc",sumTotal);
    }
    public void resetItems(){
        Log.e("check", "onCreate: ");
        objArrList=new ArrayList<>(5);
        objArrList.add(new ListModelMC("350", "Dal Makhani", R.drawable.dal_makhani,"0"));
        objArrList.add(new ListModelMC("650", "Butter Chicken", R.drawable.butter_chicken, "0"));
        objArrList.add(new ListModelMC("500", "Shahi Paneer", R.drawable.shahi_paneer,"0"));
        objArrList.add(new ListModelMC("50", "Butter Naan", R.drawable.naan, "0"));
        objArrList.add(new ListModelMC("25", "Butter Roti", R.drawable.chapaati, "0"));
        flag=true;
    }

    public Double findTotal( List<ListModelMC> list){
        Map<String,ListModelMC> map = new HashMap<>();
        for (ListModelMC model: list) {
            if(map.containsKey(model.getMC_name())){
                ListModelMC obj = map.get(model.getMC_name());
                obj.setQuantity(String.valueOf((Double.parseDouble(obj.getQuantity()) + Double.parseDouble(model.getQuantity()))));
                map.put(model.getMC_name(),obj);
            }
            else
                map.put(model.getMC_name(),model);
        }

        Double sum = Double.valueOf(0);

        for ( ListModelMC entry : map.values()) {
            sum += (Double.parseDouble(entry.getQuantity()) * Double.parseDouble(entry.getMC_price()));
        }
        System.out.println("" + sum);
        return sum;
    }

}