package com.mybatis.examples.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback(true)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class MovieMapperTest {
	@Autowired
	private MovieMapper movieMapper;

	@Test
	public void testCountAll() {
		System.out.println(movieMapper.countAll());
	}
}
