package com.zyh.dao.type;

import com.zyh.pojo.MovieType;
import com.zyh.pojo.NewType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Zyh
 * @date 2020/12/18/0018 10:52
 */
public interface NewTypeMapper {

    NewType getType(@Param("type") String type);

    List<NewType> getTypeList();

    int deleteNewById(@Param("id")Integer id);

    int updateNew(@Param("type") String type,@Param("id") Integer id);

    int insertNew(String type);

}
