package com.test.dataimport.controller;

import com.test.dataimport.model.Student;
import com.test.dataimport.service.StudentService;
import com.test.dataimport.utils.GsonUtil;
import com.test.dataimport.utils.RandomUtils;
import com.test.dataimport.utils.Result;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Level;

@Log
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 查询对应的数据
     * 不使用索引 从百万数据中 根据name查询数据
     * 时间消耗：  13:42:37.602 - 13:42:46.214
     */
    @RequestMapping("/selectStudent")
    public Result selectStudentByCondition(Student student) {
        log.info("start selecet student");
        List<Student> students = studentService.selectStudentByCondition(student);
        String json = GsonUtil.toJson(students);
        log.info("end selecet student");
        return Result.getSuccessResult(json);
    }

    /**
     * 插入Student
     * 顺序遍历插入百万数据
     * 时间消耗  13:08:00 - 13:34:07.236
     */
    @RequestMapping("/addStudent")
    public Result insertStudent() {
        log.info("write data begining");
        StringBuilder errorMessage = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
            try {
                Student student = new Student();
                log.info("write on num:  " + i);
                student.setAge(i);
                student.setName(RandomUtils.getRandomString(RandomUtils.LETTER, 4));
                student.setAge(i);
                student.setSex("man");
                student.setPhone(RandomUtils.getRandomString(RandomUtils.NUMBERS, 11));
                studentService.insertStudent(student);
            } catch (Exception e) {
                log.warning("insert No." + i + " data is error !! ");
                errorMessage.append("\"insert No.\" + i + \" data is error !! \"");
            }
        }
        log.info("write data end");
        return Result.getSuccessResult(errorMessage.toString());
    }


    /**
     * 插入Student
     * 使用线程池插入百万数据
     * 时间消耗
     */
    @RequestMapping("/addStudentWithThreadPool")
    public void addStudentWithThreadPool() {

    }
}
