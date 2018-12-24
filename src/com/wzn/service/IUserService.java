package com.wzn.service;

import com.wzn.pojo.User;

public interface IUserService {
    public User getUser(String username);
    public int add(User u);
}
