package com.api.redis.controller;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.redis.model.UserDao;
import com.api.redis.model.Users;

@RestController
public class UserController {

	@Autowired
	UserDao userDao;

	@PostMapping("/addUser")
	public Users addData(@RequestBody Users users) {
		users.setUserId(UUID.randomUUID().toString());
		Users UserSaved = userDao.save(users);
		return UserSaved;
	}

	@GetMapping("/getAllUser")
	public List<Users> getAllUsers() {
		System.out.println("Inside GetAll");
		Map<Object, Object> all = userDao.findAll();
		Collection<Object> values = all.values();
		List<Users> collectList = values.stream().map(value -> (Users) value).collect(Collectors.toList());
		return collectList;
	}

}
