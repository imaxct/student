package imaxct.domain

import javax.persistence.*
import java.io.Serializable
import java.util.Date


@Entity
@Table(name = "STU_selection")
class Selection : Serializable {

    constructor(){}

    constructor(id: SelectPK){
        this.id = id
        selectDate = Date()
    }

    @EmbeddedId
    var id: SelectPK? = null

    @Column(columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    var selectDate: Date? = null
}
