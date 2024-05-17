package com.rays.test;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.rays.dto.UserDTO;
import com.rays.service.UserServiceInt;

@Component("testUserService")
public class TestUserService {
	@Autowired
	public UserServiceInt userService;

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		TestUserService test = context.getBean("testUserService", TestUserService.class);
		//test.testAdd();
		//test.testUpdate();
		//test.testDelete();
		//test.findByPk();
		// test.testAuth();
		 test.testSearch();
	}

	private void testAdd() {
		UserDTO dto = new UserDTO();
		dto.setId(2);
		dto.setFirstName("Himanshu");
		dto.setLastName("Jain");
		dto.setLogin("himanshu@gmail.com");
		dto.setPassword("123");

		userService.add(dto);
		System.out.println("data added successfully......!!!");

	}

	private void testUpdate() {
		UserDTO dto = new UserDTO();
		dto.setId(1);
		dto.setFirstName("Himanshu Kumar");
		dto.setLastName("Jain");
		dto.setLogin("himanshu@gmail.com");
		dto.setPassword("123");
		userService.update(dto);
		System.out.println("Data Updated");

	}

	private void testDelete() {
		userService.delete(2L);
		System.out.println("data deleted");

	}

	private void findByPk() {
		UserDTO dto = userService.findByPK(1);
		if (dto != null) {
			System.out.println(dto.getId());
			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastName());
			System.out.println(dto.getPassword());
			System.out.println(dto.getLogin());
		} else {
			System.out.println("User Id not exist");
		}

	}

	public void testAuth() {
		UserDTO dto = userService.authenticate("himanshu@gmail.com", "123");
		if (dto != null) {
			System.out.print(dto.getId());
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + dto.getLastName());
			System.out.print("\t" + dto.getLogin());
			System.out.println("\t" + dto.getPassword());
		} else {
			System.out.println("User not exist");
		}
	}

	public void testSearch() {

		UserDTO dto = new UserDTO();

		List<UserDTO> list = userService.search(dto, 0, 5);

		Iterator it = list.iterator();

		while (it.hasNext()) {
			dto = (UserDTO) it.next();
			System.out.print(dto.getId());
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + dto.getLastName());
			System.out.print("\t" + dto.getLogin());
			System.out.println("\t" + dto.getPassword());
		}
	}
}
