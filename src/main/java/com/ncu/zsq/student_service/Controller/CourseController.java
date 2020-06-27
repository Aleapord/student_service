package com.ncu.zsq.student_service.Controller;

import com.ncu.zsq.student_service.Pojo.Course;
import com.ncu.zsq.student_service.Pojo.StuDao;
import com.ncu.zsq.student_service.Pojo.Stu_Cou;
import com.ncu.zsq.student_service.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/cou/")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("")
    public String cou(){
        return "cou.html";
    }

    @GetMapping("{cou_id}")
    public String cou_detail(){
        return "cou_all.html";
    }
    @PostMapping("get_all_stu/{cuo_id}")
    @ResponseBody
    public HashMap<String,Object> getAllStu(@PathVariable int cuo_id){
        HashMap<String,Object> hashMap=new HashMap<>();
        List<StuDao> stuDaos= courseService.get_all_stu_dao(cuo_id);
        hashMap.put("all_stu",stuDaos);
        return hashMap;
    }

    @PostMapping("change")
    @ResponseBody
    public HashMap<String,Object> change(Stu_Cou stu_cou){
        HashMap<String,Object> hashMap=new HashMap<>();
        courseService.change_score(stu_cou);
        return hashMap;


    }

    @PostMapping("change/{cou_id}")
    @ResponseBody
    public HashMap<String,Object> change(Course course){
            courseService.change(course);
            return new HashMap<>();
    }
    @PostMapping("delete/{cou_id}")
    @ResponseBody
    public HashMap<String,Object> delete_cou(@PathVariable int cou_id){
        courseService.delete_cou(cou_id);
        return new HashMap<>();
    }

    @GetMapping("add")
    public String add(){
        return "cou_add.html";
    }
    @PostMapping("add")
    public HashMap<String,Object> add(Course course){
        courseService.add_cou(course);
        return new HashMap<>();
    }
}
