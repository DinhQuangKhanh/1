/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.WorkerManagement;

/**
 *
 * @author ADMIN
 */
public class Main {
    public static void main(String[] args) {
        String mChon[] = {"Add Worker","Up salary","Down salary","Display Information salary", "Exit"};
        WorkerManagement management = new WorkerManagement("======== Worker Management =========", mChon);
        management.run();
    }
}
