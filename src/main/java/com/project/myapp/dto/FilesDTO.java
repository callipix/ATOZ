package com.project.myapp.dto;

import java.sql.Timestamp;
import java.util.Objects;

public class FilesDTO {

    private int file_no;                        // 파일번호 -> DB에서 auto_increment
    private String original_name;               // 파일의 오리지날명
    private String stored_name;                 // UUID로 생성한 파일명
    private String file_type;                   // 파일의 타입(여기선 이미지 파일 종류)
    private long file_size;                      // 파일사이즈
    private String file_path;                   // 파일 경로
    private Timestamp uploaded_at;                // 업로드 날짜
    private String id;                          // 업로드 id
    private String associated_object_id;

    public FilesDTO(){}

    public FilesDTO(int file_no, String original_name, String stored_name, String file_type, long file_size, String file_path, String id, String associated_object_id) {
        this.file_no = file_no;
        this.original_name = original_name;
        this.stored_name = stored_name;
        this.file_type = file_type;
        this.file_size = file_size;
        this.file_path = file_path;
        this.id = id;
        this.associated_object_id = associated_object_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilesDTO filesDTO = (FilesDTO) o;
        return file_no == filesDTO.file_no && Objects.equals(original_name, filesDTO.original_name) && Objects.equals(stored_name, filesDTO.stored_name) && Objects.equals(file_type, filesDTO.file_type) && Objects.equals(file_size, filesDTO.file_size) && Objects.equals(file_path, filesDTO.file_path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(file_no, original_name, stored_name, file_type, file_size, file_path);
    }

    public String getOriginal_name() {
        return original_name;
    }

    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
    }

    public int getFile_no() {
        return file_no;
    }

    public void setFile_no(int file_no) {
        this.file_no = file_no;
    }

    public String getStored_name() {
        return stored_name;
    }

    public void setStored_name(String stored_name) {
        this.stored_name = stored_name;
    }

    public String getFile_type() {
        return file_type;
    }

    public void setFile_type(String file_type) {
        this.file_type = file_type;
    }

    public long getFile_size() {
        return file_size;
    }

    public void setFile_size(long file_size) {
        this.file_size = file_size;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    public Timestamp getUploaded_at() {
        return uploaded_at;
    }

    public void setUploaded_at(Timestamp uploaded_at) {
        this.uploaded_at = uploaded_at;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAssociated_object_id() {
        return associated_object_id;
    }

    public void setAssociated_object_id(String associated_object_id) {
        this.associated_object_id = associated_object_id;
    }

    @Override
    public String toString() {
        return "FilesDTO{" +
                "file_no=" + file_no +
                ", original_name='" + original_name + '\'' +
                ", stored_name='" + stored_name + '\'' +
                ", file_type='" + file_type + '\'' +
                ", file_size='" + file_size + '\'' +
                ", file_path='" + file_path + '\'' +
                ", uploaded_at='" + uploaded_at + '\'' +
                ", id='" + id + '\'' +
                ", associated_object_id='" + associated_object_id + '\'' +
                '}';
    }
}
