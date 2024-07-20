package com.project.myapp.dto;

public class AdminDTO {

    private String id;

    public AdminDTO() {
    }

    public AdminDTO(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AdminDTO{" +
                "id='" + id + '\'' +
                '}';
    }
}
