package com.JFS.Criminal.Record.Management.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.JFS.Criminal.Record.Management.dto.LoginDTO;
import com.JFS.Criminal.Record.Management.entity.Credential;
import com.JFS.Criminal.Record.Management.entity.User;
import com.JFS.Criminal.Record.Management.exception.UserNotExistException;
import com.JFS.Criminal.Record.Management.service.AcountService;

@Controller
@RequestMapping("/loginPg")
public class AccountController {

	@Autowired
    private AcountService acountService;

    @GetMapping
    public String loginpage(Model model)
    {
        model.addAttribute("loginDTO",new LoginDTO());
        return "loginPg";
    }
    
    @PostMapping
    public String login(LoginDTO loginDTO, Model model, HttpSession session) throws UserNotExistException 
    {
        Credential credential =acountService.performLoginAndFetchRole(loginDTO);
        User user =credential.getUser();
        session.setAttribute("userid",credential.getUser().getUserid());
        String rolename=credential.getRoles().stream().findFirst().get().getName();
        String uiname="";
        switch (rolename)
        {
            case "ROLE_JUDGE":
                uiname="judgeHomePg";
                break;
            case "ROLE_CBIOFFICER":
                uiname="cbiHomePg";
                break;
            case "ROLE_POLICE_OFFICER":
                uiname="policeHomePg";
                break;
            case "ROLE_JAIL_SUPERINTENDENT":
                uiname = "jailSuperiHomePg";
        }
        model.addAttribute("username",credential.getUsername());
        System.out.println(credential.getPassword()+"this is passward.........................................");
        return uiname;
    }
}
