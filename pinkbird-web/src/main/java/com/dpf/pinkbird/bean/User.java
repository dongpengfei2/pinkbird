package com.dpf.pinkbird.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;

    private String username;

    private String password;

    private Boolean stauts;

    private Boolean isDeleted;

    private Date createTime;

    private Date editTime;

    private String creator;

    private String editor;

}