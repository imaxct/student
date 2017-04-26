package imaxct.domain

import javax.persistence.Embeddable
import javax.persistence.ManyToOne

/**
 * Created by imaxct on 17-4-25.
 * student
 */
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
