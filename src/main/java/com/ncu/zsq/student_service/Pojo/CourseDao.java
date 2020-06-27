package com.ncu.zsq.student_service.Pojo;

public class CourseDao {
    private Course course;
    private Teacher teacher;

    public CourseDao() {
    }

    public CourseDao(Course course, Teacher teacher) {
        this.course = course;
        this.teacher = teacher;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
