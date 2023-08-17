package cn.yunhe.mapper;

import cn.yunhe.entity.User;

import java.util.HashMap;
import java.util.List;

public interface UserMapper {
    /**
     * MyBatis接口增删改查***
     */
    List<User> findAll1();
    void addUser(User user);
    void delUser(User user);
    void updateUser(User user);
    /**
     * 使用多条件查询 pojo
     */
    List<User> selectByMany(User user);
    /**
     * 模糊查询
     */
    List<User> selectLike(User user);
    /**
     * 返回新增主键id
     */
    void addUSerToId(User user);
    /**
     * 动态sql
     * if标签
     * 多条件查询
     */
    List<User> findByMany(User user);
    /**
     * 动态sql
     * set标签
     * 可用于修改对象，可实现对修改部分内容的更新未修改内容不被修改
     */
    void updateByMany(User user);
    /**
     * foreach标签三种
     * 一、集合List
     * list查询多条数据
     */
    List<User> findList(List<Integer>  list);

    /**
     * foreach标签三种
     * 一、array
     */
    List<User> findArray(Integer array[]);
    /**
     * foreach标签三种
     * 一、对象
     */

}
