CREATE TABLE `s_user`
(
    `id`         int(10)      NOT NULL AUTO_INCREMENT,
    `username`   varchar(20)  NOT NULL,
    `password`   varchar(255) NOT NULL,
    `nickname`   varchar(20) DEFAULT NULL,
    `gmt_create` datetime     NOT NULL,
    `gmt_update` datetime     NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `uniq_username` (`username`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
