package com.ncu.zsq.student_service.Controller;

import com.ncu.zsq.student_service.Exts.PasswordUnit;
import com.ncu.zsq.student_service.Exts.UserLoginToken;
import com.ncu.zsq.student_service.Pojo.Character;
import com.ncu.zsq.student_service.Pojo.Student;
import com.ncu.zsq.student_service.Pojo.Teacher;
import com.ncu.zsq.student_service.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.security.provider.SHA;

import java.awt.*;
import java.util.HashMap;

@Controller
public class MainController {

    @Autowired
    private PasswordUnit passwordUnit;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private CourseService courseService;


    @RequestMapping("/")
    public String index(){

        return "login.html";
    }

    @PostMapping("/login")
    @ResponseBody
    public HashMap<String,Object> login(String username,String password,String character){
        HashMap<String,Object> hashMap=new HashMap<>();
        if (character.equals("S")){
            Student baseStudent=studentService.getStudent(username);
            if(baseStudent==null) {
                hashMap.put("success",0);
                hashMap.put("msg","用户名不存在！");
            }else {
            String SHA1=passwordUnit.hash(password);
                System.out.println(SHA1);
            if(!SHA1.equals(baseStudent.getPassword())){
                hashMap.put("success",0);
                hashMap.put("msg","密码错误！");
            }else {
                String token = tokenService.getToken(baseStudent);
                hashMap.put("success", 1);
                hashMap.put("token", token);
                hashMap.put("user",baseStudent);
            } }}else {
            Teacher baseTeacher=teacherService.getTeacher(username);
            if(baseTeacher==null) {
                hashMap.put("success",0);
                hashMap.put("msg","用户名不存在！");
            }else {
            String SHA1=passwordUnit.hash(password);
                System.out.println(SHA1);
            if(!SHA1.equals(baseTeacher.getPassword())){
                hashMap.put("success",0);
                hashMap.put("msg","密码错误！");
            }else {
                String token = tokenService.getToken(baseTeacher);
                hashMap.put("success", 1);
                hashMap.put("token", token);
                hashMap.put("user",baseTeacher);

            }} }
        return hashMap;
    }

    @RequestMapping("/register")
    public String reg(){
        return "register.html";
    }


    @PostMapping("/reg")
    @ResponseBody
    public HashMap<String,Object> register(String username,String password,String character,String gender){
        HashMap<String,Object> hashMap=new HashMap<>();


            if (character.equals("S")){
                Student baseCharacter=studentService.getStudent(username);
                if (baseCharacter!=null){
                    hashMap.put("success",0);
                    hashMap.put("msg","用户名已存在！");
                }else {
                System.out.println(password);
                String SHA1=passwordUnit.hash(password);
                System.out.println(SHA1);
                Student student=new Student();
                student.setName(username);
                student.setPassword(SHA1);
                student.setSex(gender);
                studentService.addStudent(student);
                hashMap.put("success",1);

            }}
            else {
                Teacher baseCharacter=teacherService.getTeacher(username);
                if (baseCharacter!=null){
                    hashMap.put("success",0);
                    hashMap.put("msg","用户名已存在！");
                }else {
                    System.out.println(password);
                    String SHA1=passwordUnit.hash(password);
                    System.out.println(SHA1);
                    Teacher teacher=new Teacher();
                    teacher.setSex(gender);
                    teacher.setName(username);
                    teacher.setPassword(SHA1);
                    teacherService.addTeacher(teacher);
                    hashMap.put("success",1);
                }
            }

        return hashMap;
    }
    @PostMapping("/get_all_classes")
    @ResponseBody
    public HashMap<String,Object > get_all_classes(){
        HashMap<String,Object> hashMap =new HashMap<>();
        hashMap.put("all_class",teacherService.getAllClass());
        return hashMap;

    }
    @PostMapping("/get_all_student")
    @ResponseBody
    public HashMap<String,Object > get_all_student(){
        HashMap<String,Object> hashMap =new HashMap<>();
        hashMap.put("all_stu",teacherService.getAllStudent());
        return hashMap;

    }
    @PostMapping("/get_all_course")
    @ResponseBody
    public HashMap<String,Object > get_all_course(){
        HashMap<String,Object> hashMap =new HashMap<>();
        hashMap.put("all_course",teacherService.get_all_course());
        return hashMap;

    }
    @PostMapping("/get_stu/{stu_id}")
    @ResponseBody
    public HashMap<String,Object > get_stu(@PathVariable int stu_id){
        HashMap<String,Object> hashMap =new HashMap<>();
        hashMap.put("stu",studentService.getStudent(stu_id));
        return hashMap;

    }
    @PostMapping("/get_all_tea")
    @ResponseBody
    public HashMap<String,Object > get_all_tea(){
        HashMap<String,Object> hashMap =new HashMap<>();
        hashMap.put("all_tea",teacherService.get_all_tea());
        return hashMap;

    }
    @PostMapping("/get_all_Stu")
    @ResponseBody
    public HashMap<String,Object > get_all_Stu(){
        HashMap<String,Object> hashMap =new HashMap<>();
        hashMap.put("all_Stu",studentService.get_all_Stu());
        return hashMap;

    }
    @PostMapping("/get_all_stu/{cls_id}")
    @ResponseBody
    public HashMap<String,Object > get_all_stu(@PathVariable int cls_id){
        HashMap<String,Object> hashMap =new HashMap<>();
        hashMap.put("all_stu",studentService.get_all_stu(cls_id));
        return hashMap;

    }
    @PostMapping("/get_cls/{cls_id}")
    @ResponseBody
    public HashMap<String,Object > get_cls(@PathVariable int cls_id){
        HashMap<String,Object> hashMap =new HashMap<>();
        hashMap.put("cls",studentService.get_cls(cls_id));
        return hashMap;

    }
    @PostMapping("/re_stu/{cls_id}/{stu_id}")
    @ResponseBody
    public HashMap<String,Object > re_stu(@PathVariable int cls_id,@PathVariable int stu_id){
        HashMap<String,Object> hashMap =new HashMap<>();
        studentService.re(stu_id);
        hashMap.put("success",1);
        return hashMap;

    }
    @PostMapping("/get_cou/{cou_id}")
    @ResponseBody
    public HashMap<String,Object > get_cou(@PathVariable int cou_id){
        HashMap<String,Object> hashMap =new HashMap<>();
        hashMap.put("cou",courseService.get_course(cou_id));
        return hashMap;

    }
    @PostMapping("/get_all_cou/")
    @ResponseBody
    public HashMap<String,Object > get_all_cou(){
        HashMap<String,Object> hashMap =new HashMap<>();
        hashMap.put("all_cou",courseService.get_all_cou());
        return hashMap;

    }

}
