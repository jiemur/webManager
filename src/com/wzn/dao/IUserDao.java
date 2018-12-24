package com.wzn.dao;

import com.wzn.pojo.User;

public interface IUserDao {
    public User getUser(String username);
    public int add(User user);
}
