
package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import model.Report;
import model.Student;

/**
 *
 * @author ADMIN
 */
public class StudentList {
    private ArrayList<Student> listStudents = new ArrayList<>();
    
    public void addStudent(Student newStudent){
        if (checkValid(newStudent)) {
            if (isDuplicate(newStudent) == false){
                listStudents.add(newStudent);
            }
        }
    }
    
    public ArrayList<Student> findStudentByName(String name) {
        ArrayList<Student> resultListFindByName = new ArrayList<>();
        for (Student tempStudent : listStudents) {
            if (tempStudent.getName().toLowerCase().contains(name.toLowerCase())) {
                resultListFindByName.add(tempStudent);
            }
        }
        return resultListFindByName;
    }
    
    public ArrayList<Student> findStudentById(String searchID) {
        ArrayList<Student> resultListFindById = new ArrayList<>();
        for (Student tempStudent : listStudents) {
            if (tempStudent.getId().equalsIgnoreCase(searchID)) {
                resultListFindById.add(tempStudent);
            }
        }
        return resultListFindById;
    }
    
    public void displayListStudent() {
        for (Student tempStudent : listStudents) {
            tempStudent.displayFullInfo();
        }
    }

    //    check list student is empty
    public boolean isEmptyList() {
        return listStudents.isEmpty();
    }

    public void updateStudent(Student theStudent, String id, String name, String semester, String courseName) {
        theStudent.setId(id);
        theStudent.setName(name);
        theStudent.setSemester(semester);
        theStudent.setCourseName(courseName);
    }

    public void deleteStudent(Student theStudent) {
        listStudents.remove(theStudent);
    }

    //    return a list report student with name, course and total course
    public ArrayList<Report> getReportList() {
        String id, name, course;
        int totalCourse;

        ArrayList<Report> listReports = new ArrayList<>();
        ArrayList<Student> tempList = (ArrayList<Student>) listStudents.clone();

        for (Student tempStudent : listStudents) {
            totalCourse = 0;
            id = tempStudent.getId();
            name = tempStudent.getName();
            course = tempStudent.getCourseName();
            //   if same name and course name, increase total course and decrease i
            for (int i = 0; i < tempList.size(); i++) {
                if (tempList.get(i).getId().equalsIgnoreCase(id)
                        && tempList.get(i).getName().equalsIgnoreCase(name)
                        && tempList.get(i).getCourseName().equalsIgnoreCase(course)) {
                    ++totalCourse;
                    tempList.remove(i);
                    --i;
                }
            }
            listReports.add(new Report(name, course, totalCourse));
        }
        return listReports;
    }

    public int getNumberStudent() {
        return listStudents.size();
    }

//    check id existed
    public boolean isExistedId(String id) {
        for (Student tempStudent : listStudents) {
            if (tempStudent.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

//    return a student with id input
    public Student getStudentById(String id) {
        for (Student tempStudent : listStudents) {
            if (tempStudent.getId().equalsIgnoreCase(id)) {
                return tempStudent;
            }
        }
        return null;
    }

//  sort list student ascending by name
    public void sortStudentByNameAsc(ArrayList<Student> list) {
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }



    boolean checkValid(Student newStudent) {
        for (Student tempStudent : listStudents){
            if (tempStudent.getId().equalsIgnoreCase(newStudent.getId())){
                if(tempStudent.getName().equalsIgnoreCase(newStudent.getName())){
                    return false;
                }
            }
        }
        return true;
    }

    boolean isDuplicate(Student newStudent) {
       String id = newStudent.getId();
       String name = newStudent.getName();
       String semester = newStudent.getSemester();
       String courseName = newStudent.getCourseName();
       
       for (Student tempStudent : listStudents) {
           if(tempStudent.getId().equalsIgnoreCase(id)
                   && tempStudent.getName().equalsIgnoreCase(name)
                   && tempStudent.getSemester().equalsIgnoreCase(semester)
                   && tempStudent.getCourseName().equalsIgnoreCase(courseName)){
               return true;
           }
       }
       return false;
    }
    
    
}
