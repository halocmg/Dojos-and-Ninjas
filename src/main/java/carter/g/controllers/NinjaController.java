package carter.g.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import carter.g.models.Ninja;
import carter.g.services.DojoService;
import carter.g.services.NinjaService;

@Controller
@RequestMapping("/ninjas/")
public class NinjaController {
	
	@Autowired
	private DojoService dojoService;
	
	@Autowired
	private NinjaService ninjaService;
	public NinjaController(NinjaService ninjaService) {
		this.ninjaService = ninjaService;
	}
	// Setting up our services

	@RequestMapping("")
	public String redirectToHome() {
		return "redirect:/dojos/";
	}
	// Redirects them to home
	
	@RequestMapping("new")
	public String displayForm(@ModelAttribute("ninja") Ninja ninja, Model model) {
		model.addAttribute("dojos", dojoService.getAll());
		return "ninjaForm.jsp";
	}
	// Displays the form for adding a ninja
	
	@PostMapping("new")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, 
								BindingResult result, 
								RedirectAttributes flash) {
		if(result.hasErrors()) {
			flash.addFlashAttribute("errs", result.getAllErrors());
			return "redirect:/ninjas/new";
		}
		ninjaService.createNinja(ninja);
		return "redirect:/dojos/show/" + ninja.getDojo().getId();
	}
	// Creates a ninja
}
