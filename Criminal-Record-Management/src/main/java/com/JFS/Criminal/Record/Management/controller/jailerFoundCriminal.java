package com.JFS.Criminal.Record.Management.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.JFS.Criminal.Record.Management.dto.CriminalDTO;
import com.JFS.Criminal.Record.Management.entity.Criminal;
import com.JFS.Criminal.Record.Management.exception.RoleNotAvailableException;
import com.JFS.Criminal.Record.Management.repository.CriminalRepository;
import com.JFS.Criminal.Record.Management.service.CriminalService;

@Controller
@RequestMapping("/crimialFound")
public class jailerFoundCriminal {

	@Autowired
	private CriminalRepository criminalRepository;

	@Autowired
	private CriminalService criminalService;

	
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
            return "redirect:/jailorfoundCriminal";
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
	        return "jailorfoundCriminal";
	    }

}
