package com.JFS.Criminal.Record.Management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.JFS.Criminal.Record.Management.dto.CbiDTO;
import com.JFS.Criminal.Record.Management.exception.RoleNotAvailableException;
import com.JFS.Criminal.Record.Management.service.CbiService;

@Controller
@RequestMapping("/cbiRegPg")
public class CBIContrller {

	@Autowired
	private CbiService cbiService;
	@GetMapping
	public String addCbi(Model model)
	{
		model.addAttribute("cbiObj", new CbiDTO());
		return "cbiRegPg";
	}
	@PostMapping
	public String registerCbi(CbiDTO cbiDTO) throws RoleNotAvailableException
	{
		cbiService.addCbiOfficer(cbiDTO);
		return "homePg";
	}
}
