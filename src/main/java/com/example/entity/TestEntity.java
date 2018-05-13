package com.example.entity;

public class TestEntity {

  private Integer id;

  private String name;

  private Integer age;

  private String job;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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

  public String getJob() {
    return job;
  }

  public void setJob(String job) {
    this.job = job;
  }

  @Override
  public String toString() {
    return "TestEntity [id=" + id + ", name=" + name + ", age=" + age + ", job=" + job + "]";
  }


}
