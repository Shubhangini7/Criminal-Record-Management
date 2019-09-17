package com.JFS.Criminal.Record.Management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.JFS.Criminal.Record.Management.dto.JudgeDTO;


@Controller
@RequestMapping("/judgeRegiPg")
public class JudgeController {

	@GetMapping
	public String addJudge(Model model)
	{
		model.addAttribute("judgeObj", new JudgeDTO());
		return "judgeRegiPg";
	}
}
