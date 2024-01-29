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
public class Superlative{

    private float a, b;

    public Superlative(){
    }

    public float getA(){
        return a;
    }

    public void setA(float a){
        this.a = a;
    }

    public float getB(){
        return b;
    }

    public void setB(float b){
        this.b = b;
    }
    
    public void instance(){
        Validation valid = new Validation();
        a = valid.getFloatNumber("Enter A: ");
        b = valid.getFloatNumber("Enter B: ");
    }

    @Override
    public String toString(){
        return a+"X"+b;
    }
    
    
}
