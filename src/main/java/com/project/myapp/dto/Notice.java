package com.project.myapp.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class Notice {
    private long id;
    private String title;
    private String content;
    private String who;
    private Date create_date;
    private Date update_date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notice notice = (Notice) o;
        return id == notice.id && Objects.equals(title, notice.title) && Objects.equals(content, notice.content) && Objects.equals(who, notice.who);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, who);
    }

    public Notice() {
    }

    public Notice(long id, String title, String content, String who, Date create_date, Date update_date) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.who = who;
        this.create_date = create_date;
        this.update_date = update_date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", who='" + who + '\'' +
                ", create_date=" + create_date +
                ", update_date=" + update_date +
                '}';
    }
}
