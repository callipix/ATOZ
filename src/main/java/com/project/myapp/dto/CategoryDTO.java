package com.project.myapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CategoryDTO {

    private int categoryNo;
    private String categoryName;
    private int categoryPickBno;

}
