package com.example.restservice;


import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import com.example.restservice.model.NumberOperationResponseModel;
import com.example.restservice.model.Result;
import com.example.restservice.model.Status;
import com.example.restservice.service.NumberOperationService;
import com.sun.tools.javac.code.Attribute.Array;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.MOCK, classes={ RestServiceApplication.class })
public class NumberOperationControllerTest {

  private MockMvc mockMvc;

  @Autowired
  private WebApplicationContext webApplicationContext;

  @MockBean 
  private NumberOperationService numberOperationServiceMock;

  @Before
  public void setUp() {
    this.mockMvc = webAppContextSetup(webApplicationContext).build();
  }
  
  @Test
	public void shouldPerformNumberOperation() throws Exception {
		NumberOperationResponseModel numberOperationResponseModel =new NumberOperationResponseModel();
		int arr[]= {2};
		Result result=new Result(3,1.5,arr);
		numberOperationResponseModel.setStatus(Status.SUCCESS);
		numberOperationResponseModel.setResults(result);
		when(numberOperationServiceMock.operateOnNumbers(any())).thenReturn(numberOperationResponseModel);
	  
	 mockMvc.perform(post("/web/api/numberoperations")
	           .contentType(MediaType.APPLICATION_JSON)
	           .content("{\"input\" : [1,2] }") 
	           .accept(MediaType.APPLICATION_JSON))
	           .andExpect(status().isOk())
	           .andExpect(jsonPath("$.status").value("SUCCESS")) 
	           .andExpect(jsonPath("$.results.sum").value(3))
	 			.andExpect(jsonPath("$.results.avg").value(1.5))
	 			.andExpect(jsonPath("$.results.greaterThanAverage").value(2));

	}
  
}