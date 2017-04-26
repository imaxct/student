package imaxct.domain

import javax.persistence.Embeddable
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import java.io.Serializable

/**
 * Created by maxct on 2017/4/9.
 */
@Embeddable
class StudentCoursePK : Serializable {
    constructor() {}

    constructor(sid: Student, cid: Course) {
        this.sid = sid
        this.cid = cid
    }

    @ManyToOne
    @JoinColumn
    var sid: Student? = null

    @ManyToOne
    @JoinColumn
    var cid: Course? = null
}
