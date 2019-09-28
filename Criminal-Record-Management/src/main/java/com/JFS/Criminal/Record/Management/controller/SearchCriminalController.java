package com.JFS.Criminal.Record.Management.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.JFS.Criminal.Record.Management.dto.CriminalDTO;
import com.JFS.Criminal.Record.Management.entity.Criminal;
import com.JFS.Criminal.Record.Management.exception.RoleNotAvailableException;
import com.JFS.Criminal.Record.Management.repository.CriminalRepository;
import com.JFS.Criminal.Record.Management.service.CriminalService;

@Controller
@RequestMapping("/searchCriminal")
public class SearchCriminalController {

	@Autowired
	private CriminalRepository criminalRepository;


	
	@GetMapping
	public String search(Model model)
    {
        model.addAttribute("search", new CriminalDTO());
        return "searchCriminal";
    }
	
	@PostMapping
    public String search(@RequestParam(value = "criminalName") String criminalName ,Model model)
    {
        model.addAttribute("search",new CriminalDTO());
        if (criminalName != null)
        {
            Criminal criminal=criminalRepository.findByCriminalName(criminalName).get();
            model.addAttribute("searchObj", criminal);
            return "redirect:/foundCriminal";
        }
        return "homePg";
    }
	 @PostMapping("/foundCriminal")
	 @Transactional
	 public String foundCriminal(@RequestParam("criminalName") String criminalName, Model model)
	 {
	        Criminal criminal=criminalRepository.findByCriminalName(criminalName).get();
            model.addAttribute("searchObj", criminal);
	        model.addAttribute("cDTOobj",new CriminalDTO());
	        return "foundCriminal";
	    }
	
	 @RequestMapping("/transfer/{id}")
	 public ModelAndView showUpdatePg(@PathVariable(name = "id") Long id)
	 {
		 ModelAndView mav = new ModelAndView("transferCriminal");
		 Criminal criminal = criminalRepository.getOne(id);
		 mav.addObject("criminal", criminal);
		 return mav;
		}
}
