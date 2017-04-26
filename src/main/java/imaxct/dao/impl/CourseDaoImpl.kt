package imaxct.dao.impl

import imaxct.dao.ICourseDao
import imaxct.domain.Course
import org.springframework.stereotype.Repository

@Repository
class CourseDaoImpl : BaseDao<Course>(), ICourseDao {

    override fun addCourse(course: Course): Boolean = this.create(course)

    override fun deleteCourse(course: Course): Boolean = this.delete(course)

    override fun updateCourse(course: Course): Boolean = this.update(course)

    override fun getAllCourses(): List<Course> {
        return this.listPage(0, 30,
                "from Course where endDate > NOW() order by id desc")
    }

    override fun getCourseFromId(id: Int): List<Course> {
        return this.listPage(0, 30,
                "from Course where endDate > NOW() and id<? order by id desc", id)
    }

    override fun getCourseById(id: Int): Course = this.find(Course::class.java, id)
}
