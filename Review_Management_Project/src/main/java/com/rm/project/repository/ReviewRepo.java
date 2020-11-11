package com.rm.project.repository;

import org.springframework.data.repository.CrudRepository;

import com.rm.project.entity.ReviewsEntity;

public interface ReviewRepo extends CrudRepository<ReviewsEntity, Long> {
}
