package imaxct.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by maxct on 2017/4/9.
 */
@Entity
@Table(name = "STU_course")
public class Course implements Serializable{

    @Id
    @GeneratedValue
    private int id;

    @Column(length = 100)
    private String name;

    @Column(columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    /**
     * -1非贫困 0 无限制 1 贫困
     * */
    private int restrict = 0;

    @Column(length = 250)
    private String description;

    private int capacity = 0;

    private int occupied = 0;

    @Column(length = 10)
    private String gradeLimit;

    @Column(length = 100)
    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getRestrict() {
        return restrict;
    }

    public void setRestrict(int restrict) {
        this.restrict = restrict;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getOccupied() {
        return occupied;
    }

    public void setOccupied(int occupied) {
        this.occupied = occupied;
    }

    public String getGradeLimit() {
        return gradeLimit;
    }

    public void setGradeLimit(String gradeLimit) {
        this.gradeLimit = gradeLimit;
    }
}
