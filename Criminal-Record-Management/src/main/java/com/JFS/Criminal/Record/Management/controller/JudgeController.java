package com.JFS.Criminal.Record.Management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.JFS.Criminal.Record.Management.dto.JudgeDTO;
import com.JFS.Criminal.Record.Management.exception.RoleNotAvailableException;
import com.JFS.Criminal.Record.Management.service.JudgeService;


@Controller
@RequestMapping("/judgeRegPg")
public class JudgeController {

	@Autowired
	private JudgeService judgeService;
	@GetMapping
	public String addJudge(Model model)
	{
		model.addAttribute("judgeObj", new JudgeDTO());
		return "judgeRegPg";
	}
	@PostMapping
	public String registerJudge(JudgeDTO judgeDTO) throws RoleNotAvailableException
	{
		judgeService.addJudge(judgeDTO);
		return "homePg";
	}
}
