package com.rouge.test.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.rouge.test.entity.Works;

@Repository
public interface IWorksDAO extends PagingAndSortingRepository<Works, Integer> {

}
