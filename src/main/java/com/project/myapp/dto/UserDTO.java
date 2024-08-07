package com.project.myapp.dto;

public class UserDTO {

    private String id;
    private String password;
    private String nickName;
    private String email;
    private String type;
    private String status;
    private String profile;

    public UserDTO() {
    }

    public UserDTO(String id, String password, String nickName, String email) {
        this.id = id;
        this.password = password;
        this.nickName = nickName;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", nickName='" + nickName + '\'' +
                ", email='" + email + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", profile='" + profile + '\'' +
                '}';
    }
}
