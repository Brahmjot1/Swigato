package com.example.swigato.Model;

public class ListModelDesert
{
        public String D_price;
        public String D_name;
        public int D_image;

        public String quantity;
        public ListModelDesert(String D_price,String D_name,int D_image, String quantity)
        {

            this.D_price=D_price;
            this.D_name=D_name;
            this.D_image=D_image;
            this.quantity=quantity;
        }

    public String getD_price() {
        return D_price;
    }
    public String getD_name() {
        return D_name;
    }

    public int getD_image() {
        return D_image;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}


