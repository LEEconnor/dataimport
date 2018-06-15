package com.test.dataimport.dao;

import com.test.dataimport.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author leeconnor
 * @date 2018年6月13日09:39:51
 *
 * */
@Repository
public interface StudentDao {

    /** 根据条件查询 */
    List<Student> selectStudentByCondition(Student student);

    /** 插入 */
    void insertStudent(Student student);

}
