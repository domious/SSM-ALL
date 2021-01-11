package com.ssm_all.dao;

import com.ssm_all.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    public boolean save(User user);
    public boolean update(User user);
    public boolean delete(Integer uuid);
    public User get(Integer uuid);

    /**
     *
     * @return
     */
    public List<User> getAll();

    /**
     * 根据用户名密码查询
     * @param userName
     * @param password
     * @return
     */
    public User getByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);
}
