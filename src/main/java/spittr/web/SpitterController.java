package spittr.web;



import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.io.File;
import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import spittr.Spitter;
import spittr.data.SpitterRepository;

import javax.servlet.http.Part;

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
	//Model object is passed and then the object its self is set as attribute for form binding
	public String showRegistrationForm(Model model) {
		model.addAttribute(new Spitter());
		return "registerForm";
	}
	
//	@RequestMapping(value = "/register", method = RequestMethod.GET)
//	//Without Model object is passed there is now form binding
//	public String showRegistrationForm() {		
//		return "registerForm";
//	}
	
	//Listing 5.17
	//TODO: add validation logic from listing 5.19
	@RequestMapping(value = "/register", method = POST)
	public String processRegistration(@RequestPart("profilePicture") Part profilePicture, @Valid Spitter spitter, Errors errors) {		
		if (errors.hasErrors()) {
			return "registerForm";
			}
//		try {
//			profilePicture.write();
//		} catch (IOException e) {
//			
//			e.printStackTrace();
//		}
		System.out.println(spitter.toString());		
		spitterRepository.save(spitter);		
		return "redirect:/spitter/" + spitter.getUsername();
	}
	//here I played with HttpServletRequest
//	@RequestMapping(value = "/register", method = POST)
//	public String processRegistration(HttpServletRequest req) {
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
		if (!model.containsAttribute("spitter")) {
			model.addAttribute(spitterRepository.findByUsername(username));
			}
		//added above block of code from page 217 to handle flashAtribute redirect
		//Spitter spitter = spitterRepository.findByUsername(username);
		//model.addAttribute(spitter);
		return "profile";
	}
	
	//Page 215 
	//Model passed as argement so it's velues could be passed to model attribute and then attached to redirect: 	
	@RequestMapping(value = "/register_method_to_use_redirectAttributes", method = POST)
	public String processRegistration(Spitter spitter, RedirectAttributes model) {
		spitterRepository.save(spitter);
		model.addAttribute("username", spitter.getUsername());
		//because sitter.id is not set explicetly in path it'll be add as path virable /spitter/habuma?spitterId=42.
		model.addAttribute("spitterId", spitter.getId());
		//page 216
		model.addFlashAttribute("spitter", spitter);
		return "redirect:/spitter/{username}";
	}

}
