package com.dmz.authing.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class AuthUser extends BaseEntity implements Serializable {
    @Id
    private String id;
    private String code;
    private String username;
    private String password;
    private String salt;
    private String avatar;
    private String orgId;
    private String email;
    private String phone;
    private String status;

}
