package spittr.web;



import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.lang.reflect.Field;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spittr.Spitter;
import spittr.data.SpitterRepository;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

	private SpitterRepository spitterRepository;

	//Listing 5.17
	@Autowired
	public SpitterController(SpitterRepository spitterRepository) {
		this.spitterRepository = spitterRepository;
	}

	// Listing 5.13
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegistrationForm() {
		return "registerForm";
	}
	
	//Listing 5.17
	//TODO: add validation logic from listing 5.19
	@RequestMapping(value = "/register", method = POST)
	public String processRegistration(@Valid Spitter spitter, Errors errors) {
		if (errors.hasErrors()) {
			return "registerForm";
			}
		spitterRepository.save(spitter);
		return "redirect:/spitter/" + spitter.getUsername();
	}
	
//	@RequestMapping(value = "/register", method = POST)
//	public String processRegistration(HttpServletRequest req) {//how does it get Spitter object???????????????????????
//														// the book does not explain 
//		String username = req.getParameter("username");
//		String password = req.getParameter("password");
//		String lastName = req.getParameter("lastName");
//		String firstName = req.getParameter("firstName");
//		Spitter spitter = new Spitter(username, password, firstName, lastName);
//				
//		spitterRepository.save(spitter);
//		return "redirect:/spitter/" + spitter.getUsername();
//	}
	
	//handels above redirection 
	@RequestMapping(value = "/{username}", method = GET)
	public String showSpitterProfile(@PathVariable String username, Model model) {
		Spitter spitter = spitterRepository.findByUsername(username);
		model.addAttribute(spitter);
		return "profile";
	}

}
