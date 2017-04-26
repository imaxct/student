package imaxct.service

import imaxct.bean.Msg
import imaxct.domain.Course

/**
 * Created by maxct on 2017/4/9.
 */
interface ICourseService {
    fun addCourse(course: Course): Msg<*>

    fun deleteCourse(course: Course): Msg<*>

    /**
     * id : -1 all
     */
    fun getAllCourses(id: Int): Msg<List<Course>>

}
