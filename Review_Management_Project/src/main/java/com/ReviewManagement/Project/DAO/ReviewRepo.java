package com.ReviewManagement.Project.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ReviewManagement.Project.Entitites.ReviewEntity;

public interface ReviewRepo extends CrudRepository<ReviewEntity, Long> {
	@Override
	public List<ReviewEntity> findAll();
	
}
