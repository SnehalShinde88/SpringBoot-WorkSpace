package com.api.redis.model;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	private static final String KEY = "user1222";


	public Users save(Users users) {
		redisTemplate.opsForHash().put(KEY, users.getUserId(), users);
		return users;
	}

	public Users get(String userId) {
		return (Users) redisTemplate.opsForHash().get(KEY, userId);
	}

	public Map<Object, Object> findAll() {

		return redisTemplate.opsForHash().entries(KEY);

	}

	/*
	 * public Map<Object, Object> delete(String UserId) {
	 * redisTemplate.opsForHash().delete(KEY, UserId); entries2 =
	 * redisTemplate.opsForHash().entries(KEY); return entries2;
	 * 
	 * }
	 */

}
