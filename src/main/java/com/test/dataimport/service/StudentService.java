package com.test.dataimport.service;

import com.test.dataimport.model.Student;

import java.util.List;

/**
 * @author leeconnor
 * @date 2018年6月13日09:39:51
 *
 * */
public interface StudentService {
    /** 根据条件查询 */
    List<Student> selectStudentByCondition(Student student);

    /** 插入 */
    void insertStudent(Student student);
}
