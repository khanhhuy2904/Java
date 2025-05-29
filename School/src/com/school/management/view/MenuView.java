package com.school.management.view;

import com.school.management.constant.Constants;
import com.school.management.controller.*;
import com.school.management.model.Student;
import com.school.management.model.Subject;
import com.school.management.model.Teacher;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MenuView {

    private StudentService studentService = new StudentServiceImpl();
    private TeacherService teacherService = new TeacherServicelmpl();
    private SubjectService subjectService = new SubjectServicelmpl();

    private StudentView studentView = new StudentView();
    private TeacherView teacherView = new TeacherView();
    private SubjectView subjectView = new SubjectView();

    public void printMenu() {
        boolean isRunning = true;
        Scanner sc = new Scanner(System.in);
        while (isRunning) {
            System.out.println("==== Quản lý môn học ====\n" +
                    "1. Danh sách học sinh\n" +
                    "2. Xem thông tin chi tiết học sinh\n" +
                    "3. Tạo mới học sinh\n" +
                    "4. Chỉnh sửa thông tin học sinh\n" +
                    "5. Xóa học sinh\n" +
                    "6. Danh sách giáo viên\n" +
                    "7. Xem thông tin chi tiết giáo viên\n" +
                    "8. Tạo mới giáo viên\n" +
                    "9. Chỉnh sửa thông tin giáo viên\n" +
                    "10 . Xóa giáo viên\n" +
                    "11 . Danh sách môn học\n" +
                    "12 . Xem thông tin chi tiết môn học\n" +
                    "13 . Tạo mới môn học\n" +
                    "14 . Chỉnh sửa thông tin môn học\n" +
                    "15 . Xóa môn học\n" +
                    "16 . Thêm giáo viên vào môn học\n" +
                    "17 . Thêm sinh viên vào môn học (có thể thêm nhiều học sinh 1 lúc)");
            int chose = sc.nextInt();
            switch (chose) {
                case Constants.SHOW_LIST_STUDENT: {
                    System.out.println(studentService.getAll());
                    break;
                }
                case Constants.GET_DETAIL_STUDENT: {
                    sc.nextLine();
                    System.out.print("Enter code student: ");
                    String code = sc.nextLine();

                    try {
                        Student student = studentService.getByCode(code);
                        studentView.printStudentDetail(student);
                    } catch (Exception ex) {
                        System.out.println("Lỗi: " + ex.getMessage());
                    }
                    break;
                }
                case Constants.CREATE_STUDENT: {
                    Student student = studentView.screenCreateStudent();
                    try {
                        studentService.create(student);
                    } catch (Exception ex) {
                        System.out.println("Error: " + ex.getMessage());
                    }
                    break;
                }
                case Constants.EDIT_STUDENT: {
                    sc.nextLine(); // Clear newline buffer
                    System.out.print("Enter student code to edit: ");
                    String code = sc.nextLine();
                    try {
                        Student existingStudent = studentService.getByCode(code);
                        Student student = studentView.screenEditStudent(existingStudent);
                        studentService.edit(student); // Pass updated student to service
                        System.out.println("Student updated successfully!");
                    } catch (Exception ex) {
                        System.out.println("Error: " + ex.getMessage());
                    }
                    break;
                }
                case Constants.DELETE_STUDENT: {
                    sc.nextLine();
                    System.out.print("Enter code student delete: ");
                    String code = sc.nextLine();

                    try {
                        studentService.deleteByCode(code);
                    } catch (Exception ex) {
                        System.out.println("Lỗi: " + ex.getMessage());
                    }
                    break;
                }
                case Constants.SHOW_LIST_TEACHER: {
                    System.out.println(teacherService.getAll());
                    break;
                }
                case Constants.GET_DETAIL_TEACHER: {
                    sc.nextLine();
                    System.out.print("Enter code teacher: ");
                    String code = sc.nextLine();

                    try {
                        Teacher teacher = teacherService.getByCode(code);
                        teacherView.printTeacherDetail(teacher);
                    } catch (Exception ex) {
                        System.out.println("Lỗi: " + ex.getMessage());
                    }
                    break;
                }
                case Constants.CREATE_TEACHER: {
                    Teacher teacher = teacherView.screenCreateTeacher();
                    try {
                        teacherService.create(teacher);
                    } catch (Exception ex) {
                        System.out.println("Error: " + ex.getMessage());
                    }
                    break;
                }
                case Constants.EDIT_TEACHER: {
                    sc.nextLine(); // Clear newline buffer
                    System.out.print("Enter teacher code to edit: ");
                    String code = sc.nextLine();
                    try {
                        Teacher existingTeacher = teacherService.getByCode(code);
                        Teacher teacher = teacherView.screenEditTeacher(existingTeacher);
                        teacherService.edit(teacher); // Pass updated student to service
                        System.out.println("Teacher updated successfully!");
                    } catch (Exception ex) {
                        System.out.println("Error: " + ex.getMessage());
                    }
                    break;
                }
                case Constants.DELETE_TEACHER: {
                    sc.nextLine();
                    System.out.print("Enter code teacher delete: ");
                    String code = sc.nextLine();

                    try {
                        teacherService.deleteByCode(code);
                    } catch (Exception ex) {
                        System.out.println("Lỗi: " + ex.getMessage());
                    }
                    break;
                }
                case Constants.SHOW_LIST_SUBJECT: {
                    System.out.println(subjectService.getAll());
                    break;
                }
                case Constants.GET_DETAIL_SUBJECT: {
                    sc.nextLine();
                    System.out.print("Enter code subject: ");
                    String code = sc.nextLine();

                    try {
                        Subject subject = subjectService.getByCode(code);
                        subjectView.printSubjectDetail(subject);
                    } catch (Exception ex) {
                        System.out.println("Lỗi: " + ex.getMessage());
                    }
                    break;
                }
                case Constants.CREATE_SUBJECT: {
                    Subject subject = subjectView.screenCreateSubject();
                    try {
                        subjectService.create(subject);
                    } catch (Exception ex) {
                        System.out.println("Error: " + ex.getMessage());
                    }
                    break;
                }
                case Constants.EDIT_SUBJECT: {
                    sc.nextLine();
                    System.out.print("Enter subject code to edit: ");
                    String code = sc.nextLine();
                    try {
                        Subject existingSubject = subjectService.getByCode(code);
                        Subject subject = subjectView.screenEditSubject(existingSubject);
                        subjectService.edit(subject);
                        System.out.println("Subject updated successfully!");
                    } catch (Exception ex) {
                        System.out.println("Error: " + ex.getMessage());
                    }
                    break;
                }
                case Constants.DELETE_SUBJECT: {
                    sc.nextLine();
                    System.out.print("Enter code subject delete: ");
                    String code = sc.nextLine();

                    try {
                        subjectService.deleteByCode(code);
                    } catch (Exception ex) {
                        System.out.println("Lỗi: " + ex.getMessage());
                    }
                    break;
                }
                case Constants.ASSIGN_TEACHER_TO_SUBJECT: {
                    subjectView.assignTeacherToSubject();
                    break;
                }
                case Constants.ADD_STUDENTS_TO_SUBJECT: {
                    subjectView.addStudentsToSubject();
                    break;
                }
                default:
            }
        }
    }

}
