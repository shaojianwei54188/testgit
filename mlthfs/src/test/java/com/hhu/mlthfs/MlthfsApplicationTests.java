//package com.hhu.mlthfs;
//
//import com.hhu.mlthfs.mapper.UserDao;
//import com.hhu.mlthfs.model.User;
//import com.hhu.mlthfs.service.UserService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@ComponentScan(basePackages = "com.hhu.mlthfs.mapper")
//@SpringBootTest
//public class MlthfsApplicationTests {
//
//
//
//	@Autowired
//	private UserService userService;
//	@Autowired
//	private UserDao userDao;
//	@Test
//	public void contextLoads() {
//
//		User user=new User();
//		user.setLoginName("tom");
//		user.setPassword("123456");
//
//		int result=userDao.insert(user);
//		System.out.println(result);
//
//
//	}
//
//}
