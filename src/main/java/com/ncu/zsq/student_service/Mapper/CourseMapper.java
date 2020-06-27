package com.ncu.zsq.student_service.Mapper;

import com.ncu.zsq.student_service.Pojo.Course;
import com.ncu.zsq.student_service.Pojo.Stu_Cou;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface CourseMapper {

    @Select("select * from Course where id=#{id};")
    Course getCourseById(@Param("id") int anInt);

    @Select("select * from Course")
    List<Course> selectAllCourse();

    @Select("select * from Stu_Cou where cou_id=#{id};")
    List<Stu_Cou> get_all_stu(@Param("id") int cuo_id);

    @Select("select * from Course")
    List<Course> get_all_cau();

    @Update("update Sto_Cou set score=#{sc.score} where stu_id=#{sc.stu_id} and cou_id=#{cou_id};")
    void change_score(@Param("sc") Stu_Cou stu_cou);

    @Update("update Course set name={c.name},teather_id=#{c.teather_id},period=#{c.period},credit=#{credit};")
    void change(@Param("c") Course course);

    @Delete("delete from Stu_Cou where cou_id=#{id};")
    void delete_stu_cou(@Param("id") int cou_id);

    @Delete("delete from Course where id=#{id};")
    void delete_cou(@Param("id") int cou_id);

    @Insert("insert into Course (name,teather_id,period,credit) value(#{c.name},#{c.teather_id},#{c.period},#{c.credit});")
    void add_cou(Course course);
}
