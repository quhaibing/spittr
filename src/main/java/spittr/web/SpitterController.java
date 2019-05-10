package spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import spittr.Spitter;
import spittr.data.SpittleRepository;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

	private SpittleRepository spittleRepository;

	@Autowired
	public SpitterController(SpittleRepository spittleRepository) {
		this.spittleRepository = spittleRepository;
	}

	@RequestMapping(value = "/register", method = GET)
	public String showRegistrationForm() {
		return "registerForm";
	}

	@RequestMapping(value = "/register", method = POST)
	public String processRegistration(@Valid Spitter spitter, Errors errors) {
		
		// 对输入值进行校验
//		if (errors.hasErrors()){
//			return "registerForm";
//		}
		
		spittleRepository.save(spitter);
		
		// 重定向
		return "redirect:/spitter/" + spitter.getUsername();
	}
	
	@RequestMapping(value = "/{username}", method = GET)
	public String showSpitterProfile(@PathVariable("username") String username, Model model){
		model.addAttribute(spittleRepository.findByUsername(username));
		return "profile";
	}

}
