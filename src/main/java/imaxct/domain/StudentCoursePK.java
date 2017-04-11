package imaxct.domain;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by maxct on 2017/4/9.
 */
@Embeddable
public class StudentCoursePK implements Serializable{
    public StudentCoursePK(){}

    public StudentCoursePK(Student sid, Course cid){
        this.sid = sid;
        this.cid = cid;
    }
    @ManyToOne
    @JoinColumn
    private Student sid;

    @ManyToOne
    @JoinColumn
    private Course cid;

    public Student getSid() {
        return sid;
    }

    public void setSid(Student sid) {
        this.sid = sid;
    }

    public Course getCid() {
        return cid;
    }

    public void setCid(Course cid) {
        this.cid = cid;
    }
}
