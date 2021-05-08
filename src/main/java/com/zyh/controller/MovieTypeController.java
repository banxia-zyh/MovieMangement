package com.zyh.controller;

import com.zyh.pojo.MovieType;
import com.zyh.service.type.MovieTypeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Zyh
 * @date 2020/12/18/0018 11:30
 */

@Controller
public class MovieTypeController {
    @Resource
    private MovieTypeService movieTypeService;

    @RequestMapping("/addMovieType")
    public String addMovieType(@Param("type") String type, Model model, HttpServletRequest request, HttpSession session){
        System.out.println(type);
        MovieType movieType = movieTypeService.getMovieType(type);
        if (movieType == null){
            movieTypeService.addMovieType(type);
            return "redirect:/movieTypeList";
        }else {
            model.addAttribute("msg","添加的类别已存在！！！");
            return "addMovieType";
        }
    }

    @RequestMapping("/toUpdateMovieTypePage/{movieType.id}")
    public String toUpdateMovieTypePage(Model model,@PathVariable("movieType.id") Integer id){
        model.addAttribute("id",id);
        return "updateMovieType";
    }
    @RequestMapping("/updateMovieTypePage")
    public String updateMovieTypePage(@Param("id") Integer id,@Param("type") String type,Model model){
        MovieType movieType = movieTypeService.getMovieType(type);
        if (movieType == null){
            movieTypeService.updateMovieType(id,type);
            return "redirect:/movieTypeList";
        }else {
            model.addAttribute("msg0","修改的类别以存在！！！");
            return "updateMovieType";
        }
    }

    @RequestMapping("/movieTypeList")
    public String selectMovieType(Model model,HttpServletRequest request, HttpSession session){
        List<MovieType> movieTypeList = movieTypeService.getMovieTypeList();
        session.setAttribute("movieTypeList",movieTypeList);
        model.addAttribute("movieTypeList",movieTypeList);
        return "movieType";
    }

    @RequestMapping("selectMovieTypeByType")
    public String selectMovieTypeByType(@Param("type") String type,Model model){
        System.out.println(type);
        MovieType movieTypeList = movieTypeService.getMovieType(type);
        System.out.println(movieTypeList);
        model.addAttribute("movieTypeList",movieTypeList);
        return "movieType";
    }

    @RequestMapping("/delMovieType/{movieType.type}")
    public String delMovieType(@PathVariable("movieType.type") String type){
        System.out.println(type);
        movieTypeService.deleteMovieTypeByType(type);
        return "redirect:/movieTypeList";
    }


}
