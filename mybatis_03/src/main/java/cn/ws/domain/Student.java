package cn.ws.domain;

import java.util.List;

public class Student {
    private int id;
    private String classroom;

    private List<User> userlist;

    public Student() {
    }


    public Student(int id, String classroom, List<User> userlist) {
        this.id = id;
        this.classroom = classroom;
        this.userlist = userlist;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public List<User> getUserlist() {
        return userlist;
    }

    public void setUserlist(List<User> userlist) {
        this.userlist = userlist;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", classroom='" + classroom + '\'' +
                ", userlist=" + userlist +
                '}';
    }
}
