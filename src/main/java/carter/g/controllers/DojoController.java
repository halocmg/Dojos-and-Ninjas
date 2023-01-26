package carter.g.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import carter.g.models.Dojo;
import carter.g.services.DojoService;



@Controller
@RequestMapping("/dojos")
public class DojoController {

	@Autowired
	private DojoService dojoService;
	public DojoController(DojoService dojoService) {
		this.dojoService = dojoService;
	}
	// Initializing service
	
	@RequestMapping("/")
	public String showHome(Model model) {
		model.addAttribute("dojos", dojoService.getAll());
		return "home.jsp";
	}
	// Displaying the home page
	
	@RequestMapping("/new")
	public String showForm(@ModelAttribute("dojo") Dojo dojo) {
		return "dojoForm.jsp";
	}
	// Displays the form for a new dojo
	
	@PostMapping("/new")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo,
								BindingResult result,
								RedirectAttributes flash, @RequestParam("name") String name) {
		if(result.hasErrors()) {
			flash.addFlashAttribute("errs", result.getAllErrors());
			return "redirect:/dojos/new";
		}
		dojo.setName(name);
		dojoService.createDojo(dojo);
		return "redirect:/dojos/";	
	}
	// Creating a new dojo
	
	@RequestMapping("show/{id}")
	public String displayDojo(@PathVariable Long id, Model model) {
		Dojo dojo = dojoService.getOneById(id);
		model.addAttribute("dojo", dojo);
		model.addAttribute("ninjas", dojo.getNinjas());
		return "singleDojo.jsp";
	}
	// Displays one dojo
}
