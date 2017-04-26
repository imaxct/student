package imaxct.service.impl

import imaxct.domain.Course
import imaxct.service.ICourseService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * Created by maxct on 2017/4/9.
 */
@Service
@Transactional
open class CourseServiceImpl : BaseService(), ICourseService {

    override fun addCourse(course: Course): Boolean {
        return courseDao!!.addCourse(course)
    }

    override fun deleteCourse(course: Course): Boolean {
        return courseDao!!.deleteCourse(course)
    }

    override fun getAllCourses(id: Int): List<Course> {
        if (id == -1)
            return this.courseDao!!.allCourses
        return courseDao!!.getCourseFromId(id)
    }

}
