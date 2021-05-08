package com.zyh.service.user;

import com.zyh.dao.user.UserMapper;
import com.zyh.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Zyh
 * @date 2020/12/15/0015 9:08
 */
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User userLogin(String username, String password) {
        User user = null;
        user =  userMapper.getLoginUser(username);
        if(null != user){
            if(!user.getPassword().equals(password))
                user = null;
        }
        return user;
    }

    @Override
    public int updatePassword(String password) {
        return userMapper.updatePassword(password);
    }
}
