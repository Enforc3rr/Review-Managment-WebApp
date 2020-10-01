package com.ReviewManagement.Project.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ReviewManagement.Project.Entitites.BookEntity;

public interface BookRepo extends CrudRepository<BookEntity, Long> {
	@Override
	public List<BookEntity> findAll();

}
