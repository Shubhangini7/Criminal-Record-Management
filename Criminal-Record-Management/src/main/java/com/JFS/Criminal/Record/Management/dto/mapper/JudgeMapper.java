package com.JFS.Criminal.Record.Management.dto.mapper;

import com.JFS.Criminal.Record.Management.dto.JudgeDTO;
import com.JFS.Criminal.Record.Management.entity.Credential;
import com.JFS.Criminal.Record.Management.entity.Judge;
import com.JFS.Criminal.Record.Management.entity.User;

public class JudgeMapper {
	
	public static Judge toEntity(JudgeDTO dto) {
		Judge register = new Judge();
		register.setCode(dto.getCode());
		register.setName(dto.getName());
		register.setEmail(dto.getEmail());
		register.setPhone(dto.getPhone());
		register.setCourtName(dto.getCourtName());
		register.setPassword(dto.getPassword());
		return 	register;
		
	}
	
	public static User toUserEntity(JudgeDTO dto) {
		User judge = new User();
		judge.setPassword(dto.getPassword());
		return judge;
		
	}
	
	public static Credential toCredentialEntity(JudgeDTO dto) {
		Credential credential = new Credential();
		credential.setUsername(dto.getUsername());
		credential.setPassword(dto.getPassword());
		return credential;
		
	}

}
