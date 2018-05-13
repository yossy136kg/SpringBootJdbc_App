package com.example;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.dao.TestDao;
import com.example.entity.TestEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringBootJdbcAppApplication.class)
public class TestRepositoryTests {

  @Autowired
  public TestDao testDao;

  @Autowired
  JdbcTemplate jdbcTemplate;

  @Test
  public void testOK() throws Exception {
    jdbcTemplate
        .execute("create table test(id int primary key,name varchar, age int, job varchar)");

    TestEntity e = new TestEntity();
    e.setId(100);
    e.setName("TEST");
    e.setAge(30);
    e.setJob("IT");
    testDao.save(e);

    List<Map<String, Object>> savedEList = testDao.select();
    System.out.println(savedEList);
    Assert.assertEquals(savedEList.size(), 1);
  }

}
