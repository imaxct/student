package imaxct.domain;

import javax.persistence.*;

/**
 * Created by maxct on 2017/4/9.
 */
@Entity
public class Course {

    @Id
    @GeneratedValue
    private int id;

    @Column(length = 50)
    private String cid;

    @Column(length = 80)
    private String name;

    @Column(columnDefinition = "NUMERIC(5,1)")
    private double credit;

    @Column(length = 20)
    private String term;

    @Column(length = 80)
    private String location;
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

    private int total = 0;

    private int capacity = 0;

    @Column(length = 30)
    private String week;

    @ManyToOne
    private Teacher teacher;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

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
