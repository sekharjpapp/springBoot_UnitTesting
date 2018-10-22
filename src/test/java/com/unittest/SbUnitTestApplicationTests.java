package com.unittest;

import com.unittest.repository.UsersRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

@RunWith(SpringRunner.class)
@WebMvcTest
public class SbUnitTestApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	UsersRepository usersRepository;

	@Test
	public void contextLoads() throws Exception {

        when(usersRepository.findAll()).thenReturn(
                Collections.emptyList()
        );

	MvcResult mvcResult= mockMvc.perform(

			MockMvcRequestBuilders.get("/all/")
				.accept(MediaType.APPLICATION_JSON)).andReturn();

        System.out.println(mvcResult.getResponse());
	verify(usersRepository).findAll();

	}

}
