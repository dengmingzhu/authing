package com.dmz.authing.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
public class AuthRole extends BaseEntity implements Serializable {
    @Id
    private String id;
    private String code;
    private String sortCode;
    private String name;
    private String type;
    private String inWorkFlow;
    private String status;
    private String summary;
    @ManyToMany(targetEntity = AuthUser.class, mappedBy = "authRoles")
    private Set<AuthUser> authUsers;

}
