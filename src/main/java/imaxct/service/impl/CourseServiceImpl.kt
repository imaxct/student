package imaxct.service.impl

import imaxct.bean.Msg
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
    override fun updateCourse(course: Course): Boolean = this.courseDao!!.updateCourse(course)

    override fun getCourseById(id: Int): Course? = this.courseDao!!.getCourseById(id)

    override fun addCourse(course: Course): Msg<*> {
        if (courseDao!!.addCourse(course))
            return Msg(0, "ok", null)
        return Msg(-1, "添加失败.", null)
    }

    override fun deleteCourse(course: Course): Msg<*> {
        if (courseDao!!.deleteCourse(course))
            return Msg(0, "ok", null)
        return Msg(-1, "删除失败.", null)
    }

    override fun getAllCourses(id: Int): Msg<List<Course>> {
        if (id == -1)
            return Msg(0, "ok", this.courseDao!!.getAllCourses())
        return Msg(0, "ok", this.courseDao!!.getCourseFromId(id))
    }

}
