package com.example.passwordmanage.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName("Account")
public class Account {

    @TableId(value = "account_id",type = IdType.AUTO)
    private Integer aId;

    @TableField(value = "app_name")
    private String app;

    @TableField(value = "app_account")
    private String account;

    @TableField(value = "app_password")
    private String password;

    @TableField(value = "user_id")
    private Integer uId;




}
