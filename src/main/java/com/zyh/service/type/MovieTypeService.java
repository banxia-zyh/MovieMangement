package com.zyh.service.type;

import com.zyh.pojo.Movie;
import com.zyh.pojo.MovieType;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Zyh
 * @date 2020/12/18/0018 11:04
 */
public interface MovieTypeService {

    List<MovieType> getMovieTypeList();

    MovieType getMovieType(String type);

    boolean deleteMovieTypeByType(String type);

    boolean addMovieType(String type);

    boolean updateMovieType(Integer id,String type);
}
