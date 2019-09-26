package com.JFS.Criminal.Record.Management.dto.mapper;

import com.JFS.Criminal.Record.Management.dto.PoliceDTO;
import com.JFS.Criminal.Record.Management.entity.Credential;
import com.JFS.Criminal.Record.Management.entity.PoliceOfficers;
import com.JFS.Criminal.Record.Management.entity.User;

public class PoliceMapper {
	public static PoliceOfficers toEntity(PoliceDTO policeDTO) {
		PoliceOfficers pOfficers = new PoliceOfficers();
		pOfficers.setCode(policeDTO.getCode());
		pOfficers.setName(policeDTO.getName());
		pOfficers.setEmail(policeDTO.getEmail());
		pOfficers.setPhone(policeDTO.getPhone());
		pOfficers.setUnit(policeDTO.getUnit());
		return pOfficers;
	}

	public static User toUserEntity(PoliceDTO dto) {
		User policeUser = new User();
		return policeUser;
		
	}

	public static Credential toCredentialEntity(PoliceDTO policeDTO) {
		Credential credential = new Credential();
		credential.setUsername(policeDTO.getUsername());
		credential.setPassword(policeDTO.getPassword());
		return credential;
	}


}
