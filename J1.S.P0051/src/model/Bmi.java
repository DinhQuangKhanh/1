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
public class Bmi {

    private double weight;
    private double height;
    private String status;

    public Bmi() {
    }

    public Bmi(double weight, double height, String status) {
        this.weight = weight;
        this.height = height;
        this.status = status;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Bmi{" + "weight=" + weight + ", height=" + height + ", status=" + status + '}';
    }

}
