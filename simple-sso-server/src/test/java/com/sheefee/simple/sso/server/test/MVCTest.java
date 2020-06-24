package com.sheefee.simple.sso.server.test;

import com.sheefee.simple.sso.client.domain.User;
import com.sheefee.simple.sso.server.controller.IndexController;
import com.sheefee.simple.sso.server.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * 单元测试类
 *
 * @author KeHanDi
 * @title: MyTest
 * @projectName simple-sso
 * @date 2020/6/24 15:12
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration // 可写可不写
@ContextConfiguration({"/META-INF/spring/*.xml"})
//@ContextConfiguration(locations = {"classpath:META-INF/spring/*.xml"}) // 和上面这种方式一样，这里可以写多个
/* https://www.cnblogs.com/kinome/p/9628830.html */
public class MVCTest {

    @Autowired
    private UserService userService;

    @Autowired
    private IndexController indexController;

    @Test
    public void test() {
        System.out.println("this is TaskTest");
        User user  = new User();
        user.setUsername("zhangsan");
        user.setPassword("123456");
        User user1 = userService.find(user);
        System.out.println(user1);
    }

    @Test
    public void test2() {
        indexController.hello();
    }
}
