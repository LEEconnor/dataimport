package com.test.dataimport.manager.impl;

import com.test.dataimport.dao.StudentDao;
import com.test.dataimport.manager.StudentManager;
import com.test.dataimport.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentManagerImpl implements StudentManager{

    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> selectStudentByCondition(Student student) {
        return studentDao.selectStudentByCondition(student);
    }

    @Override
    public void insertStudent(Student student) {
<<<<<<< HEAD
        studentDao.insertStudent(student);
=======

>>>>>>> 13814c3e45a326d77b184b0127113a2329962ad3
    }
}
