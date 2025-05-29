package com.school.management.model;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private static int numCode = 1;
    private String codeSubject;
    private String nameSubject;
    private int maxStudent;
    private int credit;
    private Teacher teacher;

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    private List<Student> studentList = new ArrayList<>();

    public List<Student> getStudentList() {
        return studentList;
    }

    public void addStudents(Student student) {
        studentList.add(student);
    }



    public Subject(String nameSubject, int maxStudent, int credit){
        this.nameSubject = nameSubject;
        this.maxStudent = maxStudent;
        this.credit = credit;
        this.codeSubject = generateCodeSubject();
    }
    private String generateCodeSubject(){
        return String.format("MH%05d", numCode++);
    }


    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    public String getCodeSubject() {
        return codeSubject;
    }

    public void setCodeSubject(String codeSubject) {
        this.codeSubject = codeSubject;
    }

    public int getMaxStudent() {
        return maxStudent;
    }

    public void setMaxStudent(int maxStudent) {
        this.maxStudent = maxStudent;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "Subject{" +
                ", codeSubject='" + codeSubject + '\'' +
                "nameSubject='" + nameSubject + '\'' +
                ", maxStudent=" + maxStudent +
                ", credit=" + credit +
                '}';
    }
}
