drop table if exists auth_user;
create table auth_user
(
    id           int(10) not null auto_increment comment '用户id',
    code         varchar(32) comment '用户代码',
    username     varchar(128) comment '用户名',
    password     varchar(255) comment '密码',
    salt         varchar(32) comment '密码盐值',
    avatar       varchar(32) comment '头像',
    org_id       varchar(32) comment '机构',
    email        varchar(32) comment '邮件',
    phone        varchar(32) comment '手机号',
    status       varchar(32) comment '状态',
    revision     int comment '乐观锁',
    created_by   varchar(32) comment '创建人',
    created_time datetime comment '创建时间',
    updated_by   varchar(32) comment '更新人',
    updated_time datetime comment '更新时间',
    primary key (id)
) comment = '用户信息 ';;

alter table auth_user
    comment '用户信息';;
drop table if exists auth_user_account;;/*skiperror*/
create table auth_user_account
(
    id           int(10) not null auto_increment comment '账号id',
    user_id      varchar(32) comment '用户id',
    account_code varchar(32) comment '账号代号',
    password     varchar(32) comment '账号密码',
    account_type varchar(32) comment '账号类型',
    status       varchar(32) comment '账号状态',
    revision     int comment '乐观锁',
    created_by   varchar(32) comment '创建人',
    created_time datetime comment '创建时间',
    updated_by   varchar(32) comment '更新人',
    updated_time datetime comment '更新时间',
    primary key (id)
) comment = '用户账号 ';;

alter table auth_user_account
    comment '用户账号';;
drop table if exists auth_user_behavior;;/*skiperror*/
create table auth_user_behavior
(
    id           int(10) comment '记录流水号',
    user_id      varchar(32) comment '用户号',
    object_type  varchar(32) comment '关联对象类型',
    object_id    varchar(32) comment '关联对象号',
    type         varchar(32) comment '行为类型',
    value        varchar(32) comment '行为数值',
    intro        varchar(512) comment '行为说明',
    revision     int comment '乐观锁',
    created_by   varchar(32) comment '创建人',
    created_time datetime comment '创建时间',
    updated_by   varchar(32) comment '更新人',
    updated_time datetime comment '更新时间',
    primary key (id)
) comment = '用户行为 ';;

alter table auth_user_behavior
    comment '用户行为';;
drop table if exists auth_user_property;;/*skiperror*/
create table auth_user_property
(
    id           int(10) comment '属性id',
    user_id      varchar(32) comment '用户id',
    name         varchar(32) comment '属性名',
    value        varchar(1024) comment '属性值',
    revision     int comment '乐观锁',
    created_by   varchar(32) comment '创建人',
    created_time datetime comment '创建时间',
    updated_by   varchar(32) comment '更新人',
    updated_time datetime comment '更新时间',
    primary key (id)
) comment = '用户属性 ';;

alter table auth_user_property
    comment '用户属性';;
drop table if exists auth_org;;/*skiperror*/
create table auth_org
(
    id           int(10) comment '机构id',
    code         varchar(32) comment '机构代号',
    name         varchar(128) comment '机构名',
    full_name    varchar(128) comment '机构路径全称',
    short_name   varchar(128) comment '机构简称',
    sort_code    varchar(32) comment '排序代码',
    parent_id    varchar(32) comment '上级机构',
    level        varchar(32) comment '机构级别',
    org_type     varchar(32) comment '机构类型',
    leader       varchar(32) comment '负责人',
    remark       varchar(512) comment '机构说明',
    revision     int comment '乐观锁',
    created_by   varchar(32) comment '创建人',
    created_time datetime comment '创建时间',
    updated_by   varchar(32) comment '更新人',
    updated_time datetime comment '更新时间',
    primary key (id)
) comment = '部门机构 ';;

alter table auth_org
    comment '部门机构';;
drop table if exists auth_org_property;;/*skiperror*/
create table auth_org_property
(
    id           int(10) comment '属性id',
    org_id       int(32) comment '机构id',
    name         varchar(32) comment '属性名称',
    value        varchar(1024) comment '属性值',
    revision     int comment '乐观锁',
    created_by   varchar(32) comment '创建人',
    created_time datetime comment '创建时间',
    updated_by   varchar(32) comment '更新人',
    updated_time datetime comment '更新时间',
    primary key (id)
) comment = '机构属性 ';;

alter table auth_org_property
    comment '机构属性';;
drop table if exists auth_user_role;;/*skiperror*/
create table auth_user_role
(
    id            varchar(32) comment '职责id',
    org_id        int(10) comment '机构id',
    role_id       int(10) comment '角色id',
    user_id       int(32) comment '用户id',
    position_type varchar(32) comment '岗位类型',
    revision      int comment '乐观锁',
    created_by    varchar(32) comment '创建人',
    created_time  datetime comment '创建时间',
    updated_by    varchar(32) comment '更新人',
    updated_time  datetime comment '更新时间',
    primary key (id)
) comment = '用户角色 ';;

alter table auth_user_role
    comment '用户角色';;
drop table if exists auth_role;;/*skiperror*/
create table auth_role
(
    id           int(10) comment '角色id',
    code         varchar(32) comment '角色代码',
    sort_code    varchar(128) comment '排序代码',
    name         varchar(128) comment '角色名',
    type         varchar(32) comment '角色类型',
    in_work_flow varchar(1) comment '是否应用于工作流',
    status       varchar(32) comment '角色状态',
    summary      varchar(512) comment '角色描述',
    revision     int comment '乐观锁',
    created_by   varchar(32) comment '创建人',
    created_time datetime comment '创建时间',
    updated_by   varchar(32) comment '更新人',
    updated_time datetime comment '更新时间',
    primary key (id)
) comment = '角色信息 ';;

alter table auth_role
    comment '角色信息';;
drop table if exists auth_permit;;/*skiperror*/
create table auth_permit
(
    code         varchar(128) comment '权限代码',
    id           int(10) comment '权限id',
    name         varchar(128) comment '权限名称',
    revision     int comment '乐观锁',
    created_by   varchar(32) comment '创建人',
    created_time datetime comment '创建时间',
    updated_by   varchar(32) comment '更新人',
    updated_time datetime comment '更新时间',
    primary key (id)
) comment = '权限信息 自定义权限';;

alter table auth_permit
    comment '权限信息';;
drop table if exists auth_role_permit;;/*skiperror*/
create table auth_role_permit
(
    id           int(10) comment '流水号',
    role_id      int(10) comment '角色id',
    permit_code  varchar(32) comment '权限代码',
    revision     int comment '乐观锁',
    created_by   varchar(32) comment '创建人',
    created_time datetime comment '创建时间',
    updated_by   varchar(32) comment '更新人',
    updated_time datetime comment '更新时间',
    primary key (id)
) comment = '角色权限 ';;

alter table auth_role_permit
    comment '角色权限';;
drop table if exists auth_user_permit;;/*skiperror*/
create table auth_user_permit
(
    id           int(10) comment '流水号',
    user_id     int(10) comment '用户id',
    permit_code  varchar(32) comment '权限代码',
    revision     int comment '乐观锁',
    created_by   varchar(32) comment '创建人',
    created_time datetime comment '创建时间',
    updated_by   varchar(32) comment '更新人',
    updated_time datetime comment '更新时间',
    primary key (id)
) comment = '用户直接权限 ';;

alter table auth_user_permit
    comment '用户直接权限';;
