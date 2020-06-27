package com.ncu.zsq.student_service.Mapper;

import com.ncu.zsq.student_service.Pojo.Classes;
import com.ncu.zsq.student_service.Pojo.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface StudentMapper {
    @Select("select * from Student where id=#{id};")
    Student getStudentById(@Param("id") int id);

    @Select("select * from Student where name=#{name};")
    Student getStudentByName(@Param("name") String name);

    @Insert("insert into Student(name,password,sex,total_creadits) values(#{stu.name},#{stu.password},#{stu.sex},#{stu.credits});")
    void insertStudent(@Param("stu") Student student);
    @Select("select * from Classes where id=#{id};")
    Classes setClasses(@Param("id") int class_id);

    @Select("select cou_id from Stu_Cou where stu_id=#{id};")
    List<Integer> getCoursesId(@Param("id") int stu_id);

    @Update("update Student set name=#{stu.name} , sex=#{stu.sex},class_id=#{stu.class_id},total_creadits=#{stu.total_creadits} where id=#{stu.id};;")
    void change(@Param("stu") Student student);

    @Select("select * from Student")
    List<Student> get_all_Stu();

    @Select("select * from Student where class_id=#{id};")
    List<Student> get_all_stu(@Param("id") int cls_id);

    @Select("select * from Classes where id=#{id};")
    Classes get_cls(@Param("id") int cls_id);

    @Update("update Student set class_id=3 where id=#{id};")
    void re(@Param("id") int id);

    @Delete("delete from Stu_Cou where stu_id=#{id};")
    void delete_all_con(@Param("id") int stu_id);

    @Delete("delete from Student where id=#{id};" )
    void delete_stu(@Param("id") int stu_id);

    @Delete("delete from Classes where id=#{id};")
    void delete_cls(@Param("id") int cls_id);
}
