package imaxct.bean

import java.io.Serializable

/***
 * Created by imaxct on 17-4-15.
 */
class Msg<T> : Serializable {
    var code = -1

    var msg = ""

    var obj: T? = null

    constructor() {}

    constructor(code: Int, msg: String) {
        this.code = code
        this.msg = msg
    }

    constructor(msg: String) {
        this.msg = msg
    }

    constructor(code: Int, msg: String, obj: T) {
        this.code = code
        this.msg = msg
        this.obj = obj
    }
}
