package com.traningon.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.traningon.userservice.entity.User;
import com.traningon.userservice.repository.UserRepository;

import VO.Department;
import VO.ResponseTemplate;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) {
		return userRepository.save (user);
	}

	public ResponseTemplate getUserWithDepartment(Long userId) {

		ResponseTemplate vo=new ResponseTemplate() ;
		User user=userRepository.findByUserId(userId);
		Department department=restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/reterive/"+user.getDepartmentId(), Department.class);
		vo.setUser(user);
		vo.setDepartment(department);
		return vo;
		
	}
}
