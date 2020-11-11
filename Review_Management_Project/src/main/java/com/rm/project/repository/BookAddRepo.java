package com.rm.project.repository;

import org.springframework.data.repository.CrudRepository;

import com.rm.project.entity.BookAddition;

public interface BookAddRepo extends CrudRepository<BookAddition, Long> {

}
