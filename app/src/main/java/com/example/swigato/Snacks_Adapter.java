package com.example.swigato;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Snacks_Adapter extends RecyclerView.Adapter<Snacks_Adapter.ViewHolderSnacks>
{

    Context context;
    ArrayList<ListModel> arr;

    public Snacks_Adapter(Context context,ArrayList<ListModel> arr)
    {
        this.context=context;
        this.arr=arr;
    }

    @NonNull
    @Override
    public ViewHolderSnacks onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
         View view = inflater.inflate(R.layout.snacks_model,parent,false);
         return new ViewHolderSnacks(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderSnacks holder, int position)
    {
      holder.txtSnackName.setText(arr.get(position).snack_name);
      holder.txtSnackPrice.setText(arr.get(position).snack_price);
      holder.imgSnack.setImageResource(arr.get(position).snack_image);

        holder.imgPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_value = holder.txtQuantity.getText().toString();
                holder.txtQuantity.setText(String.valueOf(Integer.parseInt(txt_value) + 1));
            }
        });


        holder.imgMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_value = holder.txtQuantity.getText().toString();
                int txtValue=Integer.parseInt(txt_value);
                if ( txtValue> 0) {
                    holder.txtQuantity.setText(String.valueOf(Integer.parseInt(txt_value) - 1));
                }
                else{
                    Toast.makeText(context, "Value should be greater than 0", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return arr.size();
    }

    public class ViewHolderSnacks extends RecyclerView.ViewHolder
{

    ImageView imgSnack;
    TextView txtSnackName;
    TextView txtSnackPrice;

    ImageView imgPlus;
    ImageView imgMinus;

    TextView txtQuantity;
    public ViewHolderSnacks(@NonNull View itemView) {
        super(itemView);
        imgSnack=itemView.findViewById(R.id.imgSnacks);
        txtSnackName=itemView.findViewById(R.id.txtSnackName);
        txtSnackPrice=itemView.findViewById(R.id.txtSnackPrice);
        imgPlus=itemView.findViewById(R.id.imgPlus);
        imgMinus=itemView.findViewById(R.id.imgMinus);
        txtQuantity=itemView.findViewById(R.id.txtQuantity);
        String textValue = txtQuantity.getText().toString();
    }
}

}
