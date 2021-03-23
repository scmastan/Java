package com.mastan.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mastan.user.entity.User;
import com.mastan.user.repository.UserRepository;

import VO.Department;
import VO.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	public UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) {
		log.info("inside user service and save user");
		return userRepository.save(user);
	}

	public ResponseTemplateVO getUserWithDepartment(int userId) {
		// TODO Auto-generated method stub
		log.info("inside user service and getUserWithDepartment");

		ResponseTemplateVO vo = new ResponseTemplateVO();
		User user = userRepository.findByUserId(userId);

		Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/" + user.getDeptId(), Department.class);

		vo.setUser(user);
		vo.setDepartment(department);
		return vo;
	}

}
