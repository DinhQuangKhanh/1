/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.StudentManagement;
import java.util.Scanner;
import model.Validation;

public class Menu {
     public void displayMenu() {
        StudentManagement studentManagement = new StudentManagement();
        studentManagement.generateExampleStudent();
        int choice;
        while (true) {
            System.out.println("WELCOME TO STUDENT MANAGEMENT");
            System.out.println("\t1. Create");
            System.out.println("\t2. Find and Sort");
            System.out.println("\t3. Update/Delete");
            System.out.println("\t4. Report");
            System.out.println("\t5. Exit");
            System.out.println("");
            System.out.println("(Please choose 1 to Create, 2 to Find and Sort, 3 to Update/Delete, 4 to Report and 5 to Exit program)");
            choice = Validation.inputChoice("Enter your choice: ", 1, 5);
            switch (choice) {
                case 1:
                    studentManagement.createStudent();
                    break;
                case 2:
                    studentManagement.findAndSort();
                    break;
                case 3:
                    studentManagement.updateOrDeleteStudent();
                    break;
                case 4:
                    studentManagement.report();
                    break;
                case 5:
                    System.out.println("Exit program STUDENT MANAGEMENT");
                    return;
            }
        }
    }
}
