package com.rouge.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rouge.test.dao.IWorksDAO;
import com.rouge.test.entity.Works;
import com.rouge.test.service.IWorksService;
import com.rouge.test.utils.Utils;

@Service
@Transactional
public class WorksService implements IWorksService {

	@Autowired
	IWorksDAO worksDAO;
	
	@Override
	public ResponseEntity<?> getAllWorks() {
		try {
			List<Works> works = (List<Works>) worksDAO.findAll();
			return Utils.generateSuccessResponse(works);
		} catch (Exception e) {
			return Utils.generateFailedResponse(e.getMessage());
		}		
	}

	@Override
	public ResponseEntity<?> getAllWorks(Integer pageNo, Integer pageSize, String sortedBy) {
		try {
			Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortedBy).ascending());
			Page<Works> pages = worksDAO.findAll(pageable);

			return Utils.generateSuccessResponse(pages);
		} catch (Exception e) {
			return Utils.generateFailedResponse(e.getMessage());
		}
	}

	@Override
	public ResponseEntity<?> addWork(Works work) {
		work = worksDAO.save(work);
		return Utils.generateSuccessResponse(work);
	}

	@Override
	public ResponseEntity<?> updateWork(Works work) {
		work = worksDAO.save(work);				
		return Utils.generateSuccessResponse(work);
	}

	@Override
	public ResponseEntity<?> deleteWorks(int[] ids) {
		for (int i = 0; i < ids.length; i++) {
			worksDAO.deleteById(ids[i]);
		}
		
		return Utils.generateSuccessResponse("Delete successful");
	}
}
