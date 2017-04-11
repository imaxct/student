package imaxct.domain;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by maxct on 2017/4/9.
 */
@Embeddable
public class TeacherCoursePK implements Serializable {

    public TeacherCoursePK(){}

    public TeacherCoursePK(Teacher tid, Course cid){
        this.cid = cid;
        this.tid = tid;
    }

    @ManyToOne
    @JoinColumn
    private Teacher tid;

    @ManyToOne
    @JoinColumn
    private Course cid;

    public Teacher getTid() {
        return tid;
    }

    public void setTid(Teacher tid) {
        this.tid = tid;
    }

    public Course getCid() {
        return cid;
    }

    public void setCid(Course cid) {
        this.cid = cid;
    }
}
