package com.wzn.dao;

import com.wzn.pojo.User;
import com.wzn.utilTest.JdbcUtil;
import com.wzn.utilTest.RowMap;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserImpl implements IUserDao {
    @Override
    public User getUser(String username) {
        return JdbcUtil.queryOne("select username,password from user where username=?", new RowMap<User>() {
            @Override
            public User rowMapping(ResultSet rs) {
                User u = new User();
                try {
                    u.setUsername(rs.getString("username"));
                    u.setPassword(rs.getString("password"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return u;
            }
        }, username);
    }

    @Override
    public int add(User user) {  //插入数据的方法实现
        return JdbcUtil.executeUpdate("insert into user(username,password) values(?,?)",user.getUsername(),user.getPassword());
    }


}
