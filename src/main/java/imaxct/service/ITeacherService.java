package imaxct.service;

import imaxct.bean.Msg;
import imaxct.domain.Course;
import imaxct.domain.Department;
import imaxct.domain.StudentCourse;
import imaxct.domain.Teacher;

import java.util.List;

/**
 * Created by maxct on 2017/4/9.
 */
public interface ITeacherService {
    Msg addCourse(Course course);

    Msg rateStudentCourse(StudentCourse studentCourse, double score);
}
