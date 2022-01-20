package com.bjpowernode.dom;

import com.bjpowernode.domain.Student;
import com.bjpowernode.domain.StudentMap;
import com.bjpowernode.vo.StudentAndClass;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDom {
    //查询
   public abstract List select();
   //新增
    int update(Student student);
    //查询by id
    Student selectById(int id);
    //多个参数
    List<Student> selectMulitParam(@Param("myname") String name, @Param("myage") Integer age);
    //多个参数2
    List<Student> selectParam2(Student student);
    //排序
    List<Student> orderByName(@Param("myname")String name);
    //resultMap
    List<StudentMap> selectStudentMap(int id);
    //like查询，名字中带李
    List<Student> selectLike(String name);
    //动态sql if标签
    List<Student> selectIf(Student student);
    //动态sql where标签
    List<Student> selectWhere(Student student);
    //动态sql foreach 1
    List<Student> selectForeach1(List<Integer> list);
    //动态sql foreach 2
    List<Student> selectForeach2(List<Student> stuList);
    //使用分页扩展
    List<Student>  selectAll();
    //删除操作
    int delete(int id);
    //查询学生姓名和班级姓名
    List<Map<String,String>> selectStudentAndClassName();
    //查询学生和班级姓名，使用vo
    List<StudentAndClass> selectStudentAndClassByVo();
    //模糊查询，查询名字中带有“张”的学生信息
    List<StudentAndClass> selectStudentAndClassTwo(String s);

}
