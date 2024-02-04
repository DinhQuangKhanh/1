/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;

/**
 *
 * @author ADMIN
 */
public class DoctorList {

    HashMap<String, Doctor> doctorMap;

    public DoctorList() {
    }

    public DoctorList(HashMap<String, Doctor> doctorMap) {
        this.doctorMap = doctorMap;
    }

    public HashMap<String, Doctor> getDoctorMap() {
        return doctorMap;
    }

    public void setDoctorMap(HashMap<String, Doctor> doctorMap) {
        this.doctorMap = doctorMap;
    }
}
