package imaxct.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by maxct on 2017/4/9.
 */
@Entity
@Table
public class Department {

    @Id
    private String dname;
}
