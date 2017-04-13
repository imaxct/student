package imaxct.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by maxct on 2017/4/9.
 */
@Entity
public class StudentCourse {

    public StudentCourse(){}

    @EmbeddedId
    private StudentCoursePK pk;

    @Column(columnDefinition = "NUMERIC(5, 1)")
    private double score;

    public StudentCoursePK getPk() {
        return pk;
    }

    public void setPk(StudentCoursePK pk) {
        this.pk = pk;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
