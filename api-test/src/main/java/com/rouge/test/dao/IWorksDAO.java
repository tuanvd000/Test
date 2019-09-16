package com.rouge.test.dao;

import org.springframework.data.repository.CrudRepository;

import com.rouge.test.entity.Works;

public interface IWorksDAO extends CrudRepository<Works, Integer> {

}
