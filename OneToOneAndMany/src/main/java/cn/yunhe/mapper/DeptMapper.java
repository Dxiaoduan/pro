package cn.yunhe.mapper;

import cn.yunhe.entity.Dept;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DeptMapper {

    /**
     * 查询部门
     * @param deptno
     * @return
     */

    @Select("select * from dept where deptno=#{deptno}")
    @Results({
            @Result(id = true,property = "deptno",column = "deptno"),
            @Result(property = "empList",javaType = List.class,many = @Many(select ="cn.yunhe.mapper.EmpMapper.findEmp"),column = "deptno")
    })
    Dept findEmp(Integer deptno);
}
