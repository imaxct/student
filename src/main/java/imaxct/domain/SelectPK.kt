package imaxct.domain

import javax.persistence.Embeddable
import javax.persistence.ManyToOne

@Embeddable
class SelectPK {

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
