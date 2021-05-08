package com.zyh.service.type;

import com.zyh.pojo.Movie;
import com.zyh.pojo.MovieType;
import com.zyh.pojo.NewType;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Zyh
 * @date 2020/12/18/0018 11:04
 */
public interface NewTypeService {

    List<NewType> getNewTypeList();

    NewType getNewType(String type);

    boolean deleteNewTypeById(Integer id);

    boolean addNewType(String newType);

    boolean updateNewType(String type,Integer id);
}
