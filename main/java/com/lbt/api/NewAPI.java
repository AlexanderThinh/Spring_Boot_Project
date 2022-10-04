package com.lbt.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lbt.api.output.NewsOutput;
import com.lbt.dto.NewDTO;
import com.lbt.service.INewService;

@RestController
public class NewAPI {
	@Autowired
	private INewService newService;
	
	@GetMapping(value = "/new")
	public NewsOutput getNews(@RequestParam("page") int page, 
				@RequestParam("limit") int limit) {
//		limit ~ tong so item/1 page; page ~ current page number
		NewsOutput result = new NewsOutput();
		
		Pageable pageable = new PageRequest(page -1, limit);
		int totalPage = (int) Math.ceil((double) ((newService.totalItem()) / limit));
		
		result.setPage(page);
		result.setTotalPage(totalPage);
		result.setListResult(newService.getAll(pageable));

		return result;
	}
	
	@PostMapping(value = "/new")
	public NewDTO createNew(@RequestBody NewDTO model) {
		
		return newService.createNews(model);
	}
	
	@PutMapping(value = "/new/{newsID}")
	public NewDTO updateNew(@RequestBody NewDTO model, @PathVariable("newsID") Long newsID) {
		model.setId(newsID);
		
		return newService.updateNews(model);
	}
	
	@DeleteMapping(value = "/new")
	public void deleteNews(@RequestBody long[] ids) {
		newService.deleteNews(ids);
	}
	
	@DeleteMapping(value = "/new/{newsID}")
	public void deleteNewByID(@PathVariable("newsID") long newsID) {
		newService.deleteNewByID(newsID);
	}
}
