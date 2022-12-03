package com.driver;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
@Repository
public class StudentRepository {
    HashMap<String,Student> studentList =new HashMap<>();
    HashMap<String,Teacher> teacherList=new HashMap<>();
    HashMap<String, List<String>> studentTeacherPair = new HashMap<>();

    public void addStudent(Student student){
        studentList.put(student.getName(),student);
    }

    public void addTeacher(Teacher teacher){
        teacherList.put(teacher.getName(),teacher);
    }

    public void studentTeacherPair(String student,String teacher){
        if(studentList.containsKey(student) && teacherList.containsKey(teacher)){
            List<String> students=new ArrayList<>();
            if(studentTeacherPair.containsKey(teacher)){
                students=studentTeacherPair.get(teacher);
            }
            students.add(student);
            studentTeacherPair.put(teacher,students);
        }
    }

    public Student getStudentName(String student){
//        if(studentList.containsKey(student))
            return studentList.get(student);

    }

    public Teacher getTeacherName(String teacher){
//        if(studentList.containsKey(teacher))
             return teacherList.get(teacher);
    }

    public List<String> studentsList(String teacher){
        return studentTeacherPair.get(teacher);
    }

    public List<String> allStudents(){
        List<String> students=new ArrayList<>();
        for(String student : studentList.keySet()){
            students.add(student);
        }
        return students;
    }

    public void deleteTeacher(String teacher){
        List<String> students =new ArrayList<>();
        if(studentTeacherPair.containsKey(teacher)){
            students=studentTeacherPair.get(teacher);
        }
        studentTeacherPair.remove(teacher);
        for(String student:students){
            if(studentList.containsKey(student)){
                studentList.remove(student);
            }
        }

    }

    public void deleteAllTeachers(){
        for(String st:studentTeacherPair.keySet()){
            deleteTeacher(st);
        }
    }



}
