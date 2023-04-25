package com.example.swigato;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Desert_Adapter extends RecyclerView.Adapter<Desert_Adapter.DViewHolder>
{

    Context context;
    ArrayList<ListModelDesert> arr;

    public  Desert_Adapter(Context context,ArrayList<ListModelDesert> arr)
    {
        this.context=context;
        this.arr=arr;
    }
    @NonNull
    @Override
    public DViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.desert_model,parent,false);
        return new Desert_Adapter.DViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DViewHolder holder, int position)
    {
        holder.txtDName.setText(arr.get(position).D_name);
        holder.txtDPrice.setText(arr.get(position).D_price);
        holder.imgD.setImageResource(arr.get(position).D_image);

        holder.imgPlusD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_value = holder.txtQuantityD.getText().toString();
                holder.txtQuantityD.setText(String.valueOf(Integer.parseInt(txt_value) + 1));
            }
        });


        holder.imgMinusD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_value = holder.txtQuantityD.getText().toString();
                int txtValue=Integer.parseInt(txt_value);
                if ( txtValue> 0) {
                    holder.txtQuantityD.setText(String.valueOf(Integer.parseInt(txt_value) - 1));
                }
                else{
                    Toast.makeText(context, "Value should be greater than 0", Toast.LENGTH_SHORT).show();
                }
            }
        });

//        int totalBillD=Integer.parseInt((String) holder.txtQuantityD.getText()) * Integer.parseInt((String) holder.txtDPrice.getText());
//        System.out.println(totalBillD);

    }

    @Override
    public int getItemCount()
    {
        return arr.size();
    }

    public class DViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imgD;
        TextView txtDName;
        TextView txtDPrice;

        ImageView imgPlusD;
        ImageView imgMinusD;

        TextView txtQuantityD;

        public DViewHolder(@NonNull View itemView) {
            super(itemView);

            imgD=itemView.findViewById(R.id.imgDesert);
            txtDName=itemView.findViewById(R.id.txtDesertName);
            txtDPrice=itemView.findViewById(R.id.txtDesertPrice);
            imgPlusD=itemView.findViewById(R.id.imgPlusD);
            imgMinusD=itemView.findViewById(R.id.imgMinusD);
            txtQuantityD=itemView.findViewById(R.id.txtQuantityD);
            String textValue = txtQuantityD.getText().toString();
        }
    }
}
