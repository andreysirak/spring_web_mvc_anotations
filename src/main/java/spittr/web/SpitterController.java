package spittr.web;



import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import spittr.Spitter;
//import spittr.data.SpitterRepository;
@Controller
@RequestMapping("/spitter")

public class SpitterController {
	
	
	//Listing 5.13
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String showRegistrationForm() {
	return "registerForm";
	}


}
