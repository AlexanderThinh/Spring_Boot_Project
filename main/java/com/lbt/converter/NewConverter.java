package com.lbt.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lbt.dto.NewDTO;
import com.lbt.entity.CategoryEntity;
import com.lbt.entity.NewEntity;
import com.lbt.repository.ICategoryRepository;

@Component
public class NewConverter {
	
	public NewEntity toNewEntity(NewDTO dto) {
		NewEntity newEntity = new NewEntity();
		
		newEntity.setTitle(dto.getTitle());
		newEntity.setContent(dto.getContent());
		newEntity.setShortDesc(dto.getShortDescription());
		newEntity.setThumnail(dto.getThumbnail());
		
		return newEntity;
	}
	
	public NewDTO toDTO(NewEntity newEntity) {
		NewDTO newDTO = new NewDTO();
		
		if(newEntity.getId() != null) {
			newDTO.setId(newEntity.getId());
		}
		
		newDTO.setTitle(newEntity.getTitle());
		newDTO.setContent(newEntity.getContent());
		newDTO.setShortDescription(newEntity.getShortDesc());
		newDTO.setThumbnail(newEntity.getThumnail());
		newDTO.setCreatedBy(newEntity.getCreatedBy());
		newDTO.setCreatedDate(newEntity.getCreatedDate());
		newDTO.setModifiedBy(newEntity.getModifiedBy());
		newDTO.setModifiedDate(newEntity.getModifiedDate());
		
		return newDTO;
	}
	
	public NewEntity updateNewEntity(NewDTO dto, NewEntity newEntity) {		
		newEntity.setTitle(dto.getTitle());
		newEntity.setContent(dto.getContent());
		newEntity.setShortDesc(dto.getShortDescription());
		newEntity.setThumnail(dto.getThumbnail());
		
		return newEntity;
	}
}
