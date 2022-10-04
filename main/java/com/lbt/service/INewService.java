package com.lbt.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.lbt.dto.NewDTO;

public interface INewService {
	NewDTO createNews(NewDTO newDTO);
	NewDTO updateNews(NewDTO newDTO);
	void deleteNews(long[] ids);
	void deleteNewByID(long id);
	List<NewDTO> getAll(Pageable pageable);
	int totalItem();
}
