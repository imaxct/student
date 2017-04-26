package imaxct.domain

import java.io.Serializable
import javax.persistence.Embeddable
import javax.persistence.ManyToOne

@Embeddable
class SelectPK : Serializable{

    constructor(){}

    constructor(user: User, course: Course){
        this.user = user
        this.course = course
    }

    @ManyToOne
    var user: User? = null

    @ManyToOne
    var course: Course? = null
}
