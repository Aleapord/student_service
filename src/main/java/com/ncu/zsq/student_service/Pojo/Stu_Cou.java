package com.ncu.zsq.student_service.Pojo;

public class Stu_Cou {
    private int stu_id;
    private int cou_id;
    private int score;
    private String status;

    public Stu_Cou() {
    }



    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public int getCou_id() {
        return cou_id;
    }

    public void setCou_id(int cou_id) {
        this.cou_id = cou_id;
    }





    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

