package com.bruce.rmi.runtest;

import com.bruce.rmi.entity.Student;
import com.bruce.rmi.service.StudentService;

import java.rmi.Naming;
import java.util.List;
public class GetService {
    public static void main(String[] args) {
        try {
            StudentService studentService=(StudentService) Naming.lookup("rmi://127.0.0.1:5008/StudentService");
            List<Student> list = studentService.getList();
            for (Student s : list) {
                System.out.println("姓名："+s.getName()+",年龄："+s.getAge());
            }

            Student student = list.get(0);
            String result = studentService.val("asdf-阿斯蒂芬",110,student);
            System.out.println("result = [" + result + "]");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}