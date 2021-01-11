package com.ssm_all.service;

import com.github.pagehelper.PageInfo;
import com.ssm_all.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @Test
    public void testSave(){
        User user = new User();
        user.setUserName("hxd");
        user.setPassword("123");
        user.setRealName("hxd123");
        user.setGender(1);
        user.setBirthday(new Date());

        userService.save(user);
    }

    @Test
    public void testDelete(){
        userService.delete(2);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setUuid(3);
        user.setUserName("hxd");
        user.setPassword("123");
        user.setRealName("zhangsan");
        user.setGender(0);
        user.setBirthday(new Date());

        userService.update(user);
    }

    @Test
    public void testGet(){
        User user = userService.get(1);
        System.out.println(user);

    }

    @Test
    public void testLogin(){
        User user = userService.login("hxd1", "1234");
        System.out.println(user);
    }

    @Test
    public void testGetAll(){
        PageInfo<User> all = userService.getAll(1, 3);
        System.out.println(all);
        User user = all.getList().get(0);
        User user1 = all.getList().get(1);
        System.out.println(user);
        System.out.println(user1);
    }



}
