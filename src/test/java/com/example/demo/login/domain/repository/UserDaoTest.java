package com.example.demo.login.domain.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserDaoTest {

	@Autowired
	@Qualifier("UserDaoJdbcImpl")
	UserDao dao;
	
	@Test
	public void testCount() {
		int count = dao.count();
		assertEquals(2, count);
		// 記述はこちらの方が好き
		assertThat(count, is(2));

	}

	@Test
	@Sql("/testdata.sql")   // Spring-test jar
	public void testCount_afterSql() {
		int count = dao.count();
		assertThat(count, is(3));

	}

}
