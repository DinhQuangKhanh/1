/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ADMIN
 */
import java.util.Comparator;

public class Country implements Comparable<Country> {

    protected String countryCode;
    protected String countryName;
    protected float totalArea;

    public Country() {
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public float getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(float totalArea) {
        this.totalArea = totalArea;
    }

    @Override
    public String toString() {
        return String.format("%-10s%-25s%-20.0f", this.countryCode, this.countryName, this.totalArea);
    }

    @Override
    public int compareTo(Country o) {
        return this.getCountryName().compareToIgnoreCase(o.getCountryName());
    }
}

