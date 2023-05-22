package com.example.swigato.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swigato.Model.ListModel;
import com.example.swigato.R;

import java.util.ArrayList;

public class Snacks_Adapter extends RecyclerView.Adapter<Snacks_Adapter.ViewHolderSnacks>
{

    Context context;
    ArrayList<ListModel> arr;
    ItemClickListener itemClickListener;
    public Snacks_Adapter(Context context,ArrayList<ListModel> arr,ItemClickListener itemClickListener)
    {
        this.context=context;
        this.arr=arr;
        this.itemClickListener=itemClickListener;
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
      holder.txtQuantityS.setText(arr.get(position).quantity);

        holder.imgPlusS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String txt_value = holder.txtQuantityS.getText().toString();
                holder.txtQuantityS.setText(String.valueOf(Integer.parseInt(txt_value) + 1));
                itemClickListener.addItem(position,String.valueOf(Integer.parseInt(txt_value) + 1));
            }
        });

        holder.imgMinusS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_value = holder.txtQuantityS.getText().toString();
                int txtValue=Integer.parseInt(txt_value);
                if ( txtValue> 0) {
                    holder.txtQuantityS.setText(String.valueOf(Integer.parseInt(txt_value) - 1));
                    itemClickListener.addItem(position,String.valueOf(Integer.parseInt(txt_value) - 1));
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
    ImageView imgPlusS;
    ImageView imgMinusS;
    TextView txtQuantityS;

    public ViewHolderSnacks(@NonNull View itemView) {
        super(itemView);
        imgSnack=itemView.findViewById(R.id.imgSnacks);
        txtSnackName=itemView.findViewById(R.id.txtSnackName);
        txtSnackPrice=itemView.findViewById(R.id.txtSnackPrice);
        imgPlusS=itemView.findViewById(R.id.imgPlusS);
        imgMinusS=itemView.findViewById(R.id.imgMinusS);
        txtQuantityS=itemView.findViewById(R.id.txtQuantityS);
    }
}
    public interface ItemClickListener {
        void addItem(int position,String quantity);
    }
}
