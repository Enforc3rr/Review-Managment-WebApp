package com.rm.project.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rm.project.entity.UserEntity;

public interface UserRepo extends CrudRepository<UserEntity, Long>  {
	@Override
	public List<UserEntity> findAll();
	
	public UserEntity findByUserName(String userName);

}
