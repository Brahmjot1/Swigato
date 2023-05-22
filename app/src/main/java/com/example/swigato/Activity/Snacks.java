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
import com.example.swigato.Model.ListModelDesert;
import com.example.swigato.R;
import com.example.swigato.Adapter.Snacks_Adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Snacks extends AppCompatActivity implements Snacks_Adapter.ItemClickListener {


    static boolean flag=false;
    static ArrayList<ListModel> objArrList;
    static Double sumTotal=0.0;

    Intent intent1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snacks);
        RecyclerView recyclerView=findViewById(R.id.recyclerViewSnacks);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Button btnPayBillSnacks=findViewById(R.id.btnPayBillSnacks);

        if(flag==false)
        {
            resetItems();
        }
      Snacks_Adapter adapter = new Snacks_Adapter(this,objArrList,this);
      recyclerView.setAdapter(adapter);

      sumTotal = findTotal(objArrList);



        intent1 = new Intent(this, BillPayment.class);


        btnPayBillSnacks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                startActivity(intent1);
            }
        });

    }
    @Override
    public void addItem(int position, String quantity) {
        ListModel listModel=objArrList.get(position);
        listModel.setQuantity(quantity);
        objArrList.remove(position);
        objArrList.add(position,listModel);
        sumTotal = findTotal(objArrList);
        intent1.putExtra("snack",sumTotal);
    }


    public void resetItems(){
        Log.e("check", "onCreate: ");
        objArrList=new ArrayList<>(5);

        objArrList.add(new ListModel("80","Burger",R.drawable.burger,"0"));
        objArrList.add(new ListModel("120","Noodles",R.drawable.noodles,"0"));
        objArrList.add(new ListModel("180","Pizza",R.drawable.pizza,"0"));
        objArrList.add(new ListModel("220","Manchurian",R.drawable.manchurian,"0"));

        flag=true;
    }

    public Double findTotal( List<ListModel> list){
        Map<String,ListModel> map = new HashMap<>();
        for (ListModel model: list) {
            if(map.containsKey(model.getSnack_name())){
                ListModel obj = map.get(model.getSnack_name());
                obj.setQuantity(String.valueOf((Double.parseDouble(obj.getQuantity()) + Double.parseDouble(model.getQuantity()))));
                map.put(model.getSnack_name(),obj);
            }
            else
                map.put(model.getSnack_name(),model);
        }

        Double sum = Double.valueOf(0);

        for ( ListModel entry : map.values()) {
            sum += (Double.parseDouble(entry.getQuantity()) * Double.parseDouble(entry.getSnack_price()));
        }
        System.out.println("" + sum);
        return sum;
    }


}


