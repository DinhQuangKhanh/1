/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Collections;
import model.Country;
import model.EastAsiaCountries;
import view.Menu;

/**
 *
 * @author ADMIN
 */
public class ManageEastAsiaCountries extends Menu {
    ArrayList<Country> lc = new ArrayList<>();
    EastAsiaCountries eastcountry = new EastAsiaCountries();
    Validation valid = new Validation();

    public ManageEastAsiaCountries(String td, String[] mc) {
        super(td, mc);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                inputCountry(lc);
                break;
            case 2:
                printCountry(lc);
                break;
            case 3:
                searchByName(lc);
                break;
            case 4:
                printCountrySorted(lc);
                break;
            case 5:
                System.exit(0);
        }
    }

    public void inputCountry(ArrayList<Country> lc) {
        System.out.print("Enter code of country: ");
        String countryCode = valid.checkInputString();
        // check country code exist or not
        if (!valid.checkCountryExist(lc, countryCode)) {
            System.err.println("Country exists.");
            return;
        }
        System.out.print("Enter name of country: ");
        String countryName = valid.checkInputString();
        System.out.print("Enter total area: ");
        float totalArea = (float) valid.checkInputFloat();
        System.out.print("Enter terrain of country: ");
        String countryTerrain = valid.checkInputString();
        lc.add(new EastAsiaCountries(countryCode, countryName, totalArea, countryTerrain));
        System.err.println("Add successful.");
    }

    public void printCountry(ArrayList<Country> lc) {
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area", "Terrain");
        for (Country country : lc) {
            if (country instanceof EastAsiaCountries) {
                ((EastAsiaCountries) country).display();
            }
        }
    }

    public void printCountrySorted(ArrayList<Country> lc) {
        Collections.sort(lc);
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area", "Terrain");
        for (Country country : lc) {
            if (country instanceof EastAsiaCountries) {
                ((EastAsiaCountries) country).display();
            }
        }
    }

    public void searchByName(ArrayList<Country> lc) {
        System.out.print("Enter the name you want to search for: ");
        String countryName = valid.checkInputString();
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area", "Terrain");
        for (Country country : lc) {
            if (country instanceof EastAsiaCountries
                    && country.getCountryName().equalsIgnoreCase(countryName)) {
                ((EastAsiaCountries) country).display();
            }
        }
    }

}
