package com.rouge.test.service;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.rouge.test.dao.IWorksDAO;
import com.rouge.test.entity.DeleteHelper;
import com.rouge.test.entity.Works;
import com.rouge.test.service.impl.WorksService;

@RunWith(SpringRunner.class)
public class WorkServiceTest {

	@TestConfiguration
    static class WorkServiceTestContextConfiguration {
  
        @Bean
        public IWorksService worksService() {
            return new WorksService();
        }
    }
	
	@Autowired
    private WorksService worksService;
 
    @MockBean
    private IWorksDAO worksDAO;
    
    @Test
    public void whenGetAllWorks_thenFound() {

    	ResponseEntity<?> works = worksService.getAllWorks(0, 5, "workName");
    	
    	assertEquals(HttpStatus.OK, works.getStatusCode());
    }
    
    @Test
    public void whenAddWork_thenWorkShouldBeFound() {
    	Works work = new Works();
    	work.setWorkName("IT Add Work 1");
    	work.setStartingDate(new Timestamp(System.currentTimeMillis()));
    	work.setEndingDate(new Timestamp(System.currentTimeMillis()));
    	work.setStatus("Planning");
    	ResponseEntity<?> workAdded = worksService.addWork(work);
    	
    	assertEquals(HttpStatus.OK, workAdded.getStatusCode());
    }
    
    @Test
    public void whenUpdateWork_thenWorkShouldBeFound() {
    	Works work = new Works();
    	work.setId(12);
    	work.setWorkName("IT Add Work 2");
    	work.setStartingDate(new Timestamp(System.currentTimeMillis()));
    	work.setEndingDate(new Timestamp(System.currentTimeMillis()));
    	work.setStatus("Planning");
    	ResponseEntity<?> workAdded = worksService.updateWork(work);
    	
    	assertEquals(HttpStatus.OK, workAdded.getStatusCode());
    }
    
    @Test
    public void whenDeleteWorks_thenDeleted() {
    	DeleteHelper delHelper = new DeleteHelper();
    	delHelper.setIds(new int[] {11,12});
    	
    	ResponseEntity<?> deleteWork = worksService.deleteWorks(delHelper.getIds());
    	
    	assertEquals(HttpStatus.OK, deleteWork.getStatusCode());
    }
}
