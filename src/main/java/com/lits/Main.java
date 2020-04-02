package com.lits;

import com.lits.config.JavaConfig;
import com.lits.models.Course;
import com.lits.models.Teacher;
import com.lits.service.CourseService;
import com.lits.service.TeacherService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);

        TeacherService teacherService = context.getBean(TeacherService.class);
        CourseService courseService = context.getBean(CourseService.class);

        Teacher teacher = new Teacher();
        teacher.setFirstName("Piter");
        teacher.setLastName("Pen");
        teacherService.addTeacher(teacher);

        Teacher teacher1 = new Teacher();
        teacher1.setFirstName("Tom");
        teacher1.setLastName("Cruze");
        teacherService.addTeacher(teacher1);

        Teacher teacher2 = new Teacher();
        teacher2.setFirstName("Donald");
        teacher2.setLastName("Duck");
        teacherService.addTeacher(teacher2);


        Course course = new Course();
        course.setCourseName("Advance");
        course.setTeacher(teacher);
        courseService.addCourse(course);

        Course course1 = new Course();
        course1.setCourseName("Advance IT");
        course1.setTeacher(teacher1);
        courseService.addCourse(course1);

        Course course2 = new Course();
        course2.setCourseName("Advance NEW");
        course2.setTeacher(teacher1);
        courseService.addCourse(course2);

        Course course3 = new Course();
        course3.setCourseName("IT");
        course3.setTeacher(teacher);
        courseService.addCourse(course3);

        Course course4 = new Course();
        course4.setCourseName("HTTP Server");
        course4.setTeacher(teacher2);
        courseService.addCourse(course4);

    }
}
