package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.DTO.Student;
import com.connection.ConnectionClass;

public class MethodsImplementation implements Methods {

    Connection con = null;

    @Override
    public List<Student> getstu() {

        ArrayList<Student> list = new ArrayList<>();

        try {

            con = ConnectionClass.requestConnection();

            String query = "SELECT * FROM student";

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                int id = rs.getInt("sid");
                String name = rs.getString("sname");
                long phone = rs.getLong("sph");

                Student s = new Student(id, name, phone);

                list.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public Student getid(int sid) {

        Student s = null;

        try {

            con = ConnectionClass.requestConnection();

            String query = "SELECT * FROM student WHERE sid = ?";

            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setInt(1, sid);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {

                int id = rs.getInt("sid");
                String name = rs.getString("sname");
                long phone = rs.getLong("sph");

                s = new Student(id, name, phone);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return s;
    }

    @Override
    public boolean insert(int sid, String sname, long sph) {

        try {

            con = ConnectionClass.requestConnection();

            String query =
                    "INSERT INTO student (sid, sname, sph) VALUES (?, ?, ?)";

            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setInt(1, sid);
            pstmt.setString(2, sname);
            pstmt.setLong(3, sph);

            int result = pstmt.executeUpdate();

            return result > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean update(Student s) {

        try {

            con = ConnectionClass.requestConnection();

            String query =
                    "UPDATE student SET sname = ?, sph = ? WHERE sid = ?";

            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setString(1, s.getsname());
            pstmt.setLong(2, s.getsph());
            pstmt.setInt(3, s.getsid());

            int result = pstmt.executeUpdate();

            return result > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(int sid) {

        try {

            con = ConnectionClass.requestConnection();

            String query =
                    "DELETE FROM student WHERE sid = ?";

            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setInt(1, sid);

            int result = pstmt.executeUpdate();

            return result > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<Student> searchByName(String name) {

        ArrayList<Student> list = new ArrayList<>();

        try {

            con = ConnectionClass.requestConnection();

            String query =
                    "SELECT * FROM student WHERE sname LIKE ?";

            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setString(1, "%" + name + "%");

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("sid");
                String sname = rs.getString("sname");
                long phone = rs.getLong("sph");

                Student s = new Student(id, sname, phone);

                list.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public int countStudents() {

        int count = 0;

        try {

            con = ConnectionClass.requestConnection();

            String query = "SELECT COUNT(*) FROM student";

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {

                count = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }
}