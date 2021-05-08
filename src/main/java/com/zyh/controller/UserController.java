package com.zyh.controller;

import com.zyh.dao.user.UserMapper;
import com.zyh.pojo.*;
import com.zyh.service.Movie.MovieService;
import com.zyh.service.News.NewsService;
import com.zyh.service.type.MovieTypeService;
import com.zyh.service.type.NewTypeService;
import com.zyh.service.user.UserService;

import org.apache.ibatis.annotations.Param;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * Created by IntelliJ IDEA.
 *
 * @author Zyh
 * @date 2020/12/15/0015 9:24
 */

@Controller
public class UserController {


    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    public UserService getUserService() {
        return userService;
    }


    @RequestMapping(value="/login.html",method= RequestMethod.POST)
    public String doLogin(@Param("username") String username, @Param("password") String password,Model model, HttpSession session) throws Exception{
        //调用service方法，进行用户匹配
        User user = userService.userLogin(username, password);

        if(null != user){//登录成功

            session.setAttribute("userSession",user);
            return "index";
        }else{
            //页面跳转（login.jsp）带出提示信息--转发
            model.addAttribute("error", "用户名或密码不正确");
            return "login";
        }
    }

    @RequestMapping("/updatePwd")
    public String updatePwd(@Param("pass") String pass,@Param("oldPwd")String oldPwd,@Param("username")String username, Model model){
        User user = userMapper.getLoginUser(username);
        System.out.println(user);
        if (!user.getPassword().equals(oldPwd)){
            System.out.println(user.getPassword()+"->"+oldPwd);
            model.addAttribute("msg","旧密码不正确");
            return "updatePassword";
        }else {
            userService.updatePassword(pass);
            return "";
        }
    }

    @RequestMapping("toUpdatePwd")
    public String toUpdatePwd(){
        return "updatePassword";
    }

    @RequestMapping("/logout")
    public String Logout( HttpSession session){
        session.removeAttribute("userSession");
        return "login";
    }

}
