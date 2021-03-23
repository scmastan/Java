package com.mastan.department.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.mastan.department.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

	public Department findById(int id);

}
