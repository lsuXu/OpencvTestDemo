package com.example.a12852.opencvtestdemo.entity;

/**
 * Created by 12852 on 2017/11/3.
 */

public class Student {
    public String name;
    public int age;

    public Student(){

    }

    public Student(String name,int age){
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
