package imaxct.domain

import javax.persistence.*
import java.io.Serializable
import java.util.Date

/**
 * Created by imaxct on 17-4-25.
 * student
 */
@Entity
@Table(name = "STU_selection")
class Selection : Serializable {

    @EmbeddedId
    var id: SelectPK? = null

    @Column(columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    var selectDate: Date? = null
}
