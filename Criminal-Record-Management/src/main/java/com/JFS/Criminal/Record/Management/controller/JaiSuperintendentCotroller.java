package com.JFS.Criminal.Record.Management.controller;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.JFS.Criminal.Record.Management.dto.CriminalDTO;
import com.JFS.Criminal.Record.Management.dto.JailSuperintendentDTO;
import com.JFS.Criminal.Record.Management.dto.mapper.CriminalMapper;
import com.JFS.Criminal.Record.Management.entity.Criminal;
import com.JFS.Criminal.Record.Management.entity.JailSuperintendent;
import com.JFS.Criminal.Record.Management.exception.RoleNotAvailableException;
import com.JFS.Criminal.Record.Management.repository.CredentialRepository;
import com.JFS.Criminal.Record.Management.repository.CriminalRepository;
import com.JFS.Criminal.Record.Management.repository.JailSuperiRepository;
import com.JFS.Criminal.Record.Management.service.CriminalService;
import com.JFS.Criminal.Record.Management.service.JailSupriService;

import antlr.collections.List;

@Controller
public class JaiSuperintendentCotroller {

	@Autowired
	private JailSuperiRepository jailSuperiRepository;
	@Autowired
	private CriminalRepository criminalRepository;
	
	@Autowired
	private JailSupriService jailSupriService;
	@RequestMapping(value = "/jailSuperiRegPg", method = RequestMethod.GET)
	public String addJailSupri(Model model)
	{
		model.addAttribute("jailSuperObj", new JailSuperintendentDTO());
		return "jailSuperiRegPg";
	}
	@RequestMapping(value = "/jailSuperiRegPg", method = RequestMethod.POST)
	public String registerJailSuperi(JailSuperintendentDTO jDto) throws RoleNotAvailableException 
	{
		jailSupriService.addJailSuper(jDto);
		return "homePg";
	}
	
	
}

