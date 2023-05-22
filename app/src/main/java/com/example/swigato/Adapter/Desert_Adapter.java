package com.example.swigato.Adapter;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swigato.Activity.Desert;
import com.example.swigato.Model.ListModelDesert;
import com.example.swigato.R;

import java.util.ArrayList;

public class Desert_Adapter extends RecyclerView.Adapter<Desert_Adapter.DViewHolder>
{

    Context context;
    ArrayList<ListModelDesert> arr;
    ItemClickListener itemClickListener;

    public  Desert_Adapter(Context context, ArrayList<ListModelDesert> arr, ItemClickListener itemClickListener)
    {
        this.context=context;
        this.arr=arr;
        this.itemClickListener=itemClickListener;
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
        holder.txtDName.setText(arr.get(position).getD_name());
        holder.txtDPrice.setText(arr.get(position).getD_price());
        holder.imgD.setImageResource(arr.get(position).getD_image());
        holder.txtQuantityD.setText(arr.get(position).getQuantity());

        holder.imgPlusD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String txt_value = holder.txtQuantityD.getText().toString();
                holder.txtQuantityD.setText(String.valueOf(Integer.parseInt(txt_value) + 1));
                itemClickListener.addItem(position,String.valueOf(Integer.parseInt(txt_value) + 1));
            }
        });


        holder.imgMinusD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_value = holder.txtQuantityD.getText().toString();
                int txtValue=Integer.parseInt(txt_value);
                if ( txtValue> 0) {
                    holder.txtQuantityD.setText(String.valueOf(Integer.parseInt(txt_value) - 1));
                    itemClickListener.addItem(position,String.valueOf(Integer.parseInt(txt_value) - 1));
                }
                else{
                    Toast.makeText(context, "Value should be greater than 0", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public int getItemCount() {return arr.size();}


    public static class DViewHolder extends RecyclerView.ViewHolder{
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

        }
    }
    public interface ItemClickListener{
        void addItem(int position,String quantity);
    }
}



