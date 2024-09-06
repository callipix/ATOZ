package com.project.myapp.dto;

import lombok.*;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserAuth {

    private String id;
    private String auth;

    public UserAuth(String id) {
        this.id = id;
    }
}
