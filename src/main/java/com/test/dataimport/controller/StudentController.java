package com.test.dataimport.controller;

import com.test.dataimport.model.Student;
import com.test.dataimport.service.StudentService;
import com.test.dataimport.utils.GsonUtil;
import com.test.dataimport.utils.Result;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 查询对应的数据
     * */
    @RequestMapping("/selectStudent")
    public Result selectStudentByCondition(Student student){
        log.info("start selecet student");
        List<Student> students = studentService.selectStudentByCondition(student);
        String json = GsonUtil.toJson(students);
        log.info("end selecet student");
        return Result.getSuccessResult(json);
    }

    /**
     * 插入Student
     * */
    public void insertStudent(Student student){
//        https://github.com/LEEconnor/dataimport.git
    }
}
