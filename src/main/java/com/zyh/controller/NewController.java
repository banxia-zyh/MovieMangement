package com.zyh.controller;

import com.zyh.pojo.Movie;
import com.zyh.pojo.NewType;
import com.zyh.pojo.News;
import com.zyh.service.News.NewsService;
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
 * @date 2020/12/20/0020 15:09
 */
@Controller
public class NewController {
    @Resource
    private NewsService newsService;
    @Resource
    private NewTypeService newTypeService;

    @RequestMapping("/newsList.html")
    public String getNewsList(Model model, HttpServletRequest request, HttpSession session){
        List<News> newsList = newsService.getNewsList();
        List<NewType> newTypeList = newTypeService.getNewTypeList();
        model.addAttribute("newsList",newsList);
        session.setAttribute("newTypeList",newTypeList);
        return "news";
    }

    @RequestMapping("/getNews")
    public String getNews(Model model,@Param("type") String type,@Param("name")String name){
        List<News> newsList = newsService.getNewsByNameOrType(name, type);
        model.addAttribute("newsList",newsList);
        return "news";
    }

    @RequestMapping("/delNews/{news.id}")
    public String deleteNews(@PathVariable("news.id") int id){
        System.out.println(id);
        newsService.deleteNewsById(id);
        return "redirect:/newsList.html";
    }

    @RequestMapping("/toAddNewsPage")
    public String toAddNewsPage(Model model){
        System.out.println("NewController.toAddNewsPage");
        List<NewType> newTypeList = newTypeService.getNewTypeList();
        model.addAttribute("newTypeList",newTypeList);
        System.out.println(newTypeList);
        return "addNews";
    }

    @RequestMapping("/addNews")
    public String addNews(News news){
        newsService.addNews(news);
        return "redirect:/newsList.html";
    }


    @RequestMapping("/toUpdateNewsPage/{news.id}")
    public String toUpdate(Model model, @PathVariable("news.id") Integer id){
        News news = newsService.getNews(id);
        System.out.println(news);
        List<NewType> newTypeList = newTypeService.getNewTypeList();
        model.addAttribute("newTypeList",newTypeList);
        model.addAttribute("news",news);
        return "updateNews";
    }

    @RequestMapping("/updateNews")
    public String updateNews(Model model, News news,@Param("id") Integer id){
        System.out.println(news);
        news.setId(id);
        System.out.println(news);
        newsService.updateNews(news);
        News news1 = newsService.getNews(news.getId());
        model.addAttribute("movies", news1);
        return "redirect:/newsList.html";
    }

}
