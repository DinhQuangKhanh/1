/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ManageEastAsiaCountries;

/**
 *
 * @author ADMIN
 */
public class Main {
     public static void main(String[] args) {
        String mChon[] = {"Input the information of 11 countries in East Asia",
                          "Display the information of country you've just input",
                          "Search the information of country by user-entered name",
                          "Display the information of countries sorted name in ascending",
                          "Exit"};
        ManageEastAsiaCountries manageEastAsiaCountries = new ManageEastAsiaCountries("MENU", mChon);
        manageEastAsiaCountries.run();
    }
}
