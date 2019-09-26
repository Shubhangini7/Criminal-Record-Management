package com.JFS.Criminal.Record.Management.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JFS.Criminal.Record.Management.dto.CbiDTO;
import com.JFS.Criminal.Record.Management.dto.mapper.CbiMapper;
import com.JFS.Criminal.Record.Management.dto.mapper.JudgeMapper;
import com.JFS.Criminal.Record.Management.entity.CBIOfficers;
import com.JFS.Criminal.Record.Management.entity.Credential;
import com.JFS.Criminal.Record.Management.entity.Judge;
import com.JFS.Criminal.Record.Management.entity.Role;
import com.JFS.Criminal.Record.Management.entity.User;
import com.JFS.Criminal.Record.Management.exception.RoleNotAvailableException;
import com.JFS.Criminal.Record.Management.repository.CbiRepository;
import com.JFS.Criminal.Record.Management.repository.RoleRepository;
import com.JFS.Criminal.Record.Management.repository.UserRepository;

@Service
public class CbiService {
	
	@Autowired
	private CbiRepository cbiRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	public void addCbiOfficer(CbiDTO cDto) throws RoleNotAvailableException{
		
		CBIOfficers cbi = CbiMapper.toEntity(cDto);
		LocalDateTime localDateTime = LocalDateTime.now();
		cbi.setDateOfModification(localDateTime);
		cbi.setDateOfRegistration(localDateTime);
		
		User user = CbiMapper.toEntity(cDto);
		User storedUser = userRepository.saveAndFlush(user);
		Credential credential = CbiMapper.toCredentialEntity(cDto);
		
		Optional<Role> optionalRole = roleRepository.findByName(com.JFS.Criminal.Record.Management.entity.enumeration.Role.ROLE_CBIOFFICER.name());
		Role role = optionalRole.orElseThrow(()-> new RoleNotAvailableException());
		credential.getRoles().add(role); 
		role.getCredential().add(credential);
		credential.setUser(storedUser);
		storedUser.setCredential(credential);
		
		CBIOfficers cOfficers = cbiRepository.saveAndFlush(cbi);
	}
}
