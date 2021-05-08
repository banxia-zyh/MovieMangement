package com.zyh.controller;

import com.zyh.pojo.Movie;
import com.zyh.pojo.MovieType;
import com.zyh.service.Movie.MovieService;
import com.zyh.service.type.MovieTypeService;
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
 * @date 2020/12/16/0016 10:11
 */

@Controller
public class MovieController {
    @Resource
    private MovieService movieService;
    @Resource
    private MovieTypeService movieTypeService;

    @RequestMapping("/movieList.html")
    public String getMovieList(Model model, HttpSession session){
        List<Movie> movieList = movieService.getMovieList();
        List<MovieType> movieTypeList = movieTypeService.getMovieTypeList();
        session.setAttribute("movieTypeList",movieTypeList);
        model.addAttribute("movieList",movieList);
        return "movie";
    }
    @RequestMapping("/getMovie")
    public String getMovie(Model model,String name,String type,HttpSession session){
        List<MovieType> movieTypeList = movieTypeService.getMovieTypeList();
        List<Movie> movieList = movieService.getMovieByNameOrType(name, type);
        session.setAttribute("movieTypeList",movieTypeList);
        model.addAttribute("movieList",movieList);
        return "movie";
    }

    @RequestMapping("/delMovie/{movie.id}")
    public String deleteMovie(@PathVariable("movie.id")Integer id){
        System.out.println(id);
        movieService.deleteMovieById(id);
        return "redirect:/movieList.html";
    }




    @RequestMapping("/toUpdateMoviePage/{movie.id}")
    public String toUpdate(Model model,@PathVariable("movie.id")Integer id){
        model.addAttribute("id",id);
        Movie movies = movieService.getMovie(id);
        model.addAttribute("movie", movies);
        return "updateMovie";
    }


    @RequestMapping("/updateMovie")
    public String updateMovie(Model model, Movie movie){
        movieService.updateMovie(movie);
        return "redirect:/movieList.html";
    }


}
