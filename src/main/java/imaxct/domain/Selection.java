package imaxct.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by imaxct on 17-4-25.
 * student
 */
@Entity
@Table(name = "STU_selection")
public class Selection implements Serializable{

    @EmbeddedId
    private SelectPK id;

    @Column(columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date selectDate;

    public SelectPK getId() {
        return id;
    }

    public void setId(SelectPK id) {
        this.id = id;
    }

    public Date getSelectDate() {
        return selectDate;
    }

    public void setSelectDate(Date selectDate) {
        this.selectDate = selectDate;
    }
}
