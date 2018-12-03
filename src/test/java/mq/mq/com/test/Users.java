package mq.mq.com.test;

import cn.afterturn.easypoi.excel.annotation.Excel;


public class Users {
    @Excel(name = "id", orderNum = "0")
    private Integer id;

    @Excel(name = "名字", orderNum = "1")
    private String names;

    @Excel(name = "年龄", orderNum = "2")
    private Integer age;

    @Excel(name = "性别", replace = {"男_1", "女_0"}, orderNum = "3")
    private Integer sex;

    public Users() {
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", names='" + names + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

    public Users(Integer id, String names, Integer age, Integer sex) {
        this.id = id;
        this.names = names;
        this.age = age;
        this.sex = sex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
