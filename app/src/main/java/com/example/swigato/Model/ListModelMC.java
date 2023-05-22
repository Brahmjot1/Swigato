package com.example.swigato.Model;

public class ListModelMC
{
   public String MC_price;
    public String MC_name;
    public  int MC_image;
    public String quantity;

    public ListModelMC(String MC_price, String MC_name, int MC_image, String quantity) {
        this.MC_price = MC_price;
        this.MC_name = MC_name;
        this.MC_image = MC_image;
        this.quantity = quantity;
    }

    public String getMC_price() {
        return MC_price;
    }

    public void setMC_price(String MC_price) {
        this.MC_price = MC_price;
    }

    public String getMC_name() {
        return MC_name;
    }

    public void setMC_name(String MC_name) {
        this.MC_name = MC_name;
    }

    public int getMC_image() {
        return MC_image;
    }


    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
