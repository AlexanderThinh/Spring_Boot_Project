package com.lbt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbt.entity.CategoryEntity;

public interface ICategoryRepository extends JpaRepository<CategoryEntity, Long> {
	CategoryEntity findOneByCode(String code);
}
