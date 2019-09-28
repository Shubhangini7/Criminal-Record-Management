package com.JFS.Criminal.Record.Management.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JFS.Criminal.Record.Management.dto.CriminalDTO;
import com.JFS.Criminal.Record.Management.dto.mapper.CriminalMapper;
import com.JFS.Criminal.Record.Management.entity.Criminal;
import com.JFS.Criminal.Record.Management.exception.RoleNotAvailableException;
import com.JFS.Criminal.Record.Management.repository.CriminalRepository;

@Service
public class CriminalService {

	@Autowired
	private CriminalRepository criminalRepository;
	public void addCriminal(CriminalDTO cDto) throws RoleNotAvailableException {
		
		Criminal criminal = CriminalMapper.toEntity(cDto);
		
		LocalDateTime localDateTime = LocalDateTime.now();
        criminal.setDateOfModification(localDateTime);
        criminal.setDateOfRegistration(localDateTime);
	
        Criminal savedCriminal = criminalRepository.saveAndFlush(criminal);
	}
}
