package com.keymaker.test;


import com.keymaker.dao.IUserDao;
import com.keymaker.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;



public class MybatisTest {

    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before
    public  void init()throws Exception{
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        sqlSession = factory.openSession();
        //4.使用SqlSession创建Dao接口对象
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void destory() throws Exception{
        sqlSession.commit();
        //6.释放资源
        sqlSession.close();
        in.close();
    }

    @Test
    public void testFindAll()throws Exception{
        List<User> users = userDao.findAll();
        for(User user : users){
            System.out.println(user);
        }
    }

    /*存储*/
    @Test
    public void testSave(){
        User user = new User();
        user.setUsername("one");
        user.setPassword("123456");
        user.setSex("x");
        userDao.saveUser(user);
    }


    /*根据id查询*/
    @Test
    public void testFindByIdSafe() throws Exception{
        User user = userDao.findUserByIdSafe(10);
        System.out.println(user);
    }
    @Test
    public void testtestFindByIdVul() throws Exception{
        User user = userDao.findUserByIdVul("10 and 0");
        System.out.println(user);
    }



    /*根据username查询*/
    @Test
    public  void testLikeBynameVul(){
        String normalParam = "t";
        String vulParam1 = "t' and 0#";
        String vulParam2 = "t' and 1#";
        List<User> users = userDao.likeBynameVul(vulParam1);
        for(User user : users){
            System.out.println(user);
        }
    }
    @Test
    public void testLikeBynameSafe(){
        String normalParam = "t";
        List<User> users = userDao.likeBynameVul(normalParam);
        for(User user : users){
            System.out.println(user);
        }
    }


    /*in 查询*/
    @Test
    public void testInSexVul(){
        String normalParam = "'x','xy'";             //前端输入x,xy
        String vulParam1 = "'x','xy') and 1#";
        String vulParam2 = "'x','xy') and 0#";

        List<User> users= userDao.inSexVul(normalParam);
        for(User user : users){
            System.out.println(user);
        }
    }
    @Test
    public void testInSexSafe(){
        String normalParam = "x,xy";

        String[] sexs = normalParam.split(",");
        List<User> users= userDao.inSexSafe(sexs);
        for(User user : users){
            System.out.println(user);
        }
    }

    /*排序 涉及到语句中的结构，必须要用$*/
    @Test
    public void testOrderByVul(){
        String nomalParam = "id";
        String vulParam = "id,(select sleep(3))#";

        List<User> users = userDao.orderByVul(vulParam);
        for(User user : users){
            System.out.println(user);
        }
    }
    @Test
    public void testOrderBySafe(){
        String[] colums = {"id","sex","username"};  //用映射的方法来避免直接用用户输入
        Integer noramlParam = 0;  //"id"

        if (noramlParam >=0&& noramlParam < colums.length){
            List<User> users = userDao.orderByVul(colums[noramlParam]);
            for(User user : users){
                System.out.println(user);
            }
        }else{
            //exit
        }
    }
}