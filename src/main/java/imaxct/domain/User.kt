package imaxct.domain

import javax.persistence.*
import java.io.Serializable

@Entity
@Table(name = "STU_user")
class User : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int = 0

    @Column(length = 20, unique = true)
    var stuNo: String? = null

    @Column(length = 5)
    var sex: String? = null

    @Column(length = 20)
    var name: String? = null

    @Column(length = 20, unique = true)
    var idNo: String? = null

    @Column(length = 10)
    var grade: String? = null

    @Column(length = 40)
    var campus: String? = null

    @Column(length = 20)
    var phone: String? = null

    @Column(length = 20)
    var qq: String? = null

    @Column(length = 50)
    var email: String? = null
}
