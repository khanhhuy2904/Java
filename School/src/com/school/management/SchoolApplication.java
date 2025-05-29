package com.school.management;

import com.school.management.constant.Constants;
import com.school.management.model.Subject;
import com.school.management.model.Teacher;
import com.school.management.view.MenuView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class SchoolApplication {

    public static void main(String[] args) {

        Constants.globalTeachers.add(new Teacher("Nguyen Van Huy", "Nam", LocalDate.of(1980, 9, 9), 10));
        Constants.globalTeachers.add(new Teacher("Tran Thi Lan", "Nữ", LocalDate.of(1985, 3, 12), 12));


        Constants.globalSubjects.add(new Subject("Object-Oriented Programming", 50, 3));
        Constants.globalSubjects.add(new Subject("Data Structures and Algorithms", 60, 4));
        Constants.globalSubjects.add(new Subject("Database Systems", 55, 3));
        Constants.globalSubjects.add(new Subject("Computer Networks", 45, 3));
        Constants.globalSubjects.add(new Subject("Operating Systems", 40, 4));

        MenuView view = new MenuView();
        view.printMenu();
    }
}