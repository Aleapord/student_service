package com.ncu.zsq.student_service.Controller;

import com.ncu.zsq.student_service.Pojo.Student;
import com.ncu.zsq.student_service.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
@RequestMapping("/stu")
public class StuController {
    @Autowired
    StudentService studentService;


    @GetMapping("")
    public String stu_all(){
        return "stu_all.html";
    }

    @GetMapping("/{stu_id}")
    public String stu(){

        return "change_stu.html";
    }
    @PostMapping("/{stu_id}/change")
    @ResponseBody
    public HashMap<String,Object> change(@PathVariable int stu_id, Student student){
        HashMap<String,Object> hashMap=new HashMap<>();
        Student baseStudent=studentService.getStudent(stu_id);
        if (baseStudent==null){
            hashMap.put("msg","用户不存在！");
            hashMap.put("success",0);
        }
            else {
            student.setId(stu_id);
            studentService.change(student);
            hashMap.put("success",1);
        }

        return hashMap;
    }
    @PostMapping("/delete/{stu_id}")
    @ResponseBody
    public HashMap<String,Object> delete_stu(@PathVariable int stu_id){
        studentService.delete_stu(stu_id);
        return new HashMap<>();

    }

    @GetMapping("/add")
    public String add(){
        return "stu_add.html";
    }
    @PostMapping("/add")
    @ResponseBody
    public HashMap<String,Object> add(Student student){
        HashMap<String,Object> hashMap=new HashMap<>();
        Student baseStu=studentService.getStudent(student.getName());
        if(baseStu!=null){
            hashMap.put("success",0);
            hashMap.put("mag","用户名已存在！");
        }
        else {
            studentService.addStudent(student);
            hashMap.put("success",1);

        }
        return hashMap;
    }
}
