package com.ssm_all.service;

import com.github.pagehelper.PageInfo;
import com.ssm_all.domain.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional(readOnly = true)
public interface UserService {
    @Transactional(readOnly = false)
    public boolean save(User user);

    @Transactional(readOnly = false)
    public boolean update(User user);

    @Transactional(readOnly = false)
    public boolean delete(Integer uuid);

    public User get(Integer uuid);

    /**
     *
     * @return
     */
    public PageInfo<User> getAll(int page, int size);

    /**
     * 根据用户名密码登陆
     * @param userName
     * @param password
     * @return
     */
    public User login(String userName,String password);
}
