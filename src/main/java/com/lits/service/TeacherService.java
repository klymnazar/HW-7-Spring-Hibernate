package com.lits.service;

import com.lits.models.Teacher;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class TeacherService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void addTeacher(Teacher teacher) {
        entityManager.persist(teacher);
    }

    @Transactional
    public Teacher findTeacher(Long id) {
        return  entityManager.find(Teacher.class, id);
    }

    @Transactional
    public Teacher updateTeacher(Teacher teacher) {
        return entityManager.merge(teacher);
    }

    @Transactional
    public void deleteTeacher(Long id) {
        Teacher teacher = new Teacher();
        teacher = entityManager.find(Teacher.class, id);
        entityManager.remove(teacher);
    }

    public List<Teacher> getAllTeachers() {
        return entityManager.createQuery("SELECT id, firstName, lastName FROM Teacher").getResultList();
    }

}