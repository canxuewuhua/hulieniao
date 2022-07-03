package com.hln.service.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 设置数据库密码
 * ALTER USER 'root'@'localhost' IDENTIFIED WITH MYSQL_NATIVE_PASSWORD BY '123456';
 */
@Service
public class UserService2 {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * REQUIRED 如果当前存在事务 则加入该事务；如果当前没有事务 则创建一个事务
     * REQUIRES_NEW 创建一个新的事务；如果当前存在事务，则把当前事务挂起
     * NESTED  如果当前存在事务，则创建一个事务作为当前事务的嵌套事务来运行；如果当前没有事务，则该取值等价与 REQUIRED
     * SUPPORTS 如果当前存在事务，则加入该事务；如果当前没有事务则以非事务的方式继续运行
     * MANDATORY 如果当前存在事务 则加入该事务；如果当前没有事务 则抛出异常
     * NOT_SUPPORTED 以非事务方式运行 如果当前存在事务，则把当前事务挂起
     * NEVER 以非事务方式运行，如果当前存在事务 则抛出异常
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void update(){
        jdbcTemplate.update("update user set money = ? where name = ?", 6000, "lisi");
    }

}
