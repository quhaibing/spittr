package spittr.test.web;

import org.junit.Assert;
import org.junit.Test;

import spittr.web.HomeController;

public class HomeControllerTest {

	@Test
	public void testHomePage() throws Exception{
		HomeController controller = new HomeController();
		Assert.assertEquals("home", controller.home());
	}
	
}
