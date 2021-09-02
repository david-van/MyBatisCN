package com.david.mybatis.dal;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author qiyu
 */
public interface UserMapper {


    /**
     * 插入用户
     *
     * @param userEntity
     */
    int insertUser(UserEntity userEntity);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    UserEntity selectUserById(@Param("id") Long id);

    @Select("SELECT * FROM t_user")
    List<UserEntity> selectAll();
}