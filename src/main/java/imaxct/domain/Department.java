package imaxct.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by maxct on 2017/4/9.
 */
@Entity
public class Department {

    @Id
    @Column(length = 100)
    private String dname;
}
