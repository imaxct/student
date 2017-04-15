package imaxct.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by maxct on 2017/4/9.
 */
@Entity
public class Course {

    @Id
    @Column(length = 50)
    private String cid;

    @Column(length = 50)
    private String name;

    @Column(columnDefinition = "NUMERIC(5,1)")
    private double credit;

    /**
     * 课程属性
     * */
    @Column(length = 10)
    private String property;

    /**
     * 1-7
     * */
    private int dayOrder;

    private int courseOrder;

    @ManyToOne
    private Teacher teacher;

    @Column(length = 30)
    private String week;

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public int getDayOrder() {
        return dayOrder;
    }

    public void setDayOrder(int dayOrder) {
        this.dayOrder = dayOrder;
    }

    public int getCourseOrder() {
        return courseOrder;
    }

    public void setCourseOrder(int courseOrder) {
        this.courseOrder = courseOrder;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }
}
