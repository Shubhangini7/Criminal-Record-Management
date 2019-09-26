package com.JFS.Criminal.Record.Management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.JFS.Criminal.Record.Management.dto.JailSuperintendentDTO;
import com.JFS.Criminal.Record.Management.exception.RoleNotAvailableException;
import com.JFS.Criminal.Record.Management.service.JailSupriService;

@Controller
@RequestMapping("/jailSuperiRegPg")
public class JaiSuperintendentCotroller {

	@Autowired
	private JailSupriService jailSupriService;
	@GetMapping
	public String addJailSupri(Model model)
	{
		model.addAttribute("jailSuperObj", new JailSuperintendentDTO());
		return "jailSuperiRegPg";
	}
	@PostMapping
	public String registerJailSuperi(JailSuperintendentDTO jDto) throws RoleNotAvailableException 
	{
		jailSupriService.addJailSuper(jDto);
		return "homePg";

	}
}
