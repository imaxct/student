package imaxct.domain

import javax.persistence.*
import java.io.Serializable

/**
 * Created by imaxct on 17-4-25.
 * student
 */
@Entity
@Table(name = "STU_admin")
class Admin : Serializable {
    @Id
    @GeneratedValue
    var id: Int = 0

    @Column(length = 50, unique = true)
    var username: String? = null

    @Column(length = 30)
    var password: String? = null
}
