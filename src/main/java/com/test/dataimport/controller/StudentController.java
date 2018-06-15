package com.test.dataimport.controller;

import com.test.dataimport.model.Student;
import com.test.dataimport.service.StudentService;
import com.test.dataimport.utils.GsonUtil;
<<<<<<< HEAD
import com.test.dataimport.utils.RandomUtils;
=======
>>>>>>> 13814c3e45a326d77b184b0127113a2329962ad3
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
<<<<<<< HEAD
     * 不使用索引 从百万数据中 根据name查询数据
     * 时间消耗：  13:42:37.602 - 13:42:46.214
=======
>>>>>>> 13814c3e45a326d77b184b0127113a2329962ad3
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
<<<<<<< HEAD
     * 顺序遍历插入百万数据
     * 时间消耗  13:08:00 - 13:34:07.236
     * */
    @RequestMapping("/addStudent")
    public void insertStudent(){
        log.info("write data begining");
        Student student = new Student();
        for(int i = 0 ; i < 1000000 ; i++){
            log.info("write on num:  " + i);
            student.setAge(i);
            student.setName(RandomUtils.getRandomName());
            student.setAge(i);
            student.setSex("man");
            student.setPhone(RandomUtils.getRandomPhone());
            studentService.insertStudent(student);
        }
        log.info("write data end");
    }


    /**
     * 插入Student
     * 使用线程池插入百万数据
     * 时间消耗  13:08:00 - 13:34:07.236
     * */
    @RequestMapping("/addStudentWithThreadPool")
    public void addStudentWithThreadPool(){

=======
     * */
    public void insertStudent(Student student){
//        https://github.com/LEEconnor/dataimport.git
>>>>>>> 13814c3e45a326d77b184b0127113a2329962ad3
    }
}
