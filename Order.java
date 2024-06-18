
/**
 * Description : write a program to manage the data of customer orders in an e-commerce platform.
 *
 * Programmer : Ezzah
 * Date : 10 June 2024
 */

//class definition
public class Order
{
    //declaration of attributes
    private String orderID;
    private String name;
    private String address;
    private String productName;
    private int quantity;
    private double price;
    private double totalPrice;
    private String status;
    
    //constructor w/o param
    public Order()
    {
        orderID = null;
        name = "";
        address = "";
        productName = "";
        quantity = 0;
        price = 0.0;
        totalPrice = 0.0;
        status = "";
    }
    //constructor w/ param
    public Order(String id, String nm, String adds, String pnm, int q, double p, double tp, String st)
    {
        orderID = id;
        name = nm;
        address = adds;
        productName = pnm;
        quantity = q;
        price = p;
        totalPrice = tp;
        status = st;
    }
    
    //mutator for each attributes
    public void setOrderID (String id)
    {
        orderID = id;
    }
    public void setName (String nm)
    {
        name = nm;
    }
    public void setAddress (String adds)
    {
        address = adds;
    }
    public void setProductName (String pnm)
    {
        productName = pnm;
    }
    public void setQuantity (int q)
    {
        quantity = q;
    }
    public void setPrice (double p)
    {
        price = p;
    }
    public void setTotalPrice (double tp)
    {
        totalPrice = tp;
    }
    public void setStatus (String st)
    {
        status = st;
    }
    //mutator for all attributes
    public void setAll (String id, String nm, String adds, String pnm, int q, double p, double tp, String st)
    {
        orderID = id;
        name = nm;
        address = adds;
        productName = pnm;
        quantity = q;
        price = p;
        totalPrice = tp;
        status = st;
    }
    
    //accessor / getter method
    public String getOrderID ()
    {
        return orderID;
    }
    public String getName ()
    {
        return name;
    }
    public String getAddress ()
    {
        return address;
    }
    public String getProductName ()
    {
        return productName;
    }
    public int getQuantity ()
    {
        return quantity;
    }
    public double getPrice ()
    {
        return price;
    }
    public double getTotalPrice ()
    {
        return totalPrice;
    }
    public String getStatus ()
    {
        return status;
    }
    
    //display input
    public String toString ()
    {
        return ("Order ID : " + orderID + "\n" + "Name : " + name + "\n" + "Address : " + address + "\n" +
                "Product Name : " + productName + "\n" + "Quantity : " + quantity + "\n" + "Price : " + price + "\n" +
                "Total Price : " + totalPrice + "\n" + "Status : " + status + "\n");
    }
}
