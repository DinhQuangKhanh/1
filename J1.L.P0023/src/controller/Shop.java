/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Hashtable;
import model.Fruit;
import model.Order;
import model.Validation;

/**
 *
 * @author ADMIN
 */
public class Shop {
    static int id=0, fr_quantity;
    static double price;
    static String fr_name, origin;
    static ArrayList<Fruit> fr_list = new ArrayList<>();
    static Management manage = new Management();
    static Hashtable<String, ArrayList<Order>> ord_ht = new Hashtable<String, ArrayList<Order>>();
    
    public static void createProduct(){
        int id = 0;
        boolean loop=true;
        do{
            id++;
            System.out.println("Create a new fruit: ");
            boolean loop2=true;
            do{  
                 fr_name = Validation.GetString("Enter fruit's name: ", false);
                 if(fr_list.size()>=1){
                    for(Fruit fr : fr_list){
                        if(fr_name.equalsIgnoreCase(fr.getFr_name())){
                            loop2=true;
                            System.out.println("This fruit has already existed!");
                            break;
                        } else loop2=false;
                    }                   
                 } else loop2=false;
               } while(loop2);
            origin = Validation.GetString("Enter fruit's origin: ", false);
            fr_quantity = Validation.getInt("Enter fruit's quantity: ");
            price = Validation.getDouble("Enter fruit's price: ");
            Fruit fr = new Fruit(id, fr_quantity, price, fr_name, origin);
            fr_list.add(fr);
            if(Validation.GetYesNo("Do you want to continue (Y/N)? ")==false) loop=false;
        } while(loop);
            Management.displayCreatedFruit(fr_list);
    }
    
    public static void shopping(){
        int select_item;
        int input_quantity;
        String fr_name="";
        double price=0;
        String customer="";
        ArrayList<Order> ord_list = new ArrayList<>();
        boolean loop=true;
        do{
            Management.displayShopFruit(fr_list);
            
            boolean loop1=true;
            do{
               select_item=Validation.getInt("Select item: ");
               loop1 = Management.checkFruitbyItem(select_item, fr_list);    
            } while(loop1);
            
            for(Fruit fr : fr_list){
                if(select_item==fr.getFruitID()){
                    fr_name = fr.getFr_name();
                    price = fr.getPrice();
                }
            }
            
            boolean loop2=true;
            do{
               input_quantity = Validation.getInt("Please input quantity: ");
               loop2 = Management.inputValidQuantity(select_item, fr_list, input_quantity);
            } while(loop2);
            
            for(Fruit fr : fr_list){
                if(select_item==fr.getFruitID()){
                    fr.setQuantity(fr.getQuantity()-input_quantity);
                }
            }
            
            Order ord = new Order(fr_name, input_quantity, price);
            ord_list.add(ord);
            
            if(Validation.GetYesNo("Do you want to order now (Y/N)? ")==true){
               Management.displayOrderList(ord_list);
               loop = false;
            } 
        } while(loop);
        customer = Validation.GetString("Input your name: ", false);
        ord_ht.put(customer, ord_list);
    }
    
    public static void viewOrder(){
        if(ord_ht.size()<1){
            System.out.println("There have not any orders yet!");
            return;
        }
        for(String name:ord_ht.keySet()){
            System.out.println("Customer: "+name);
            ArrayList<Order> ord_list = ord_ht.get(name);
            Management.displayOrderList(ord_list);
        }
    }
}
