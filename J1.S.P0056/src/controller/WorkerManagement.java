/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Scanner;
import model.Worker;
import model.WorkerList;
import view.Menu;

/**
 *
 * @author ADMIN
 */
public class WorkerManagement extends Menu {

    private Scanner sc;
    private ArrayList<Worker> lw;
    private ArrayList<WorkerList> lh;
    private Validation validation;

    public WorkerManagement(String td, String[] mc) {
        super(td, mc);
        this.sc = new Scanner(System.in);
        this.lw = new ArrayList<>();
        this.lh = new ArrayList<>();
        this.validation = new Validation(sc);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                addWorker();
                break;
            case 2:
                changeSalary(1);
                break;
            case 3:
                changeSalary(2);
                break;
            case 4:
                printListHistory();
                break;
            case 5:
                System.exit(0);
        }
    }

    public void addWorker() {
        System.out.println("--------- Add Worker ----------");
        System.out.print("Enter code: ");
        String code = validation.checkInputString();
        System.out.print("Enter name: ");
        String name = validation.checkInputString();
        System.out.print("Enter age: ");
        int age = validation.checkInputIntLimit(18, 50);
        System.out.print("Enter salary: ");
        int salary = validation.checkInputSalary();
        System.out.print("Enter work location: ");
        String workLocation = validation.checkInputString();
        Worker worker = new Worker(code, name, age, salary, workLocation);
        if (!validation.checkWorkerExist(lw, code, name, age, salary, workLocation)) {
            System.err.println("Duplicate.");
        } else {
            lw.add(new Worker(code, name, age, salary, workLocation));
            System.err.println("Add success.");
        }
    }

    public Worker getWorkerByCode(String id) {
        for (Worker worker : lw) {
            if (id.equalsIgnoreCase(worker.getId())) {
                return worker;
            }
        }
        return null;
    }

    public void changeSalary(int status) {
        System.out.println("------- Up/Down Salary --------");
        if (lw.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        System.out.print("Enter code: ");
        String id = validation.checkInputString();
        Worker worker = getWorkerByCode(id);
        if (worker == null) {
            System.err.println("Not exist worker.");
        } else {
            int salaryCurrent = worker.getSalary();
            int salaryUpdate;
            if (status == 1) {
                System.out.print("Enter salary: ");
                while (true) {
                    salaryUpdate = validation.checkInputSalary();
                    if (salaryUpdate <= salaryCurrent) {
                        System.err.println("Must be greater than current salary.");
                        System.out.print("Enter again: ");
                    } else {
                        break;
                    }
                }
                lh.add(new WorkerList("UP", validation.getDate(), worker.getId(),
                        worker.getName(), worker.getAge(), salaryUpdate,
                        worker.getWorkLocation()));
            } else {
                System.out.print("Enter salary: ");
                while (true) {
                    salaryUpdate = validation.checkInputSalary();
                    if (salaryUpdate >= salaryCurrent) {
                        System.err.println("Must be smaller than current salary.");
                        System.out.print("Enter again: ");
                    } else {
                        break;
                    }
                }
                lh.add(new WorkerList("DOWN", validation.getDate(), worker.getId(),
                        worker.getName(), worker.getAge(), salaryUpdate,
                        worker.getWorkLocation()));
            }
            worker.setSalary(salaryUpdate);
            System.err.println("Update success");
        }
    }

    public void printListHistory() {
        System.out.println("--------------------Display Information Salary-----------------------");
        if (lh.isEmpty()) {
            System.err.println("History is empty.");
            return;
        }
        System.out.printf("%-5s%-15s%-5s%-10s%-10s%-20s\n", "Code", "Name", "Age", "Salary", "Status", "Date");
        for (WorkerList list : lh) {
            System.out.printf("%-5s%-15s%-5d%-10d%-10s%-20s\n", list.getId(),
                    list.getName(), list.getAge(), list.getSalary(),
                    list.getDate(), list.getStatus());
        }
    }
}
