package com.wzn.service;

import com.wzn.dao.IUserDao;
import com.wzn.dao.UserImpl;
import com.wzn.pojo.User;

public class UserServiceImpl implements IUserService {
    private IUserDao dao=new UserImpl();
    @Override
    public User getUser(String username) {
        return dao.getUser(username);
    }

    @Override
    public int add(User u) {
        return dao.add(u);
    }
}
