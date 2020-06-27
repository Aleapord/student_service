package com.ncu.zsq.student_service.Mapper;

import com.ncu.zsq.student_service.Pojo.Classes;
import com.ncu.zsq.student_service.Pojo.Student;
import com.ncu.zsq.student_service.Pojo.Teacher;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface TeacherMapper {

    @Select("select * from Teacher where id=#{id};")
    Teacher getTeacherById(@Param("id") int id);

    @Select("select * from Teacher where name=#{name};")
    Teacher getTeacherByName(@Param("name") String name);

    @Insert("insert into Teacher(name,password,sex) values(#{tea.name},#{tea.password},#{tea.sex});")
    void addTeacher(@Param("tea") Teacher teacher);

    @Select("select * from Classes;")
    List<Classes> getAllClass();

    @Select("select * from Student")
    List<Student> getAllStudent();

    @Select("select * from Classes where id=#{id}")
    Classes getClassById(@Param("id") int class_id);

    @Select("select * from Teacher")
    List<Teacher> get_all_tea();

    @Insert("insert into Classes(name,persident_id) values(#{cla.name},#{cla.persident_id});")
    void addClass(@Param("cla") Classes classes);

    @Update("update Classes set name=#{cls.name},persident_id=#{cls.persident_id} where id=#{cls.id};")
    void changeCls(@Param("cls") Classes classes);
}
