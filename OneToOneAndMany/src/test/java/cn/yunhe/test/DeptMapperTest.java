package cn.yunhe.test;

import cn.yunhe.entity.Dept;
import cn.yunhe.entity.Role;
import cn.yunhe.entity.User;
import cn.yunhe.mapper.DeptMapper;
import cn.yunhe.mapper.RoleMapper;
import cn.yunhe.mapper.UserMapper;
import cn.yunhe.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;



public class DeptMapperTest {
    @Test
    public void testFindEmp(){
        SqlSessionFactory sqlSessionFactory = MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept=mapper.findEmp(2);
        System.out.println(dept);
        dept.getEmpList().forEach(System.out::println);
    }

    @Test
    public void findRole(){
        SqlSessionFactory sqlSessionFactory = MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        Role role = mapper.findRole(1);
        System.out.println(role);
        role.getUserList().forEach(System.out::println);
    }
}
