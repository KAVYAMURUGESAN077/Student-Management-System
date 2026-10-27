package com.DAO;

import java.util.List;
import com.DTO.Student;

public interface Methods {

    List<Student> getstu();

    Student getid(int sid);

    boolean insert(int sid, String sname, long sph);

    boolean update(Student s);

    boolean delete(int sid);

    List<Student> searchByName(String name);

    int countStudents();
}