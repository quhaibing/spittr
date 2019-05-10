package spittr.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceView;

import spittr.Spittle;
import spittr.data.SpittleRepository;

public class SpittleControllerTest {

	@Test
	public void shouldShowRecentSpittles() throws Exception {

		List<Spittle> expectedSpittles = createSpittleList(20);
		SpittleRepository mockRepository = Mockito.mock(SpittleRepository.class);

		Mockito.when(mockRepository.findSpittles(Long.MAX_VALUE, 20))
	        .thenReturn(expectedSpittles);
		
		SpittleController spittleController = new SpittleController(mockRepository);

		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(spittleController)
				.setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp"))
				.build();

		mockMvc.perform(MockMvcRequestBuilders.get("/spittles"))
				.andExpect(MockMvcResultMatchers.view().name("spittles"))
				.andExpect(MockMvcResultMatchers.model().attributeExists("spittleList"))
				.andExpect(MockMvcResultMatchers.model().attribute("spittleList", 
						Matchers.hasItems(expectedSpittles.toArray())));
	}

	List<Spittle> createSpittleList(int count) {
		List<Spittle> spittles = new ArrayList<Spittle>();

		for (int i = 0; i < count; i++) {
			spittles.add(new Spittle(Long.parseLong(i + ""), "Spittle " + i, new Date()));
		}

		return spittles;
	}

}
