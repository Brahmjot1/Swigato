package com.example.swigato.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.example.swigato.R;

import java.util.List;
public class BillPayment extends AppCompatActivity {
    Button btnPayBill;
    TextView snackBillAmount;
    TextView desertBillAmount;
    TextView mainCourseBillAmount;
    static boolean snackBool=true;
    static boolean  mcBool=true;
    static boolean  desertBool=true;
    static double snack;
    static double desert;
    static double mc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_payment);

        btnPayBill=findViewById(R.id.btnPayBill);
        snackBillAmount=findViewById(R.id.SnackBillAmount);
        desertBillAmount=findViewById(R.id.DesertBillAmount);
        mainCourseBillAmount=findViewById(R.id.MainCourseBillAmount);

        btnPayBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BillPayment.this, "Payment Successfull", Toast.LENGTH_SHORT).show();
            }
        });

        if (snackBool==true) {
            Intent fromSnacks = getIntent();
            snack = fromSnacks.getDoubleExtra("snack", 0.0);
            System.out.println(snack);
            snackBool=false;
//            snackBillAmount.setText(String.valueOf(snack));
        }




        if (mcBool==true) {
            Intent fromMain = getIntent();
            mc = fromMain.getDoubleExtra("mc", 0.0);
            System.out.println(mc);
            mcBool=false;
//            mainCourseBillAmount.setText(String.valueOf(mc));
        }

        if(desertBool==true) {
            Intent fromDesert = getIntent();
            desert = fromDesert.getDoubleExtra("desert", 0.0);
            System.out.println(desert);
            snackBool=false;
//            desertBillAmount.setText(String.valueOf(desert));
        }








      String bill=String.valueOf(snack);
        String bill2=String.valueOf(mc);
        String bill3=String.valueOf(desert);
        SharedPreferences sharedPreferences = getSharedPreferences("final_bill",MODE_PRIVATE);
        SharedPreferences.Editor editor1 = sharedPreferences.edit();
        SharedPreferences.Editor editor2 = sharedPreferences.edit();
        SharedPreferences.Editor editor3 = sharedPreferences.edit();

        editor1.putString("str_snack",bill);
        editor1.apply();
        snackBillAmount.setText(bill);

        editor2.putString("str_desert",bill3);
        editor2.apply();
        desertBillAmount.setText(bill3);

        editor3.putString("str_mc",bill2);
        editor3.apply();
        mainCourseBillAmount.setText(bill2);




        SharedPreferences getShared = getSharedPreferences("final_bill",MODE_PRIVATE);
        String value= getShared.getString("str_snack","N/A");
        String value2= getShared.getString("str_mc","N/A");
        String value3= getShared.getString("str_desert","N/A");

        snackBillAmount.setText(value);
        mainCourseBillAmount.setText(value2);
        desertBillAmount.setText(value3);





    }
}