package com.school.management.controller;

import com.school.management.constant.Constants;
import com.school.management.exceptions.StudentDuplicateException;
import com.school.management.exceptions.StudentNotFoundException;
import com.school.management.model.Student;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    @Override
    public List<Student> getAll() {
        return Constants.globalStudents;
    }

    @Override
    public Student getByCode(String code) {
        for (Student student : Constants.globalStudents) {
            if (student.getCodeStudent().equalsIgnoreCase(code)) {
                return student;
            }
        }
        throw new StudentNotFoundException("Not found " + code + " student");
    }

    @Override
    public void create(Student student) {
        for (Student oldStudent : Constants.globalStudents) {
            if (student.getCodeStudent().equals(oldStudent.getCodeStudent())) {
                throw new StudentDuplicateException("Student code " + student.getCodeStudent() + " exists");
            }
        }
        Constants.globalStudents.add(student);
    }

    @Override
    public void edit(Student student) {
        for (int i = 0; i < Constants.globalStudents.size(); i++) {
            Student current = Constants.globalStudents.get(i);
            if (current.getCodeStudent().equalsIgnoreCase(student.getCodeStudent())) {
                Constants.globalStudents.set(i, student);
                break;
            }
        }
    }

    @Override
    public void deleteByCode(String code) {
        Student student = this.getByCode(code);
        Constants.globalStudents.remove(student);
    }
}
