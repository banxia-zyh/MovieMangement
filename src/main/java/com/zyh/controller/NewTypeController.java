package com.zyh.controller;

import com.zyh.pojo.MovieType;
import com.zyh.pojo.NewType;
import com.zyh.service.type.NewTypeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Zyh
 * @date 2020/12/18/0018 17:32
 */

@Controller
public class NewTypeController {
    @Resource
    private NewTypeService newTypeService;


    @RequestMapping("/addNewType")
    public String addNewType(@Param("type") String type, Model model,HttpServletRequest request, HttpSession session){
        System.out.println(type);
        NewType newType = newTypeService.getNewType(type);
        if (newType == null){
            newTypeService.addNewType(type);
            return "redirect:/newTypeList";
        }else {
            model.addAttribute("msg","添加的类别以存在");
            return "addNewsType";
        }
    }

    @RequestMapping("/toUpdateNewTypePage/{newType.id}")
    public String toUpdateNewTypePage(Model model,@PathVariable("newType.id") Integer id){
        model.addAttribute("id",id);
        System.out.println(id);
        return "updateNewsType";
    }

    @RequestMapping("/updateNewTypePage")
    public String updateNewTypePage(@Param("id") Integer id,@Param("type") String type,Model model){
        NewType newType = newTypeService.getNewType(type);
        if (newType == null){
            System.out.println(id+"->"+type);
            newTypeService.updateNewType(type,id);
            return "redirect:/newTypeList";
        }else {
            model.addAttribute("msg0","修改的类别以存在！！！");
            return "updateNewsType";
        }
    }

    @RequestMapping("/newTypeList")
    public String selectNewType(Model model,HttpServletRequest request, HttpSession session){
        List<NewType> newTypeList = newTypeService.getNewTypeList();
        System.out.println(newTypeList);
        session.setAttribute("newTypeList",newTypeList);
        model.addAttribute("newTypeList",newTypeList);
        return "newsType";
    }

    @RequestMapping("selectNewTypeByType")
    public String selectNewTypeByType(@Param("type") String type,Model model){
        System.out.println(type);
        NewType newTypeList = newTypeService.getNewType(type);
        System.out.println(newTypeList);
        model.addAttribute("newTypeList",newTypeList);
        return "newsType";
    }

    @RequestMapping("/delNewType/{newType.id}")
    public String delNewType(@PathVariable("newType.id") Integer id){
        newTypeService.deleteNewTypeById(id);
        return "redirect:/newTypeList";
    }

}
