package cn.yunhe.entity;

import lombok.Data;

import java.util.List;

@Data
public class Dept {

  private Integer deptno;
  private String dname;
  private String loc;

  /**
   * 一个部门多个用户
   */
  private List<Emp> empList;
}
