package com.project.myapp.dto;

import java.util.Objects;

public class MemberDTO {

    private String id;
    private String name;
    private String phoneNo;
    private String zipcode;
    private String addressNormal;
    private String addressDetail;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberDTO memberDTO = (MemberDTO) o;
        return Objects.equals(id, memberDTO.id) && Objects.equals(name, memberDTO.name) && Objects.equals(phoneNo, memberDTO.phoneNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phoneNo);
    }

    public MemberDTO() {
    }

    public MemberDTO(String id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phoneNo = phoneNo;
    }

    public MemberDTO(String id, String name, String phoneNo, String zipcode, String addressNormal, String addressDetail) {
        this.id = id;
        this.name = name;
        this.phoneNo = phoneNo;
        this.zipcode = zipcode;
        this.addressNormal = addressNormal;
        this.addressDetail = addressDetail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getAddressNormal() {
        return addressNormal;
    }

    public void setAddressNormal(String addressNormal) {
        this.addressNormal = addressNormal;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", addressNormal='" + addressNormal + '\'' +
                ", addressDetail='" + addressDetail + '\'' +
                '}';
    }
}
