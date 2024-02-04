/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.DoctorManagement;

/**
 *
 * @author ADMIN
 */
public class Main {
    public static void main(String[] args) {
        String mChon[] = {"Add Doctor","Update Doctor","Delete Doctor","Search Doctor", "Exit"};
        DoctorManagement program = new DoctorManagement("========= Doctor Management ==========", mChon);
        program.run();
    }
}
