package com.zyh.dao.user;

import com.zyh.pojo.User;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Zyh
 * @date 2020/12/15/0015 8:48
 */
public interface UserMapper {

    User getLoginUser(String username);

    int updatePassword(String password);

}
