package cn.yunhe.mapper;

import cn.yunhe.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Select("select * from user u,user_role ur where u.id=ur.uid and ur.rid=#{rid}")
    List<User> findUser(Integer rid);
}
