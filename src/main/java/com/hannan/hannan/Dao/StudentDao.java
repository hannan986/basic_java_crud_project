package com.hannan.hannan.Dao;

import com.hannan.hannan.Entity.Student;

import java.util.List;

public interface StudentDao {

    public void save(Student student);
    public Student find(int id);

    public List<Student> findAll();

    public void update(Student student);
    public void delete(int id);
}
