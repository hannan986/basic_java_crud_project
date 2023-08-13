package com.hannan.hannan.Dao;

import com.hannan.hannan.Entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl  implements  StudentDao{
    EntityManager entityManager;

    @Autowired
    public StudentDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    @Transactional
    public void save(Student student) {
    entityManager.persist(student);
    }

    @Override
    public Student find(int id){
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll(){
        TypedQuery<Student> thisQuery = entityManager.createQuery("from Student",Student.class);
        return thisQuery.getResultList();

    }

    @Transactional
    @Override
    public void update(Student student){
        entityManager.merge(student);
    }

    @Transactional
    @Override
    public void delete(int id){
        Student student =  entityManager.find(Student.class,id);
        entityManager.remove(student);

    }

}
