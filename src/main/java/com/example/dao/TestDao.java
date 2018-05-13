package com.example.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.example.entity.TestEntity;

@Repository
public class TestDao extends NamedParameterJdbcDaoSupport {

  @Autowired
  public TestDao(DataSource dataSource) {
    setDataSource(dataSource);
  }

  public List<Map<String, Object>> select() {
    List<Map<String, Object>> ret = new ArrayList<>();
    ret = getJdbcTemplate().queryForList("SELECT * FROM TEST");
    return ret;
  }

  public int save(TestEntity entity) {
    String sql = "insert into test (id,name,age,job) values (:Id,:Name,:Age,:Job)";
    return getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));
  }
}
