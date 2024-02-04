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
public class Normal {

    private String operator;
    private double memory;

    public Normal() {
    }

    public Normal(String operator, double memory) {
        this.operator = operator;
        this.memory = memory;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public double getMemory() {
        return memory;
    }

    public void setMemory(double memory) {
        this.memory = memory;
    }

    @Override
    public String toString() {
        return "Normal{" + "operator=" + operator + ", memory=" + memory + '}';
    }

}
