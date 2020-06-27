package com.ncu.zsq.student_service.Service;

import com.ncu.zsq.student_service.Mapper.StudentMapper;
import com.ncu.zsq.student_service.Mapper.TeacherMapper;
import com.ncu.zsq.student_service.Pojo.Character;
import com.ncu.zsq.student_service.Pojo.Teacher;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private TeacherMapper teacherMapper;

    public Character getCharacter(String name){
        Character character=null;
        character=teacherMapper.getTeacherByName(name);
        if (character==null)
            character=studentMapper.getStudentByName(name);
        return character;

    }

}
