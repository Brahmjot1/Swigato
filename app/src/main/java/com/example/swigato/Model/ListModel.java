package com.example.swigato.Model;
public class ListModel
{
    public String snack_price;
    public String snack_name;
    public int snack_image;

    public String quantity;
    public ListModel(String snack_price,String snack_name,int snack_image, String quantity)
    {
        this.snack_image=snack_image;
        this.snack_name=snack_name;
        this.snack_price=snack_price;

        this.quantity=quantity;
    }

    public String getSnack_price() {
        return snack_price;
    }

    public void setSnack_price(String snack_price) {
        this.snack_price = snack_price;
    }

    public String getSnack_name() {
        return snack_name;
    }

    public void setSnack_name(String snack_name) {
        this.snack_name = snack_name;
    }

    public int getSnack_image() {
        return snack_image;
    }

    public void setSnack_image(int snack_image) {
        this.snack_image = snack_image;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
