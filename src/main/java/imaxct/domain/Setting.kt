package imaxct.domain

import javax.persistence.*

/**
 * Created by imaxct on 17-4-30.
 * student
 */
@Entity
@Table(name = "STU_setting")
class Setting{
    constructor(){}

    constructor(key: String, value: String){
        this.key = key
        this.value = value
    }

    @Id
    @GeneratedValue
    var id: Int = 0

    @Column(length = 20)
    var key: String = ""

    @Column(length = 500)
    var value: String = ""
}
