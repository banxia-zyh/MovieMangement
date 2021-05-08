package com.zyh.dao.movie;

import com.zyh.pojo.Movie;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Zyh
 * @date 2020/12/15/0015 16:41
 */
public interface MovieMapper {

    List<Movie> getMovieByNameOrType(@Param("name") String name,@Param("type") String type);

    List<Movie> getMovieList();

    Movie getMovieById(Integer id);

    int deleteMovieById(@Param("id")Integer id);

    int addMovie(Movie movie);

    int updateMovie(Movie movie);

}
