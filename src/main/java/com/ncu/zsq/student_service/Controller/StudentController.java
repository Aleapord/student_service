package com.ncu.zsq.student_service.Controller;

import com.ncu.zsq.student_service.Pojo.Classes;
import com.ncu.zsq.student_service.Pojo.Course;
import com.ncu.zsq.student_service.Pojo.Student;
import com.ncu.zsq.student_service.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/student/")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("{stu_id}")
    public String stuHome(@PathVariable int stu_id){
        System.out.println("学生id"+stu_id);
        return "student.html";
    }

    @PostMapping("{stu_id}/get_all_inf")
    @ResponseBody
    public HashMap<String,Object> getAllInf(@PathVariable int stu_id){
        HashMap<String,Object> hashMap = new HashMap<>();
        Student student=studentService.getStudent(stu_id);
        hashMap.put("student",student);

        Classes classes=studentService.getClasses(student.getClass_id());
        hashMap.put("my_classes",classes);

        Course[] courses=studentService.getCourses(stu_id);
        hashMap.put("my_courses",courses);


        return hashMap;
    }


}
