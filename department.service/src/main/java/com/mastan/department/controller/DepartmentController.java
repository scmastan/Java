package com.mastan.department.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mastan.department.entity.Department;
import com.mastan.department.service.DepartmentService;





@RestController
@RequestMapping("/department")
public class DepartmentController {
	Logger log = LoggerFactory.getLogger(DepartmentController.class);


	@Autowired
	private DepartmentService departmentService;

	@PostMapping("/")
	public Department saveDepartment(@RequestBody Department department) {
		
	log.info("inside Dapartment Controller saveDepartment");
	
		return departmentService.saveDepartment(department);
	}
	
	
	@GetMapping("/{id}")
	public Department findDeptbyId(@PathVariable int id) {
		
		log.info("inside Dapartment Controller find by ID");
		return departmentService.findDeptbyId(id);
	}
	
	@GetMapping("/getAllDepartments")
	public List<Department> getAllComments() {
		return departmentService.findAll();
	}
	
	
	@PutMapping("/updatedept/{id}")
	public Department updateComment(@PathVariable int id, @RequestBody Department deptDetails) {

		Department dept = departmentService.findDeptbyId(id);
		dept.setDeptAddress(deptDetails.getDeptAddress());
		dept.setDeptCode(deptDetails.getDeptCode());
		dept.setDeptName(deptDetails.getDeptName());
		Department updatedepte = departmentService.saveDepartment(dept);
		
		return updatedepte;
	}
	
	
	@DeleteMapping("/deletedept/{id}")
	public ResponseEntity<?> deleteComment(@PathVariable int id) {
		Department dept = departmentService.findDeptbyId(id);

		departmentService.delete(dept);

		return ResponseEntity.ok().build();
	}

}
