package com.mastan.department.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.mastan.department.entity.Department;
import com.mastan.department.repository.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;





@Service
@Slf4j
public class DepartmentService {
	//Logger log = LoggerFactory.getLogger(DepartmentService.class);

	@Autowired
	private DepartmentRepository departmentRepository;

	public Department saveDepartment(Department department) {
		// TODO Auto-generated method stub
		log.info("inside Dapartment Service saveDepartment");
		return departmentRepository.save(department);
	}

	public Department findDeptbyId(int deptId) {
		// TODO Auto-generated method stub
		log.info("inside Dapartment Service findby ID");
		return departmentRepository.findById(deptId);
	}

	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return departmentRepository.findAll();
	}

	public void delete(Department dept) {
		// TODO Auto-generated method stub
	
		departmentRepository.delete(dept);
	}

	
}
