package com.kf.ttt.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class NumRepoMyBatis implements NumRepository {
  
  @Autowired
  private SqlSession sqlSession;
  
}
