package com.rouge.test.API;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Timestamp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rouge.test.entity.DeleteHelper;
import com.rouge.test.entity.Works;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class WorkControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Test
	public void testGetAllWorks() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders
				.get("/api/v1/api-works")
				.param("pageNo", "0")
				.param("pageSize", "5")
				.param("sortBy", "workName"))
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.data").exists())
		.andExpect(MockMvcResultMatchers.jsonPath("$.data.content[*]").exists());				
	}

	@Test
	public void testAddWork() throws Exception {
		
		Works work = new Works();
		work.setWorkName("Test Add Work");
		work.setStartingDate(new Timestamp(System.currentTimeMillis()));
		work.setEndingDate(new Timestamp(System.currentTimeMillis()));
		work.setStatus("Planning");
		
		String content = objectMapper.writeValueAsString(work);
		
		mockMvc.perform(MockMvcRequestBuilders
				.post("/api/v1/api-works")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(content)).andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.data.workName").value("Test Add Work"));
	}
	
	@Test
	public void testUpdateWork() throws Exception {
		
		Works work = new Works();
		work.setId(4);
		work.setWorkName("Test Add Work - Update for 44");
		work.setStartingDate(new Timestamp(System.currentTimeMillis()));
		work.setEndingDate(new Timestamp(System.currentTimeMillis()));
		work.setStatus("Planning");
		
		String content = objectMapper.writeValueAsString(work);
		
		mockMvc.perform(MockMvcRequestBuilders
				.put("/api/v1/api-works")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(content)).andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.data.workName").value("Test Add Work - Update for 44"));
	}

	@Test
	public void testDeleteWorks() throws Exception {
		
		DeleteHelper delHelper = new DeleteHelper();
		int[] ids = {4,5,6,7,8};
		delHelper.setIds(ids);
		String content = objectMapper.writeValueAsString(delHelper);
		
		mockMvc.perform(MockMvcRequestBuilders
				.delete("/api/v1/api-works")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(content)).andExpect(status().isOk());
	}
	
}
