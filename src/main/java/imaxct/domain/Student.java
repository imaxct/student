package imaxct.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by maxct on 2017/4/9.
 */
@Entity
@Table(name = "student")
public class Student {

    public Student(){}

    @Id
    private String sid;

    @Column(length = 20)
    private String name;

    @ManyToOne
    private Department dname;

    @Column(name = "class")
    private String clazz;

    @Column(length = 5)
    private String sex;

    private int age;

    @Column(columnDefinition = "DATE")
    @Temporal(TemporalType.DATE)
    private Date birthday;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDname() {
        return dname;
    }

    public void setDname(Department dname) {
        this.dname = dname;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
