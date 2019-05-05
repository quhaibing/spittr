package spittr.web;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import spittr.web.HomeController;

/**
 * 
 * home 控制器单元测试用例
 * 
 * @author HB
 */
public class HomeControllerTest {

	@Test
	public void testHomePage() throws Exception {
		
		HomeController controller = new HomeController();

		/**
		 * 只测试了 home 方法中会发生什么，没有站在 Spring Mvc 控制器的角度进行测试
		 */
		// Assert.assertEquals("home", controller.home());

		/**
		 * 测试了接收到针对"/"的 GET 方法请求时会调用 home 方法，并得到期望的视图名称
		 */
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(MockMvcResultMatchers.view().name("home"));

	}

}
