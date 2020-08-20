package com.chigua.springboot.utils;

import com.alibaba.fastjson.JSONObject;

import java.awt.image.Kernel;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * ProjectName: springboot-study-shiro
 * ClassName: com.chigua.springboot.utils.Employee
 *
 * @author Mr.zhou <ijiami.cn>
 * @description Employee
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/08/12 - 15:56
 */

public class Employee {

    private Integer number;
    private String name;
    private Integer age;
    private Rank rank;
    private Gender gender;
    public Employee(Integer number, String name, Integer age, Rank rank, Gender gender) {
        this.number = number;
        this.name = name;
        this.age = age;
        this.rank = rank;
        this.gender = gender;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", rank=" + rank +
                '}';
    }
    public static enum Rank{
        MANAGER, PROGRAMMER,TESTER,OPERATOR
    }
    public static enum Gender{
        MALE,FEMALE
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "e1", 30, Employee.Rank.MANAGER, Employee.Gender.MALE));
        employees.add(new Employee(2, "e2", 31, Employee.Rank.PROGRAMMER, Employee.Gender.MALE));
        employees.add(new Employee(3, "e3", 29, Employee.Rank.PROGRAMMER, Employee.Gender.MALE));
        employees.add(new Employee(4, "e4", 24, Employee.Rank.PROGRAMMER, Employee.Gender.MALE));
        employees.add(new Employee(5, "e5", 25, Employee.Rank.PROGRAMMER, Employee.Gender.FEMALE));
        employees.add(new Employee(6, "e6", 29, Employee.Rank.PROGRAMMER, Employee.Gender.MALE));
        employees.add(new Employee(7, "e7", 25, Employee.Rank.TESTER, Employee.Gender.FEMALE));
        employees.add(new Employee(8, "e8", 27, Employee.Rank.TESTER, Employee.Gender.MALE));
        employees.add(new Employee(9, "e9", 28, Employee.Rank.OPERATOR, Employee.Gender.MALE));
        employees.add(new Employee(10, "e10", 26, Employee.Rank.OPERATOR, Employee.Gender.FEMALE));
        System.out.println(employees);

        //对员工按职能进行分类
        Map<Rank, List<Employee>> map =employees.stream().collect(Collectors.groupingBy(Employee::getRank,Collectors.toList()));
        System.out.println("对员工按职能进行分类 :"+JSONObject.toJSON(map));
        //获取员工年龄最大的员工
        Employee employee= employees.stream().max((Comparator.comparing(Employee::getAge))).get();
        System.out.println("获取员工年龄最大的员工："+JSONObject.toJSON(employee));
        //获取员工年龄最大的员工
        Employee employeeMin= employees.stream().min((Comparator.comparing(Employee::getAge))).get();
        System.out.println("获取员工年龄最小的员工："+JSONObject.toJSON(employeeMin));
        //员工按年龄大小排序
        employees.sort(((o1, o2) -> o2.getAge().compareTo(o1.getAge())));
        System.out.println("员工按年龄大小排序："+JSONObject.toJSON(employees));
        // 获取员工名字叫e7的员工
        Employee employee2= employees.stream().filter(employee1 -> employee1.getName().equals("e7")).findFirst().get();
        System.out.println("获取员工名字叫e7的员工："+JSONObject.toJSON(employee2));
        // 获取员工职能在TESTER的员工列表
        Object[] objects= employees.stream().filter(employee1 -> employee1.getRank().equals(Rank.TESTER)).toArray();
        System.out.println("获取员工职能在TESTER的员工列表："+JSONObject.toJSON(objects));

        Map<String,Object> stringObjectMap=new HashMap<>();
        stringObjectMap.put("MANAGER",new Employee(1, "e1", 30, Employee.Rank.MANAGER, Employee.Gender.MALE));
        stringObjectMap.put("TESTER",new Employee(1, "e1", 30, Employee.Rank.MANAGER, Employee.Gender.MALE));
        stringObjectMap.put("OPERATOR",new Employee(1, "e1", 30, Employee.Rank.MANAGER, Employee.Gender.MALE));

        //获取map key 与value值
        stringObjectMap.forEach((k,v) ->{
            System.out.println("k"+k+"----v"+v);
        });
    }
}
