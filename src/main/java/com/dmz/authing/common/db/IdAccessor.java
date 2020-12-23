package com.dmz.authing.common.db;

/**
 * 继承此接口意味着该对象有数据库主键
 *
 * @author ccc 2019/12/21
 */
public interface IdAccessor {

    Number getId();

}
