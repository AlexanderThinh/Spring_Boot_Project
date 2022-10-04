package com.lbt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbt.entity.NewEntity;

public interface INewRepository extends JpaRepository<NewEntity, Long> {
	
}
