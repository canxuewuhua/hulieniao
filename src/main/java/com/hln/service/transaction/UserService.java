package com.hln.service.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 事务的使用需注意几点
 *
 * 1、回滚规则
 *    默认情况下，事务只有遇到运行期异常以及Error时才会回滚 遇到检查时异常不会回滚 如果我们想让IOException也能触发事务回滚 可以配置在事务注解上配置rollbackFor
 * 2、是否可读
 *   readOnly属性  只读事务一般设置在查询方法上 如果业务中只有一个查询sql 没必要加  如果多个读且有写的情况可以加 因为默认情况下 每个查询sql都会开启一个独立的事务
 *   设置为只读事务 多个从查询sql将置于同一个事务中
 * 3、超时时间  是说一个事务运行执行的最长时间 如果超过该时间限制但事务还没有完成，则自动回滚事务
 *
 * 注意事项
 * 1、事务只能应用在public方法上才会生效 其他不行
 * 2、事务需要从外部调用，Spring一个类中自调事务会失效
 * 3、事务注解建议加在service类上 不建议加载接口上  因为只有配置基于接口的代理这个注解才会生效 事务注解是基于aop实现的 用到了动态代理 如果是基于cglib不会起作用
 */
@Service
public class UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserService2 userService2;

    @Transactional
    public void transfer(){
        jdbcTemplate.update("update user set money = ? where name = ?", 5000, "zhangsan");
        userService2.update();
        int i = 2/0;

    }
}
