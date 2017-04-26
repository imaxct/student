package imaxct.service

import imaxct.domain.Course

/**
 * Created by maxct on 2017/4/9.
 */
interface ICourseService {
    fun addCourse(course: Course): Boolean

    fun deleteCourse(course: Course): Boolean

    /**
     * id : -1 all
     */
    fun getAllCourses(id: Int): List<Course>

}
