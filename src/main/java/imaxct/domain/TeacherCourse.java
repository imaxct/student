package imaxct.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by maxct on 2017/4/9.
 */
@Entity
public class TeacherCourse {

    public TeacherCourse(){}
    @EmbeddedId
    private TeacherCoursePK pk;

    public TeacherCoursePK getPk() {
        return pk;
    }

    public void setPk(TeacherCoursePK pk) {
        this.pk = pk;
    }
}
