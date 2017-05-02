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
    @Column(name = "setting_key", length = 20)
    var key: String = ""

    @Column(name = "setting_value", length = 500)
    var value: String = ""
}
