/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Validation {
    public static boolean GetYesNo(String msg)
    {
        String s = "";
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        do
        {
            System.out.print(msg);
            try
            {
                s = sc.next("[yn]");
                loop = false;
            }
            catch(Exception e)
            {
                System.out.println(e);
                sc.nextLine();
            }
        }while(loop);
        return s.charAt(0) == 'y';
    }
    public static String GetString(String msg, boolean isEmpty)
    {
        String s = "";
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        do
        {
            System.out.print(msg);
            try
            {
                s = sc.nextLine();
                if(isEmpty)
                    loop = false;
                else if(!s.isEmpty())
                    loop = false;
            }
            catch(Exception e)
            {
                System.out.println(e);
                sc.nextLine();
            }
        }while(loop);
        System.out.println();
        return s;
    }
    public static int getInt(String msg){
        int i = 0;
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        do
        {
            System.out.print(msg);
            try
            {
                i = Integer.parseInt(sc.nextLine());
                if(i<=0){
                    System.out.println("Invalid input!");
                    loop = true;
                } else loop = false;
            }
            catch(NumberFormatException e)
            {
                System.out.println("Need number format!");
                sc.nextLine();
            }
        }while(loop);
        System.out.println();
        return i;
    }
    public static double getDouble(String msg){
        double i = 0;
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        do
        {
            System.out.print(msg);
            try
            {
                i = Double.parseDouble(sc.nextLine());
                if(i<=0){
                    System.out.println("Invalid input!");
                    loop = true;
                } else loop = false;
            }
            catch(NumberFormatException e)
            {
                System.out.println("Need number format!");
                sc.nextLine();
            }
        }while(loop);
        System.out.println();
        return i;
    }
}
