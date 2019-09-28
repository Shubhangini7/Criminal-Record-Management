package com.JFS.Criminal.Record.Management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.JFS.Criminal.Record.Management.entity.Criminal;
import com.JFS.Criminal.Record.Management.repository.CriminalRepository;

@Controller
public class UpdateCriminal {

	@Autowired
	private CriminalRepository criminalRepository; 
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showUpdatePg(@PathVariable(name = "id") Long id)
	{
		ModelAndView mav = new ModelAndView("updateCriminal");
		Criminal criminal = criminalRepository.getOne(id);
		mav.addObject("criminal", criminal);
		return mav;
	}
	
}
