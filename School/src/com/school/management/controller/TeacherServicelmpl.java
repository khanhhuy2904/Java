package com.school.management.controller;

import com.school.management.constant.Constants;
import com.school.management.exceptions.StudentDuplicateException;
import com.school.management.exceptions.StudentNotFoundException;
import com.school.management.exceptions.TeacherDuplicateException;
import com.school.management.exceptions.TeacherNotFoundException;
import com.school.management.model.Student;
import com.school.management.model.Teacher;

import java.util.Collections;
import java.util.List;

public class TeacherServicelmpl implements TeacherService{
    @Override
    public List<Teacher> getAll() {
        return Constants.globalTeachers;
    }


    @Override
    public Teacher getByCode(String code) {
        for (Teacher teacher : Constants.globalTeachers) {
            if (teacher.getCodeTeacher().equalsIgnoreCase(code)) {
                return teacher;
            }
        }
        throw new TeacherNotFoundException("Not found " + code + " teacher");
    }

    @Override
    public void create(Teacher teacher) {
        for (Teacher oldTeacher : Constants.globalTeachers) {
            if (teacher.getCodeTeacher().equals(oldTeacher.getCodeTeacher())) {
                throw new TeacherDuplicateException("Teacger code " + teacher.getCodeTeacher() + " exists");
            }
        }
        Constants.globalTeachers.add(teacher);
    }

    @Override
    public void edit(Teacher teacher) {
        for (int i = 0; i < Constants.globalTeachers.size(); i++) {
            Teacher current = Constants.globalTeachers.get(i);
            if (current.getCodeTeacher().equalsIgnoreCase(teacher.getCodeTeacher())) {
                Constants.globalTeachers.set(i, teacher);
                break;
            }
        }
    }

    @Override
    public void deleteByCode(String code) {
        Teacher teacher = this.getByCode(code);
        Constants.globalTeachers.remove(teacher);
    }
}
