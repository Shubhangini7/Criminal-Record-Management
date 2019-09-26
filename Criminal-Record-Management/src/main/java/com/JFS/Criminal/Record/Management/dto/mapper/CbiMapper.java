package com.JFS.Criminal.Record.Management.dto.mapper;

import com.JFS.Criminal.Record.Management.dto.CbiDTO;
import com.JFS.Criminal.Record.Management.entity.CBIOfficers;
import com.JFS.Criminal.Record.Management.entity.Credential;
import com.JFS.Criminal.Record.Management.entity.User;

public class CbiMapper {
	public static CBIOfficers toEntity(CbiDTO dto) {
		CBIOfficers register = new CBIOfficers();
		register.setCode(dto.getCode());
		register.setName(dto.getName());
		register.setEmail(dto.getEmail());
		register.setPhone(dto.getPhone());
		register.setUnit(dto.getUnit());
		return 	register;
		
	}
	
	public static User toUserEntity(CbiDTO dto) {
		User cbiUser = new User();
		return cbiUser;
	}
	
	public static Credential toCredentialEntity(CbiDTO dto) {
		Credential credential = new Credential();
		credential.setUsername(dto.getUsername());
		credential.setPassword(dto.getPassword());
		return credential;		
	}

}
