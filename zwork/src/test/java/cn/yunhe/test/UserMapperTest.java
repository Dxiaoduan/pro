package cn.yunhe.test;

import cn.yunhe.entity.User;
import cn.yunhe.mapper.UserMapper;
import cn.yunhe.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class UserMapperTest {
    @Test
    public void findAll1() {
        SqlSessionFactory sqlSessionFactory = MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = mapper.findAll1();
        for (User user : list) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void addUser() {
        SqlSessionFactory sqlSessionFactory = MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setAddress("789");
        user.setUsername("123");
        user.setBirthday("1-1-1");
        user.setSex("2");
        mapper.addUser(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void delUser() {
        SqlSessionFactory sqlSessionFactory = MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(65);
        mapper.delUser(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUser() {
        SqlSessionFactory sqlSessionFactory = MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(59);
        user.setUsername("猪八戒");
        user.setBirthday("2012-2-2");
        user.setSex("男");
        user.setAddress("高老庄");
        mapper.updateUser(user);
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 多条件查询
     */
    @Test
    public void selectByMany() {
        SqlSessionFactory sqlSessionFactory = MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("齐天大圣");
        user.setSex("男");
        List<User> list = mapper.selectByMany(user);
        for (User user1 : list) {
            System.out.println(user1);
        }
        sqlSession.close();
    }

    /**
     * 模糊查询
     */
    @Test
    public void selectLike() {
        SqlSessionFactory sqlSessionFactory = MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("二");
        List<User> list = mapper.selectLike(user);
        for (User user1 : list) {
            System.out.println(user1);

        }
        sqlSession.close();
    }

    /**
     * 添加用户返回id
     */
    @Test
    public void addUSerToId() {
        SqlSessionFactory sqlSessionFactory = MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("dada");
        user.setBirthday("12-1-12");
        user.setSex("n");
        user.setAddress("dada");
        mapper.addUSerToId(user);
        System.out.println(user.getId());
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 动态sql查询
     * if标签
     */
    @Test
    public void findByMany() {
        SqlSessionFactory sqlSessionFactory = MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("小马宝莉");

        user.setSex("女");
        List<User> list = mapper.findByMany(user);
        for (User user1 : list) {
            System.out.println(user1);

        }

        sqlSession.close();
    }

    @Test
    public void updateByMany() {
        SqlSessionFactory sqlSessionFactory = MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(50);
        user.setUsername("红孩儿");
        mapper.updateByMany(user);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void findList() {
        SqlSessionFactory sqlSessionFactory = MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<Integer> list=new ArrayList<>();
        list.add(41);
        list.add(42);
        list.add(43);
        mapper.findList(list).forEach(System.out::println);

//        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void findArray() {
        SqlSessionFactory sqlSessionFactory = MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Integer[] array = {41,42,43};

        mapper.findArray(array).forEach(System.out::println);

//        sqlSession.commit();
        sqlSession.close();
    }
}
