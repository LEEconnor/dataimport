package com.test.dataimport.service.impl;

import com.test.dataimport.manager.StudentManager;
import com.test.dataimport.model.Student;
import com.test.dataimport.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author  leeconnor
 * @date 2018年6月13日10:36:50
 * */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentManager studentManager;

    @Override
    public List<Student> selectStudentByCondition(Student student) {
        return studentManager.selectStudentByCondition(student);
    }

    @Override
    public void insertStudent(Student student) {
        studentManager.insertStudent(student);
    }

}
