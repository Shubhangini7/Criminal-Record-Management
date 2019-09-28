package com.JFS.Criminal.Record.Management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.JFS.Criminal.Record.Management.repository.CriminalRepository;

@Controller
public class DeleteCriminal {

	@Autowired
	private CriminalRepository criminalRepository; 
	
	@RequestMapping("/delete/{id}")
	public String deleteCriminal(@PathVariable(name = "id") Long id)
	{
		criminalRepository.deleteById(id);
		return "jailSuperiHomePg";
		
	}
}
