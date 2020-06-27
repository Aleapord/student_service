package com.ncu.zsq.student_service.Pojo;

public class Classes {
    private int id;
    private String name;
    private int persident_id;

    public Classes() {
    }

    public Classes(int id, String name, int persident_id) {
        this.id = id;
        this.name = name;
        this.persident_id = persident_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPersident_id() {
        return persident_id;
    }

    public void setPersident_id(int persident_id) {
        this.persident_id = persident_id;
    }
}
