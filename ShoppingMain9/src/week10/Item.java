package week10;

public class Item {
    private String name;
    private int quantity, price;
    public int coupon;
    private double finalCost;

    public Item (String v_name, int v_quantity, int v_price, int v_coupon)
    {
        name=v_name;
        quantity=v_quantity;
        price=v_price;
        coupon=v_coupon;
    }

    public Item (String v_name)
    {
        if (v_name.length() > 10)
        {
            System.out.println("Item name cannot be more than 10 characters !");
        }
         else {
            name = v_name;
            quantity = 0;
            price = 0;
            coupon = 0;
             }
    }

    public Item()

    {   name = "Empty";
        quantity = 0;
        price = 0;
        coupon = 0;}

     public void setName(String v_name) {
         if (v_name.length() > 10) {
             System.out.println("Item name cannot be more than 10 characters !");
         } else {
             name = v_name;
         }
     }

     public String getName()
    { return name;}

    public void  setQuantity(int v_quantity) {
        if (v_quantity <= 0) {
            System.out.println("Item quantity should be more than zero ! ");
        } else {
            quantity = v_quantity;
        }
    }
    public int getQuantity()
        {return quantity;}

        public void setPrice(int v_price)
        {
            if (v_price <= 0) {
                System.out.println("Item price should be more than zero ! ");
            } else { price=v_price;}
        }

        public int getPrice()
        {return price;}


        public void setCoupon(int v_coupon) {
            if (v_coupon < 0 || v_coupon > 100) {
                System.out.println("Item coupon should be between 0 and 100");
            } else {
                coupon = v_coupon;
            }
        }

        public int getCoupon()
        {return coupon;}

        public void setFinalCost(double v_finalCost)
        {finalCost=v_finalCost;}

        public double getFinalCost ()
        {return finalCost;}

    }
