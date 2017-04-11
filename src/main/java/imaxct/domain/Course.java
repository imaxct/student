package imaxct.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by maxct on 2017/4/9.
 */
@Entity
@Table
public class Course {

    public Course(){}

    @Id
    private String cid;

    @Column(length = 50)
    private String name;

    @Column(columnDefinition = "NUMERIC(5,1)")
    private double credit;

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
