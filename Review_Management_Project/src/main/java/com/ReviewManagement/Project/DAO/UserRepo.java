package com.ReviewManagement.Project.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ReviewManagement.Project.Entitites.UserEntity;

public interface UserRepo extends CrudRepository<UserEntity, Long> {
	@Override
	public List<UserEntity> findAll();

}
