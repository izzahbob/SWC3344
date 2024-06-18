/**
 * Description : write a program to manage the data of customer orders in an e-commerce platform.
 *
 * Programmer : Ezzah
 * Date : 11 June 2024
 */

//import package
import java.util.*;
import java.io.*;
import javax.swing.*;

public class OrderManagement
{
    public static void main (String[] args)
    {
        try
        {
            //create a file reader to read the input file
            BufferedReader in = new BufferedReader(new FileReader("Order.txt"));

            //create arraylist
            ArrayList<Order> orderList = new ArrayList<>();

            //declare and create object
            Order ord;

            //declare indata to read a line in input file
            String inData = null;

            while ((inData = in.readLine()) !=null)
            {
                StringTokenizer st = new StringTokenizer(inData, "|");
                String orderID = st.nextToken();
                String name = st.nextToken();
                String address = st.nextToken();
                String productName = st.nextToken();
                int quantity = Integer.parseInt(st.nextToken());
                double price = Double.parseDouble(st.nextToken());
                double totalPrice = Double.parseDouble(st.nextToken());
                String status = st.nextToken();

                //assign token to the object
                ord = new Order(orderID, name, address, productName, quantity, price, totalPrice, status);

                //add object into arraylist
                orderList.add(ord);

            }
            in.close();

            int menu = 0;
            String input;
            do
            {
                System.out.println("\nMenu:");
                System.out.println("1. Add a new order");
                System.out.println("2. Update an order");
                System.out.println("3. Delete an order");
                System.out.println("4. Display orders");
                System.out.println("5. Exit");

                //ask user to enter menu
                input = JOptionPane.showInputDialog("Enter menu");
                menu = Integer.parseInt (input);

                if(menu == 1)
                {
                    // Ask user to enter the serial number that they want to add
                    input = JOptionPane.showInputDialog("Enter order ID");
                    String orderID = input;

                    boolean exists = false;
                    for (Order order : orderList) {
                        if (order.getOrderID().equals(orderID)) 
                        {
                            System.out.println("Order ID already exists");
                            exists = true;
                            break;
                        }
                    }

                    if (!exists) 
                    {
                        input = JOptionPane.showInputDialog("Enter your name");
                        String name = input; // name
                        input = JOptionPane.showInputDialog("Enter address");
                        String address = input; // address
                        input = JOptionPane.showInputDialog("Enter product name");
                        String productName = input; // productName
                        input = JOptionPane.showInputDialog("Enter Quantity");
                        int quantity = Integer.parseInt(input); // string to int

                        input = JOptionPane.showInputDialog("Enter Price");
                        double price = Double.parseDouble(input); // string to double

                        input = JOptionPane.showInputDialog("Enter total price");
                        double totalPrice = Double.parseDouble(input); // string to double

                        input = JOptionPane.showInputDialog("Enter status");
                        String status = input; // status

                        // Assign token to the object
                        ord = new Order(orderID, name, address, productName, quantity, price, totalPrice, status);

                        // Add object into ArrayList
                        orderList.add(ord);
                        System.out.println("Order added successfully");

                    }

                }
                else if (menu == 2)
                {
                    //ask user to enter the serial number that they want to edit
                    input = JOptionPane.showInputDialog("Enter order ID");
                    String orderID = input;

                    for (int n=0; n<orderList.size(); n++)
                    {
                        ord = orderList.get(n);

                        if(ord.getOrderID().equalsIgnoreCase(orderID))
                        {
                            String name = JOptionPane.showInputDialog("Enter new name (" + ord.getName() + "):");
                            if(!name.isEmpty()){
                                ord.setName(name);
                            }

                            String address = JOptionPane.showInputDialog("Enter new address (" + ord.getAddress() + "):");
                            if(!address.isEmpty()){
                                ord.setAddress(address);
                            }

                            String productName = JOptionPane.showInputDialog("Enter new product name (" + ord.getProductName() + "):");
                            if(!productName.isEmpty()){
                                ord.setProductName(productName);
                            }

                            String iQuantity = JOptionPane.showInputDialog("Enter new quantity (" + ord.getQuantity() + "):");
                            if(!iQuantity.isEmpty()){
                                int quantity = Integer.parseInt(iQuantity);
                                ord.setQuantity(quantity);
                            }

                            String dPrice = JOptionPane.showInputDialog("Enter new price (" + ord.getPrice() + "):");
                            if(!dPrice.isEmpty()){
                                double price = Double.parseDouble(dPrice);
                                ord.setPrice(price);
                            }

                            String dTotal = JOptionPane.showInputDialog("Enter new total price (" + ord.getTotalPrice() + "):");
                            if(!dTotal.isEmpty()){
                                double totalPrice = Double.parseDouble(dTotal);
                                ord.setTotalPrice(totalPrice);
                            }

                            String status = JOptionPane.showInputDialog("Enter new status (" + ord.getStatus() + "):");
                            if(!status.isEmpty()){
                                ord.setStatus(name);
                            }

                            //update order in the array
                            orderList.set(n, ord);
                            JOptionPane.showMessageDialog(null, "Order updated successfully");
                            return;
                        }
                        JOptionPane.showMessageDialog(null, "Order ID not found");
                    }

                }
                else if (menu == 3)
                {
                    //ask user to enter the serial number that they want to remove
                    input = JOptionPane.showInputDialog("Enter order ID");
                    String orderID = input;

                    for(int n=0; n<orderList.size(); n++)
                    {
                        ord = orderList.get(n);

                        if(ord.getOrderID().equalsIgnoreCase(orderID))
                        {
                            orderList.remove(n);
                            JOptionPane.showMessageDialog(null, "Order deleted successfully");
                            return;
                        }
                    }

                }
                else if (menu == 4)
                {
                    String[] options = {"Display all orders", "Display orders by name", "Display orders by product", "Display orders by status"};
                    int choice = JOptionPane.showOptionDialog(null, "Choose an option:", "Display Orders", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

                    switch (choice)
                    {
                        case 0: //display all orders
                            displayOrders(orderList, null, null, null);
                            break;

                        case 1: // Display orders by name
                            String name = JOptionPane.showInputDialog("Enter name");
                            displayOrders(orderList, name, null, null);
                            break;

                        case 2: // Display orders by product
                            String productName = JOptionPane.showInputDialog("Enter product name");
                            displayOrders(orderList, null, productName, null);
                            break;

                        case 3: // Display orders by status
                            String status = JOptionPane.showInputDialog("Enter status");
                            displayOrders(orderList, null, null, status);
                            break;

                        default:
                            JOptionPane.showMessageDialog(null, "Invalid option");
                            break;
                    }
                }

            } while (menu!=5);
        }catch (FileNotFoundException fnfe)
        {
            System.out.println("File not found");
        }
        catch (IOException ioe)
        {
            System.out.println(ioe.getMessage());
        }
    }

    private static void displayOrders(List<Order> orderList, String name, String productName, String status) {
        StringBuilder message = new StringBuilder();
        for (Order order : orderList) {
            boolean match = true;
            if (name != null && !order.getName().equalsIgnoreCase(name)) {
                match = false;
            }
            if (productName != null && !order.getProductName().equalsIgnoreCase(productName)) {
                match = false;
            }
            if (status != null && !order.getStatus().equalsIgnoreCase(status)) {
                match = false;
            }
            if (match) {
                message.append(order.toString()).append("\n************************\n");
            }
        }
        JTextArea textArea = new JTextArea(message.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new java.awt.Dimension(500, 400));
        JOptionPane.showMessageDialog(null, scrollPane, "Order List", JOptionPane.INFORMATION_MESSAGE);
    
    }
}
