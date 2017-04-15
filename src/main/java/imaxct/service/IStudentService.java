package imaxct.service;

import imaxct.bean.Msg;
import imaxct.domain.Course;
import imaxct.domain.Student;
import imaxct.domain.StudentCourse;

import java.util.List;

/**
 * Created by maxct on 2017/4/9.
 */
public interface IStudentService {
    Msg<List<StudentCourse>> getSchedule(Student student);

    Msg addCourse(Student student, Course course);

    Msg deleteCourse(Student student, Course course);

    Msg<List<StudentCourse>> getScore(Student student);
}
