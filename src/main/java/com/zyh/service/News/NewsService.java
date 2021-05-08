package com.zyh.service.News;

import com.zyh.pojo.Movie;
import com.zyh.pojo.News;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Zyh
 * @date 2020/12/20/0020 15:37
 */
public interface NewsService {

    List<News> getNewsList();

    List<News> getNewsByNameOrType(String name, String type);

    News getNews(Integer id);

    boolean deleteNewsById(Integer id);

    boolean addNews(News news);

    boolean updateNews(News news);
}
