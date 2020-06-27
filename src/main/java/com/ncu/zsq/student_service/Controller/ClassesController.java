package com.ncu.zsq.student_service.Controller;

import com.ncu.zsq.student_service.Pojo.Classes;
import com.ncu.zsq.student_service.Pojo.Teacher;
import com.ncu.zsq.student_service.Service.StudentService;
import com.ncu.zsq.student_service.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;

@Controller
@RequestMapping("/classes/")
public class ClassesController {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;

    @GetMapping("{cls_id}")
    public String cls(){
        return "claass.html";
    }

    @PostMapping("/delete/{cls_id}")
    @ResponseBody
    public HashMap<String,Object> delete_cls(@PathVariable int cls_id){
        studentService.delete_cls(cls_id);
        return new HashMap<>();
    }

    @GetMapping("add")
    public String addClasses(){
        return "addClass.html";
    }

    @PostMapping("add")
    @ResponseBody
    public HashMap<String,Object> cls(Classes classes){
        HashMap<String,Object> hashMap =new HashMap<>();
        teacherService.addClass(classes);
        hashMap.put("msg","success");

        return hashMap;
    }
    @PostMapping("change")
    @ResponseBody
    public HashMap<String,Object> change( Classes classes){
        teacherService.changCls(classes);
        HashMap<String,Object> hashMap =new HashMap<>();
        return hashMap;

    }

}
