package com.david.mybatis.dal;

import java.time.LocalDateTime;

/**
 * todo
 *
 * @author fanzunying
 * @date 2021-02-07 15:59
 */

public class UserEntity {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */

    private Integer age;

    /**
     * 休息日，
     */
    private String restDay;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否删除
     */
    private Boolean deleted;
}
