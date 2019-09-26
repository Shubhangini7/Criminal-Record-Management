package com.JFS.Criminal.Record.Management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.JFS.Criminal.Record.Management.dto.PoliceDTO;
import com.JFS.Criminal.Record.Management.exception.RoleNotAvailableException;
import com.JFS.Criminal.Record.Management.service.PoliceService;

@Controller
@RequestMapping("/policeRegPg")
public class PoliceCntroller {

	@Autowired
	private PoliceService policeService;
	@GetMapping
	public String addPolice(Model model)
	{
		model.addAttribute("policeObj", new PoliceDTO());
		return "policeRegPg";	
	}
	
	@PostMapping
	public String registerPolice(PoliceDTO policeDTO) throws RoleNotAvailableException
	{
		policeService.addPolice(policeDTO);
		return "homePg";
	}
	
}
