package com.ssm_all.controller;

import com.github.pagehelper.PageInfo;
import com.ssm_all.controller.results.Code;
import com.ssm_all.controller.results.Result;
import com.ssm_all.domain.User;
import com.ssm_all.service.UserService;
import com.ssm_all.system.execption.BusinessException;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;



    @GetMapping("/{uuid}")
    public Result get(@PathVariable Integer uuid){
        User user = userService.get(uuid);
        if (uuid == 2) {
            throw new BusinessException("error",Code.GET_OK);

        }
        System.out.println(123);
        System.out.println(222);
        return new Result(null != user ? Code.GET_OK : Code.GET_ERR , user);
    }

    @PostMapping
    public Result save(User user){
        boolean flag = userService.save(user);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR);
    }

    @PutMapping
    public Result update(User user){


        boolean flag = userService.update(user);

        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR);
    }

    @DeleteMapping("/{uuid}")
    public Result delete(@PathVariable Integer uuid){


        boolean flag = userService.delete(uuid);

        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR);
    }


    @GetMapping("/{page}/{size}")
    public Result getAll(@PathVariable Integer page, @PathVariable Integer size){


        PageInfo<User> user = userService.getAll(page, size);

        return new Result(null != user ? Code.GET_OK : Code.GET_ERR , user);
    }

    @PostMapping("/login")
    public Result login(String userName,String password){

        User user = userService.login(userName, password);

        return new Result(null != user ? Code.GET_OK : Code.GET_ERR , user);
    }


}
