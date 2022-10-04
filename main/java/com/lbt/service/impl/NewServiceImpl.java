package com.lbt.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lbt.converter.NewConverter;
import com.lbt.dto.NewDTO;
import com.lbt.entity.CategoryEntity;
import com.lbt.entity.NewEntity;
import com.lbt.repository.ICategoryRepository;
import com.lbt.repository.INewRepository;
import com.lbt.service.INewService;

@Service
public class NewServiceImpl implements INewService {
	@Autowired
	private INewRepository newRepository;
	
	@Autowired
	private ICategoryRepository categoryRepository;
	
	@Autowired
	private NewConverter newConverter;

	@Override
	public NewDTO createNews(NewDTO newDTO) {
		CategoryEntity category = categoryRepository.findOneByCode(newDTO.getCategoryCode());
			
		//Convert NewDTO to NewEntity to save database
		NewEntity newEntity = newConverter.toNewEntity(newDTO);
		newEntity.setCategory(category);
		
		newEntity = newRepository.save(newEntity);
		
		return newConverter.toDTO(newEntity);
	}

	@Override
	public NewDTO updateNews(NewDTO newDTO) {
		NewEntity oldNewsEntity = newRepository.findOne(newDTO.getId());
		
		CategoryEntity category = categoryRepository.findOneByCode(newDTO.getCategoryCode());
		
		NewEntity newNewsEntity = newConverter.updateNewEntity(newDTO, oldNewsEntity);
		newNewsEntity.setCategory(category);
		
		newNewsEntity = newRepository.save(newNewsEntity);
		
		return newConverter.toDTO(newNewsEntity);
	}

	@Override
	public void deleteNews(long[] ids) {
		for(long item: ids) {
			newRepository.delete(item);
		}
		
	}

	@Override
	public void deleteNewByID(long id) {
		newRepository.delete(id);
	}

	@Override
	public List<NewDTO> getAll(Pageable pageable) {
		List<NewDTO> result = new ArrayList<>();
		List<NewEntity> newsEntities = newRepository.findAll(pageable).getContent();
		
		for(NewEntity item:newsEntities) {
			NewDTO newDTO = newConverter.toDTO(item);
			result.add(newDTO);
		}
		
		return result;
	}

	@Override
	public int totalItem() {
		return (int) newRepository.count();
	}
}
