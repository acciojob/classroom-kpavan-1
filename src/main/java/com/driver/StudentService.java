package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public void addStudent(Student student){
        studentRepository.addStudent(student);
    }

    public void addTeacher(Teacher teacher){
        studentRepository.addTeacher(teacher);
    }

    public void studentTeacherPair(String student,String teacher){
        studentRepository.studentTeacherPair(student,teacher);
    }

    public Student getStudentName(String student){
        return studentRepository.getStudentName(student);
    }

    public Teacher getTeacherName(String teacher){
        return studentRepository.getTeacherName(teacher);
    }

    public List<String> studentsList(String teacher){
        return studentRepository.studentsList(teacher);
    }

    public List<String> allStudents(){
        return studentRepository.allStudents();
    }

    public void deleteTeacher(String teacher){
        studentRepository.deleteTeacher(teacher);

    }

    public void deleteAllTeachers(){
        studentRepository.deleteAllTeachers();
    }
}
