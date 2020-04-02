package com.lits.service;

import com.lits.models.Course;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class CourseService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void addCourse(Course course) {
        entityManager.persist(course);
    }

    @Transactional
    public Course findCourse(Long id) {
        return entityManager.find(Course.class, id);
    }

    @Transactional
    public Course updateCourse(Course course) {
        return entityManager.merge(course);
    }

    @Transactional
    public void deleteCourse(Long id) {
        Course course = new Course();
        course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }

    public List<String> getAllCoursesByTeacher(Long teacherId) {
        return entityManager.createQuery("SELECT courseName FROM Course WHERE teacher_id = " + teacherId).getResultList();
    }

    public List<String> getAllCoursesWithoutTeacher() {
        return entityManager.createQuery("SELECT courseName FROM Course WHERE teacher_id = NULL").getResultList();
    }

    @Transactional
    public void updateCourseTeacher(Long courseId, Long teacherId) {
        entityManager.createQuery("UPDATE Course SET teacher_id = " + teacherId + " WHERE id = " + courseId).executeUpdate();
    }

    public List<Long> countCourseByTeacher(Long teacherId) {
        return entityManager.createQuery("SELECT COUNT(courseName) FROM Course WHERE teacher_id = " + teacherId).getResultList();
    }

    public List<Course> getAllCourses() {
        return entityManager.createQuery("SELECT id, courseName, teacher_id FROM Course").getResultList();
    }

}