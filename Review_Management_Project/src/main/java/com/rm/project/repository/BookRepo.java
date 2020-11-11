package com.rm.project.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rm.project.entity.BookEntity;

public interface BookRepo extends CrudRepository<BookEntity, Long> {
		public List<BookEntity> findAll();
		public BookEntity findById(long id);

}
