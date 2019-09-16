package com.rouge.test.service;

import org.springframework.http.ResponseEntity;

import com.rouge.test.entity.Works;

public interface IWorksService {

	ResponseEntity<?> getAllWorks();
	ResponseEntity<?> getAllWorks(Integer pageNo, Integer pageSize, String sortedBy);
	ResponseEntity<?> addWork(Works work);
	ResponseEntity<?> updateWork(Works work);
	ResponseEntity<?> deleteWorks(int[] ids);
 }
