package com.bjpowernode;

import com.bjpowernode.dom.StudentDom;
import com.bjpowernode.domain.Student;
import com.bjpowernode.domain.StudentMap;
import com.bjpowernode.util.mybatisUtils;
import com.bjpowernode.vo.StudentAndClass;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class selectTest {
    @Test
    public void select(){
       SqlSession sqlSession = mybatisUtils.getSqlSession();
       //使用mybatis的动态代理机制 获取dao接口的实现类
       StudentDom dom = sqlSession.getMapper(StudentDom.class);
       //dao名字
        System.out.println("dao的名字："+dom.getClass().getName());
        List<Student> student = dom.select();
        for(Student stu : student){
            System.out.println(stu);
        }


    }
    @Test
    public void update(){
        SqlSession sqlSession  = mybatisUtils.getSqlSession();
        StudentDom dom = sqlSession.getMapper(StudentDom.class);
        //要插入的学生对象
        Student student = new Student();
        student.setName("刘备");
        student.setId(1009);
        student.setEmail("liubei@qq.com");
        student.setAge(24);
        int num = dom.update(student);
        //提交事物
        sqlSession.commit();
        System.out.println(num);
    }
    @Test
    public void selectById(){
        //通过工具类获取SqlSession
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        //通过mybatis的动态代理机制，获取目标类对象
        StudentDom dom = sqlSession.getMapper(StudentDom.class);
        //执行目标方法
        Student student = dom.selectById(1003);
        System.out.println("结果："+student);
        //关闭SqlSession
        sqlSession.close();
    }
    @Test
    public void selectMultiParam(){
        //获取SqlSession
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        //通过mybatis的动态代理机制获取目标对象
        StudentDom dom = sqlSession.getMapper(StudentDom.class);
        //执行目标方法
        List<Student> list = dom.selectMulitParam("张飞",20);
        //遍历集合
        for(Student stu:list){
            System.out.println("Student="+stu);
        }
    }
    @Test
    public void selectParam2(){
        //通过工具类得到SqlSession
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        //通过mybatis的动态代理机制得到目标对象
        StudentDom dom = sqlSession.getMapper(StudentDom.class);
        //调用目标方法
        Student student = new Student();
        student.setName("lisi");
        student.setAge(20);
        List<Student> stus = dom.selectParam2(student);
        //循环数组
        for(Student stu:stus){
            System.out.println("stu="+stu);
        }
    }
    @Test
    public void orderByName(){
        //获取SqlSession
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        //通过动态代理获取目标类
        StudentDom dom = sqlSession.getMapper(StudentDom.class);
        //调用目标方法
        List<Student> stus = dom.orderByName("age");
        for(Student stu:stus){
            System.out.println("stu="+stu);
        }
    }
    //resultMap
    @Test
    public void selectStudentMap(){
        StudentDom dom = mybatisUtils.getSqlSession().getMapper(StudentDom.class);
        List<StudentMap> studentMaps = dom.selectStudentMap(1002);
        for(StudentMap map:studentMaps){
            System.out.println("map="+map);
        }
    }
    //模糊查询
    @Test
    public void selectLike(){
        //获取SqlSession
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        //获取目标对象
        StudentDom dom = sqlSession.getMapper(StudentDom.class);
        //调用目标方法
        String name="%张%";
        List<Student> students = dom.selectLike(name);
        //遍历集合
        for(Student stu:students){
            System.out.println("stu="+stu);
        }
    }
    //动态sql if
    @Test
    public void selectIf(){
        StudentDom dom = mybatisUtils.getSqlSession().getMapper(StudentDom.class);
        Student student = new Student();
        student.setName("lisi");
        student.setAge(18);
        List<Student> students = dom.selectIf(student);
        for(Student stu:students){
            System.out.println("if="+stu);
        }
    }
    //动态sql where
    @Test
    public void selectWhere(){
        StudentDom dom = mybatisUtils.getSqlSession().getMapper(StudentDom.class);
        Student student = new Student();
        student.setName("lisi");
        student.setAge(18);
        List<Student> students = dom.selectWhere(student);
        for(Student stu:students){
            System.out.println("stu="+stu);
        }
    }
    //动态sql foreach 1
    @Test
    public void selectForeach1(){
        StudentDom dom = mybatisUtils.getSqlSession().getMapper(StudentDom.class);
        List<Integer> list = new ArrayList<>();
        list.add(1001);
        list.add(1002);
        list.add(1003);
        List<Student> students = dom.selectForeach1(list);
        for(Student stu:students){
            System.out.println("stu="+stu);
        }
    }
    //动态sql foreach 2
    @Test
    public void selectForeach2(){
        StudentDom dom = mybatisUtils.getSqlSession().getMapper(StudentDom.class);
        List<Student> list = new ArrayList<>();
        Student student = new Student();
        student.setId(1001);
        list.add(student);
        Student student1 = new Student();
        student1.setId(1002);
        list.add(student1);
        List<Student> students = dom.selectForeach2(list);
        for(Student stu:students){
            System.out.println("stu="+stu);
        }
    }
    @Test
    public void testSelectAll(){
        StudentDom dom = mybatisUtils.getSqlSession().getMapper(StudentDom.class);
        PageHelper.startPage(2,2);
        List<Student> students = dom.selectAll();

        for(Student stu:students){
            System.out.println("stu="+stu);
        }
    }
    @Test
    public void testDelete() throws IOException {
        //resources 读取主配置文件
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession sqlSession = factory.openSession();
        int count = sqlSession.delete("com.bjpowernode.dom.StudentDom.delete", 1009);
        sqlSession.commit();
        sqlSession.close();

    }
    //联表查询，查询学生姓名和班级姓名
    @Test
    public void testSelectStudentAndClassName(){
        StudentDom dom = mybatisUtils.getSqlSession().getMapper(StudentDom.class);
        List<Map<String, String>> maps = dom.selectStudentAndClassName();
        System.out.println(maps);
        for(Map<String,String> map:maps){
            Set<String> set = map.keySet();
            for(String s:set){
                Object value = map.get(s);
                System.out.println("key="+s+","+"value="+value);
            }
            System.out.println("==========");
        }
        //System.out.println(maps);
       // for(Map<String, Object> map:maps){

       //}
    }
    //使用vo查询学生和班级姓名
    @Test
    public void testSelectStudentAndClassByVo(){
        StudentDom dom = mybatisUtils.getSqlSession().getMapper(StudentDom.class);
        List<StudentAndClass> list = dom.selectStudentAndClassByVo();
        for(StudentAndClass stu:list){
            System.out.println(stu);
        }
    }
    //模糊查询，查询所有名字中带有张的学生信息
    @Test
    public void testSelectStudnetAndClassTwo(){
        StudentDom dom = mybatisUtils.getSqlSession().getMapper(StudentDom.class);
        List<StudentAndClass> list = dom.selectStudentAndClassTwo("张");
        for(StudentAndClass stu:list){
            System.out.println(stu);
        }
    }
}
