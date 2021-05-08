package com.zyh.controller;

import com.zyh.pojo.Movie;
import com.zyh.pojo.MovieType;
import com.zyh.pojo.NewType;
import com.zyh.pojo.News;
import com.zyh.service.Movie.MovieService;
import com.zyh.service.News.NewsService;
import com.zyh.service.type.MovieTypeService;
import com.zyh.service.type.NewTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Zyh
 * @date 2020/12/24/0024 18:28
 */
@Controller
public class WelcomeController {
    @Resource
    private NewTypeService newTypeService;
    public int getNewTypeCount(){
        List<NewType> newTypeList = newTypeService.getNewTypeList();
        return newTypeList.size();
    }

    @Resource
    private NewsService newsService;
    public int getNewsCount(){
        List<News> newsList = newsService.getNewsList();
        return newsList.size();
    }
    @Resource
    private MovieTypeService movieTypeService;
    public int getMovieTypeCount(){
        List<MovieType> movieTypeList = movieTypeService.getMovieTypeList();
        return movieTypeList.size();
    }
    @Resource
    private MovieService movieService;
    public int getMoviesCount(){
        List<Movie> movieList = movieService.getMovieList();
        return movieList.size();
    }

    @RequestMapping("welcome")
    public String welcome(HttpSession session, Model model){

        model.addAttribute("newsCount",getNewsCount());
        model.addAttribute("moviesCount",getMoviesCount());
        model.addAttribute("movieTypeCount",getMovieTypeCount());
        model.addAttribute("newsTypeCount",getNewTypeCount());
        return "welcome";
    }

}
