package imaxct.domain

import javax.persistence.*
import java.io.Serializable

@Entity
@Table(name = "STU_user")
class User : Serializable {

    constructor(){}

    constructor(stuNo: String? = null, sex: String? = null, name: String? = null, idNo: String? = null,
                grade: String? = null, campus: String? = null, phone: String? = null, qq: String? = null,
                email: String? = null, poor: Boolean = false) {
        this.stuNo = stuNo
        this.sex = sex
        this.name = name
        this.idNo = idNo
        this.grade = grade
        this.campus = campus
        this.phone = phone
        this.qq = qq
        this.email = email
        this.poor = poor
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int = 0

    @Column(length = 20, unique = true)
    var stuNo: String? = null

    @Column(length = 5)
    var sex: String? = null

    @Column(length = 50)
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

    var poor: Boolean = false
}
