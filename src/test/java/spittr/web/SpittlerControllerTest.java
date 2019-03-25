package spittr.web;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

import static org.junit.Assert.assertEquals;
import static org.hamcrest.Matchers.hasItems;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import spittr.Spitter;
import spittr.Spittle;
import spittr.data.SpitterRepository;
import spittr.data.SpittleRepository;
import spittr.web.HomeController;

public class SpittlerControllerTest {
	
	
	//Listing 5.14 to test method from listing 
	@Test
	public void shouldShowRegistration() throws Exception {
		SpitterRepository mockRepository = mock(SpitterRepository.class); //added this one after SpitterReposiorty was injected for post method
		SpitterController controller = new SpitterController(mockRepository);
		MockMvc mockMvc = standaloneSetup(controller).build();
		mockMvc.perform(get("/spitter/register")).andExpect(view().name("registerForm"));
	}
	
	//Listing 5.16
	@Test
	public void shouldProcessRegistration() throws Exception {
		SpitterRepository mockRepository = mock(SpitterRepository.class);
		Spitter unsaved = new Spitter("jbauer", "24hours", "Jack", "Bauer");
		Spitter saved = new Spitter(24L, "jbauer", "24hours", "Jack", "Bauer");		
		when(mockRepository.save(unsaved)).thenReturn(saved);		
		SpitterController controller = new SpitterController(mockRepository);
		MockMvc mockMvc = standaloneSetup(controller).build();
		mockMvc.perform(post("/spitter/register").param("firstName", "Jack").param("lastName", "Bauer")
				.param("username", "jbauer").param("password", "24hours")).andExpect(redirectedUrl("/spitter/jbauer"));
		mockMvc.perform(post("/spitter/register").param("firstName", "J").param("lastName", "r")
				.param("username", "r").param("password", "s")).andExpect((view().name("registerForm")));
		
		verify(mockRepository, atLeastOnce()).save(unsaved);
	}


}
