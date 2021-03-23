package com.mastan.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mastan.user.entity.User;

import VO.ResponseTemplateVO;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByUserId(int userId);

	

}
