package com.zyh.service.type;

import com.zyh.dao.type.NewTypeMapper;
import com.zyh.pojo.NewType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Zyh
 * @date 2020/12/18/0018 11:05
 */
@Service
public class NewTypeServiceImpl implements NewTypeService {

    @Resource
    private NewTypeMapper newTypeMapper;

    @Override
    public List<NewType> getNewTypeList() {
        return newTypeMapper.getTypeList();
    }

    @Override
    public NewType getNewType(String type) {
        return newTypeMapper.getType(type);
    }

    @Override
    public boolean deleteNewTypeById(Integer id) {
        boolean flag = false;
        if(newTypeMapper.deleteNewById(id) > 0){
            flag = true;
        }
        return flag;

    }

    @Override
    public boolean addNewType(String newType) {
        boolean flag = false;
        if(newTypeMapper.insertNew(newType) > 0){
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean updateNewType(String type,Integer id) {
        boolean flag = false;
        if(newTypeMapper.updateNew(type,id) > 0){
            flag = true;
        }
        return flag;
    }
}
