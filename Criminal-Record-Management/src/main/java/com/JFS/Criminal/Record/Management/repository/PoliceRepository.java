package com.JFS.Criminal.Record.Management.repository;

import com.JFS.Criminal.Record.Management.dto.PoliceDTO;
import com.JFS.Criminal.Record.Management.entity.PoliceOfficers;

public interface PoliceRepository {

	public static PoliceOfficers toEntity(PoliceDTO policeDTO) {
		PoliceOfficers pOfficers = new PoliceOfficers();
		pOfficers.setCode(policeDTO.getCode());
		pOfficers.setName(policeDTO.getName());
		pOfficers.setEmail(policeDTO.getEmail());
		pOfficers.setPhone(policeDTO.getPhone());
		pOfficers.setUnit(policeDTO.getUnit());
		return pOfficers;
		
	}
}
