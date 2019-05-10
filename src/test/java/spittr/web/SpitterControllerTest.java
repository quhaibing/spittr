package spittr.web;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import spittr.data.SpittleRepository;

/**
 * 
 * 
 * @author HB
 *
 */
public class SpitterControllerTest {

	@Test
	public void shouldShowRegistration() throws Exception {
		SpittleRepository mockRepository = Mockito.mock(SpittleRepository.class);
		SpitterController spittleController = new SpitterController(mockRepository);

		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(spittleController).build();
		mockMvc.perform(MockMvcRequestBuilders.get("/spitter/register"))
				.andExpect(MockMvcResultMatchers.view().name("registerForm"));
	}
	
	

}
