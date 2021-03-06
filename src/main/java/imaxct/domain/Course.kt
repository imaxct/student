package imaxct.domain

import java.io.Serializable
import java.util.*
import javax.persistence.*

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
     * 上课时间
     * */
    @Column(length = 200)
    var courseTime: String? = null

    /**
     * -1非贫困 0 无限制 1 贫困
     */
    @Column(name = "fCondition")
    var restrict = 0

    @Column(length = 250)
    var description: String? = null

    var capacity = 0

    var occupied = 0

    @Column(length = 50)
    var gradeLimit: String? = null

    @Column(length = 100)
    var location: String? = null
}
