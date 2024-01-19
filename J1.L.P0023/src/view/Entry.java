/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Shop;

/**
 *
 * @author ADMIN
 */
public class Entry {
     public static void main(String[] args) {
        Menu mn = new Menu();
        mn.add("1. Create fruit");
        mn.add("2. View orders");
        mn.add("3. Shopping (for buyer)");
        mn.add("4. Exit");

        Shop fruitShop = new Shop();

        int userChoice;
        do {
            mn.print();
            userChoice = mn.getUserChoice();
            switch (userChoice) {
                case 1:
                    Shop.createProduct();
                    break;
                case 2:
                    Shop.viewOrder();
                    break;
                case 3:
                    Shop.shopping();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (true);
    }
}
