package com.keymaker.dao;

import com.keymaker.domain.User;
import java.util.List;



public interface IUserDao {
    /*查询所有*/
    List<User> findAll();
    /*根据username查询*/
    User findUserByUsername(String username);
    /*username对象insert*/
    void saveUser(User user);


    /*根据id查询*/
    User findUserByIdVul(String userId);
    User findUserByIdSafe(Integer userId);


    /*username的模糊查询*/
    List<User> likeBynameVul(String username);
    List<User> likeBynameSafe(String username);

    /*根据性别in查询*/
    List<User> inSexVul(String sexs);
    List<User> inSexSafe(String[] sexs);

    /*排序*/
    List<User> orderByVul(String column);
}
