package com.rouge.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rouge.test.entity.Works;
import com.rouge.test.service.IWorksService;

@RestController
@RequestMapping("/api/v1/")
public class WorkController {

	@Autowired
	IWorksService worksService;
	
	@GetMapping("/api-works")
	public ResponseEntity<?> getAllWorks() {
		return worksService.getAllWorks();
	}
	
	@PostMapping("/api-works")
	public ResponseEntity<?> addWork(@RequestBody Works work) {
		return worksService.addWork(work);
	}
	
	@PutMapping("/api-works")
	public ResponseEntity<?> updateWork(@RequestBody Works work) {
		return worksService.updateWork(work);
	}
	
	@DeleteMapping("/api-works")
	public ResponseEntity<?> deleteWorks(@RequestBody int[] ids) {
		return worksService.deleteWorks(ids);
	}
}
