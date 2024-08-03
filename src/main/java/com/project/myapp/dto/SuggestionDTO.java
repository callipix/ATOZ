package com.project.myapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@ToString
public class SuggestionDTO {

    private int sno;
    private String writer;
    private String password;
    private String content;
    private Date regDate;
    private Date upDate;

}
