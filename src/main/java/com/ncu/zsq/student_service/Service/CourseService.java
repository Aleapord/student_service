package com.ncu.zsq.student_service.Service;

import com.ncu.zsq.student_service.Mapper.CourseMapper;
import com.ncu.zsq.student_service.Mapper.StudentMapper;
import com.ncu.zsq.student_service.Pojo.Course;
import com.ncu.zsq.student_service.Pojo.StuDao;
import com.ncu.zsq.student_service.Pojo.Stu_Cou;
import com.ncu.zsq.student_service.Pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CourseService {
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private StudentMapper studentMapper;



    public List<StuDao> get_all_stu_dao(int cuo_id) {
         List<Stu_Cou> stu_cous=courseMapper.get_all_stu(cuo_id);
         List<StuDao> stuDaos=new ArrayList<>();
         stu_cous.forEach(e->{
             Student student=studentMapper.getStudentById(e.getStu_id());
             StuDao stuDao=new StuDao();
             stuDao.setStudent(student);
             stuDao.setScore(e.getScore());
             stuDao.setStatus(e.getStatus());
             stuDaos.add(stuDao);

         });
         return stuDaos;
    }
    public Course get_course(int cou_id){
        return courseMapper.getCourseById(cou_id);

    }
    public List<Course> get_all_cou(){
        return courseMapper.get_all_cau();
    }

    public void change_score(Stu_Cou stu_cou) {
        courseMapper.change_score(stu_cou);
    }

    public void change(Course course) {
        courseMapper.change(course);
    }

    public void delete_cou(int cou_id) {
        courseMapper.delete_stu_cou(cou_id);
        courseMapper.delete_cou(cou_id);
    }

    public void add_cou(Course course) {
        courseMapper.add_cou(course);
    }
}
