package imaxct.dao.impl;

import imaxct.dao.ICourseDao;
import imaxct.domain.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by maxct on 2017/4/9.
 */
@Repository
public class CourseDaoImpl extends BaseDao<Course> implements ICourseDao {

    public boolean addCourse(Course course) {
        return this.create(course);
    }

    public boolean deleteCourse(Course course) {
        return this.delete(course);
    }

    public boolean updateCourse(Course course) {
        return this.update(course);
    }

    public List<Course> getAllCourses() {
        return this.listPage(0, 20, "from Course order by id desc");
    }

    public List<Course> getCourseFromId(int id){
        return this.listPage(0, 20, "from Course where id<? order by id desc", id);
    }
    public Course getCourseById(int id) {
        return this.find(Course.class, id);
    }
}
