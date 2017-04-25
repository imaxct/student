package imaxct.domain;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 * Created by imaxct on 17-4-25.
 * student
 */
@Embeddable
public class SelectPK {

    @ManyToOne
    private User user;

    @ManyToOne
    private Course course;
}
