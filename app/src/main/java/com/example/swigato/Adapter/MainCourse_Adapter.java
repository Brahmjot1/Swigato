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

import com.example.swigato.Model.ListModelMC;
import com.example.swigato.R;

import java.util.ArrayList;


public class MainCourse_Adapter extends RecyclerView.Adapter<MainCourse_Adapter.MainCourseViewHolder>
{
    Context context;
    ArrayList<ListModelMC> arr;
    ItemClickListener itemClickListener;
    public MainCourse_Adapter(Context context,ArrayList<ListModelMC> arr,ItemClickListener itemClickListener)
    {
        this.context=context;
        this.arr=arr;
        this.itemClickListener=itemClickListener;
    }
    @NonNull
    @Override
    public MainCourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.main_course_model,parent,false);
        return new MainCourse_Adapter.MainCourseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainCourseViewHolder holder, int position) {
        holder.txtMCName.setText(arr.get(position).getMC_name());
        holder.txtMCPrice.setText(arr.get(position).getMC_price());
        holder.imgMC.setImageResource(arr.get(position).getMC_image());
        holder.txtQuantityMC.setText(arr.get(position).getQuantity());
        holder.imgPlusMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_value = holder.txtQuantityMC.getText().toString();
                holder.txtQuantityMC.setText(String.valueOf(Integer.parseInt(txt_value) + 1));
                itemClickListener.addItem(position,String.valueOf(Integer.parseInt(txt_value) + 1));
            }
        });


            holder.imgMinusMC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String txt_value = holder.txtQuantityMC.getText().toString();
                    int txtValue=Integer.parseInt(txt_value);
                    if ( txtValue>0) {
                        holder.txtQuantityMC.setText(String.valueOf(Integer.parseInt(txt_value) - 1));
                        itemClickListener.addItem(position,String.valueOf(Integer.parseInt(txt_value) - 1));
                    }
                    else{
                        Toast.makeText(context, "Value should be greater than 0", Toast.LENGTH_SHORT).show();
                    }
                }
            });




    }

    @Override
    public int getItemCount()
    {
        return arr.size();
    }

    public class MainCourseViewHolder extends RecyclerView.ViewHolder{

        ImageView imgMC;
        TextView txtMCName;
        TextView txtMCPrice;

        ImageView imgPlusMC;
        ImageView imgMinusMC;

        TextView txtQuantityMC;
       public MainCourseViewHolder(@NonNull View itemView) {
           super(itemView);

           imgMC=itemView.findViewById(R.id.imgMainCourse);
           txtMCName=itemView.findViewById(R.id.txtMainCourseName);
           txtMCPrice=itemView.findViewById(R.id.txtMainCoursePrice);
           imgPlusMC=itemView.findViewById(R.id.imgPlusMC);
           imgMinusMC=itemView.findViewById(R.id.imgMinusMC);
           txtQuantityMC=itemView.findViewById(R.id.txtQuantityMC);
       }
   }
    public interface ItemClickListener {
        void addItem(int position,String quantity);
    }
}
