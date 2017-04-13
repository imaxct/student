package imaxct.domain;

import javax.persistence.*;

/**
 * Created by maxct on 2017/4/9.
 */
@Entity
public class Teacher {

    public Teacher(){}

    @Id
    @Column(length = 30)
    private String tid;

    @Column(length = 10)
    private String name;

    @Column(length = 2)
    private String sex;

    @ManyToOne
    private Department dname;

    private int age;

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Department getDname() {
        return dname;
    }

    public void setDname(Department dname) {
        this.dname = dname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
