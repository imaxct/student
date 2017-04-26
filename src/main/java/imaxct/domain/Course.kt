package imaxct.domain

import javax.persistence.*
import java.io.Serializable
import java.util.Date

/**
 * Created by maxct on 2017/4/9.
 */
@Entity
@Table(name = "STU_course")
class Course : Serializable {

    @Id
    @GeneratedValue
    var id: Int = 0

    @Column(length = 100)
    var name: String? = null

    @Column(columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    var endDate: Date? = null

    /**
     * -1非贫困 0 无限制 1 贫困
     */
    var restrict = 0

    @Column(length = 250)
    var description: String? = null

    var capacity = 0

    var occupied = 0

    @Column(length = 10)
    var gradeLimit: String? = null

    @Column(length = 100)
    var location: String? = null
}
