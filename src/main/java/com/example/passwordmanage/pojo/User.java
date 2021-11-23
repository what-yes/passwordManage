package com.example.passwordmanage.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName("User")
public class User {

    @TableId(value = "user_id",type = IdType.AUTO)
    private Integer ID;

    @TableField(value="user_name")
    private String name;

    @TableField(value="user_password")
    private String password;

}
