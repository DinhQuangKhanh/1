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
public class WorkerList extends Worker implements Comparable<WorkerList>{
    private String date;
    private String status;

    public WorkerList(){
        
    }
    
    public WorkerList(String date, String status, String id, String name, int age, int salary, String workLocation) {
        super(id, name, age, salary, workLocation);
        this.date = date;
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "WorkerList{" + "date=" + date + ", status=" + status + '}';
    }
    
    

    @Override
    public int compareTo(WorkerList o) {
        return this.getId().compareTo(o.getId());
    }
    
    
}
