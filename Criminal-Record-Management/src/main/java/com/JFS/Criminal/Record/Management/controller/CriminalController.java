package com.JFS.Criminal.Record.Management.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.JFS.Criminal.Record.Management.dto.CriminalDTO;
import com.JFS.Criminal.Record.Management.exception.RoleNotAvailableException;
import com.JFS.Criminal.Record.Management.service.CriminalService;

@Controller
public class CriminalController {

	@Autowired
	private CriminalService criminalService;
	@RequestMapping(value = "/criminalRegPg", method = RequestMethod.GET)
	public String addCriminal(Model model)
	{
		model.addAttribute("criminalObj", new CriminalDTO());
		return "criminalRegPg";
	}
	@RequestMapping(value = "/criminalRegPg",method = RequestMethod.POST)
	public String registerCriminal(CriminalDTO criminalDTO) throws RoleNotAvailableException
	{
		criminalService.addCriminal(criminalDTO);
		return "jailSuperiHomePg";
	}
	
	
}
