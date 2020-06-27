package com.ncu.zsq.student_service.Service;

import com.ncu.zsq.student_service.Mapper.CourseMapper;
import com.ncu.zsq.student_service.Mapper.TeacherMapper;
import com.ncu.zsq.student_service.Pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private CourseMapper courseMapper;

    public Teacher getTeacher(int id){
        return teacherMapper.getTeacherById(id);
    }
    public Teacher getTeacher(String name){
        return teacherMapper.getTeacherByName(name);
    }
    public void addTeacher(Teacher teacher){
        teacherMapper.addTeacher(teacher);
    }
    public List<DaoClass> getAllClass(){
        List<Classes> classes=teacherMapper.getAllClass();
        System.out.println(classes);
        List<DaoClass> daoClasses=new ArrayList<>();
        classes.forEach(e->{
            System.out.println(e);
            System.out.println("班主任id"+e.getPersident_id());
            Teacher teacher=teacherMapper.getTeacherById(e.getPersident_id());
            DaoClass daoClass=new DaoClass();
            daoClass.setId(e.getId());
            daoClass.setName(e.getName());
            daoClass.setName1(teacher.getName());
            daoClasses.add(daoClass);
        });
        return daoClasses;
    }

    public List<StudentDao> getAllStudent() {
        List<Student> students=teacherMapper.getAllStudent();
        List<StudentDao> studentDaos=new ArrayList<>();
        students.forEach(e->{
            Classes classes=teacherMapper.getClassById(e.getClass_id());
            StudentDao studentDao=new StudentDao();
            studentDao.setClasses(classes);
            studentDao.setStudent(e);
            studentDaos.add(studentDao);

        });
        return studentDaos;
    }

    public List<CourseDao> get_all_course() {
        List<Course> courses=courseMapper.selectAllCourse();
        List<CourseDao> courseDaos=new ArrayList<>();
        courses.forEach(e->{
            Teacher teacher=teacherMapper.getTeacherById(e.getTeather_id());
            CourseDao courseDao=new CourseDao(e,teacher );
            courseDaos.add(courseDao);

        });
        return courseDaos;

    }

    public List<Teacher> get_all_tea() {
       return teacherMapper.get_all_tea();
    }

    public void addClass(Classes classes) {
        teacherMapper.addClass(classes);
    }

    public void changCls(Classes classes) {
        teacherMapper.changeCls(classes);
    }

}
