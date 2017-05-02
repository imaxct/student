package imaxct.dao

import imaxct.domain.Course

/**
 * Created by maxct on 2017/4/9.
 */
interface ICourseDao {
    fun addCourse(course: Course): Boolean

    fun deleteCourse(course: Course): Boolean

    fun updateCourse(course: Course): Boolean

    fun getAllCourses(): List<Course>

    fun getCourseById(id: Int): Course

    fun getCourseFromId(id: Int): List<Course>

    fun allCourses(): List<Course>
}
