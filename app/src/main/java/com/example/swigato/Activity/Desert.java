package com.example.swigato.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.swigato.Adapter.Desert_Adapter;
import com.example.swigato.Adapter.MainCourse_Adapter;
import com.example.swigato.Model.ListModel;
import com.example.swigato.Model.ListModelDesert;
import com.example.swigato.Model.ListModelMC;
import com.example.swigato.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Desert extends AppCompatActivity implements Desert_Adapter.ItemClickListener{

    static boolean flag=false;
    static ArrayList<ListModelDesert> objArrList;
    static Double sumTotalD=0.0;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desert);

        RecyclerView recyclerView=findViewById(R.id.recyclerViewD);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Button btnPayBillDesert=findViewById(R.id.btnPayBillDesert);

        if(flag==false) {
            resetItems();
        }

        Desert_Adapter adapter = new Desert_Adapter(this,objArrList,this);
        recyclerView.setAdapter(adapter);

        sumTotalD = findTotal(objArrList);



    intent = new Intent(this, BillPayment.class);


        btnPayBillDesert.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view)
        {
            startActivity(intent);
        }
    });

}

    @Override
    public void addItem(int position, String quantity) {
        ListModelDesert listModelDesert=objArrList.get(position);
        listModelDesert.setQuantity(quantity);
        objArrList.remove(position);
        objArrList.add(position,listModelDesert);
        sumTotalD = findTotal(objArrList);
        intent.putExtra("desert",sumTotalD);
    }
    public void resetItems(){
        Log.e("check", "onCreate: ");
        objArrList=new ArrayList<>(5);

        objArrList.add(new ListModelDesert("30","Gulab Jaamun",R.drawable.gulab_jamun,"0"));
        objArrList.add(new ListModelDesert("60","Rabri",R.drawable.rabri,"0"));
        objArrList.add(new ListModelDesert("40","Kaju Katli",R.drawable.kaju_katli,"0"));

        flag=true;
    }

    public Double findTotal( List<ListModelDesert> list){
        Map<String,ListModelDesert> map = new HashMap<>();
        for (ListModelDesert model: list) {
            if(map.containsKey(model.getD_name())){
                ListModelDesert obj = map.get(model.getD_name());
                obj.setQuantity(String.valueOf((Double.parseDouble(obj.getQuantity()) + Double.parseDouble(model.getQuantity()))));
                map.put(model.getD_name(),obj);
            }
            else
                map.put(model.getD_name(),model);
        }

        Double sum = Double.valueOf(0);

        for ( ListModelDesert entry : map.values()) {
            sum += (Double.parseDouble(entry.getQuantity()) * Double.parseDouble(entry.getD_price()));
        }
        System.out.println("" + sum);
        return sum;
    }

}



