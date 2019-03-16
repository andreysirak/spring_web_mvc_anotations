package spittr.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spittr.Spittle;
import spittr.data.SpittleRepository;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
	
	//throws "The value for annotation attribute RequestParam.defaultValue must be a constant expression"
	//private static final String MAX_LONG_AS_STRING = Long.toString(Long.MAX_VALUE);

	private SpittleRepository spittleRepository;

	@Autowired
	public SpittleController(SpittleRepository spittleRepository) {
		this.spittleRepository = spittleRepository;
 
	}

	//Listing 5.10 tested by shouldShowRecentSpittles() from Listing 5.9
//	@RequestMapping(method = RequestMethod.GET)
//	public String spittles(Model model) {
//		model.addAttribute(spittleRepository.findSpittles(Long.MAX_VALUE, 20));
//		return "spittles";
//	}
	
	
	//page 150
//	@RequestMapping(method = RequestMethod.GET)
//	public List<Spittle> spittles(@RequestParam("max") long max, @RequestParam("count") int count) {
//		return spittleRepository.findSpittles(max, count);
//	}

	//page 151
	@RequestMapping(method = RequestMethod.GET)
	public List<Spittle> spittles(@RequestParam(value = "max", defaultValue = "9223372036854775807") long max,
			@RequestParam(value = "count", defaultValue = "20") int count) {
		return spittleRepository.findSpittles(max, count);
	}
	
	//page 151 same like for the previous one. Used for query parameters like /spittles/show?spittle_id=12345.
//	@RequestMapping(value = "/show", method = RequestMethod.GET)
//	public String showSpittle(@RequestParam("spittle_id") long spittleId, Model model) {
//		model.addAttribute(spittleRepository.findOne(spittleId));
//		return "spittle";
//	}
	
	@RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
	public String spittle(@PathVariable long spittleId, Model model) {
		model.addAttribute(spittleRepository.findOne(spittleId));
		return "spittle";
	}

}
