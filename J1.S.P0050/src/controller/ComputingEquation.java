/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Validation;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import model.Quadractic;
import model.Superlative;

/**
 *
 * @author ADMIN
 */
public class ComputingEquation implements Equation {

    private Validation valid = new Validation();

    // ax+b
    @Override
    public List<Float> superlativeEquation() {
        Superlative se = new Superlative();
        se.instance();
        return calculateEquation(se.getA(), se.getB());
    }

    // ax^2+bx+c
    @Override
    public List<Float> quadraticEquation() {
        Quadractic qe = new Quadractic();
        qe.instance();
        return calculateQuadraticEquation(qe.getA(), qe.getB(), qe.getC());
    }

    private List<Float> calculateEquation(float a, float b) {
        List<Float> list = new ArrayList<>();

        if (a == 0) {
            System.out.println("Solution: x = null");
            print(new float[]{a, b});
            return null;
        } else if (b == 0) {
            System.out.println("infinitely many solutions");
            print(new float[]{a, b});
            return list;
        }

        list.add((-b) / a);
        System.out.println("Solution x = " + list.get(0));
        print(new float[]{a, b, list.get(0)});

        return list;
    }

    private List<Float> calculateQuadraticEquation(float a, float b, float c) {
        List<Float> list = new ArrayList<>();
        float discriminant = b * b - 4 * a * c;

        if (discriminant < 0) {
            System.out.println("The equation has two imaginary solutions");
            print(new float[]{a, b, c});
            return null;

        } else if (discriminant == 0) {
            float x = -b/(2*a);
            System.out.println("Two real same solution: x1=x2="+x);
            print(new float[]{a, b, c,x});
            list.add(x);
            return  list;
        }
        
        float x1 = (-b-(float)Math.sqrt(discriminant))/(2*a);
        float x2 = (-b+(float)Math.sqrt(discriminant))/(2*a);
        list.add(x1);
        list.add(x2);
        System.out.println("solutions: x1="+x1+", x2="+x2);
        print(new float[]{a, b, c,x1,x2});
        return list ;
    }

    private void isEvenNumber(float list[]) {
        System.out.print("Number is even: ");
        for (int i = 0; i < list.length; i++) {
            if (list[i] % 2 == 0) {
                System.out.print(list[i] + " ");
            }
        }
        System.out.println();
    }

    private void isOddNumber(float list[]) {
        System.out.print("Number is odd: ");
        for (int i = 0; i < list.length; i++) {
            if (list[i] % 2 != 0) {
                System.out.print(list[i] + " ");
            }
        }
        System.out.println();
    }

    private void isPerfectSquareNumber(float list[]) {
        System.out.print("Number is perfect square: ");
        for (int i = 0; i < list.length; i++) {
            if (list[i] > 0) {
                double result = Math.sqrt(list[i]);
                if (result * result == list[i]) {
                    System.out.print(list[i] + " ");
                }
            }
        }
        System.out.println();
    }

    private void print(float[] arr) {
        isEvenNumber(arr);
        isOddNumber(arr);
        isPerfectSquareNumber(arr);
    }

}