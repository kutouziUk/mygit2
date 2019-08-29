package cn.ws.domain;

public class User {
    private int id;
    private String username;
    private String password;
    private int age;
    private int sid;

    private Student student;

    public User() {
    }

    public User(int id, String username, String password, int age, int sid, Student student) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
        this.sid = sid;
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", sid=" + sid +
//                ", student=" + student +
                '}';
    }
}
