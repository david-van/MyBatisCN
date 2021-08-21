package com.david.mybatis.dal;

import org.apache.ibatis.annotations.Param;

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
}