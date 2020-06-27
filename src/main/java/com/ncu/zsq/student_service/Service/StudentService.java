package com.ncu.zsq.student_service.Service;

import com.ncu.zsq.student_service.Mapper.CourseMapper;
import com.ncu.zsq.student_service.Mapper.StudentMapper;
import com.ncu.zsq.student_service.Pojo.Classes;
import com.ncu.zsq.student_service.Pojo.Course;
import com.ncu.zsq.student_service.Pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private CourseMapper courseMapper;

    public Student getStudent(int id){
       return studentMapper.getStudentById(id);
    }
    public Student getStudent(String name){
        return studentMapper.getStudentByName(name);
    }
    public void addStudent(Student student){
        studentMapper.insertStudent(student);
    }
    public Classes getClasses(int class_id){
        return studentMapper.setClasses(class_id);
    }

    public Course[] getCourses(int stu_id) {
        List<Integer> list = studentMapper.getCoursesId(stu_id);
        Integer[] ints=list.toArray(new Integer[0]);
        Course[] courses=new Course[list.size()];
        for(int i=0;i<list.size();i++){
            courses[i]=courseMapper.getCourseById(ints[i]);
        }

        return courses;
    }

    public void change(Student student) {
        studentMapper.change(student);

    }

    public List<Student> get_all_Stu() {
        return   studentMapper.get_all_Stu();
    }

    public List<Student> get_all_stu(int cls_id) {
        return studentMapper.get_all_stu(cls_id);
    }

    public Classes get_cls(int cls_id) {
        return studentMapper.get_cls(cls_id);
    }

    public void re(int stu_id) {
        studentMapper.re(stu_id);
    }

    public void delete_all_cou(int stu_id){
        studentMapper.delete_all_con(stu_id);

    }
    public void delete_stu(int stu_id){
        delete_all_cou(stu_id);
        studentMapper.delete_stu(stu_id);
    }

    public void delete_cls(int cls_id) {
        List<Student> students=get_all_stu(cls_id);
        students.forEach(e->delete_stu(e.getId()));
        studentMapper.delete_cls(cls_id);

    }
}
