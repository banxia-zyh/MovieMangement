package com.zyh.service.user;

import com.zyh.pojo.User;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Zyh
 * @date 2020/12/15/0015 9:08
 */
public interface UserService {


    User userLogin(String username, String password);

    int updatePassword(String password);
}
