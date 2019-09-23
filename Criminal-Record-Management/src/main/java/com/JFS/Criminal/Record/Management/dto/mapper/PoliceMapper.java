package com.JFS.Criminal.Record.Management.dto.mapper;

import com.JFS.Criminal.Record.Management.dto.PoliceDTO;
import com.JFS.Criminal.Record.Management.entity.Credential;
import com.JFS.Criminal.Record.Management.entity.PoliceOfficers;

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

	public static Credential toCredentialEntity(PoliceDTO policeDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
