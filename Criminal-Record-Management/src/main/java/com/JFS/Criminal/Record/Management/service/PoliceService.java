package com.JFS.Criminal.Record.Management.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.JFS.Criminal.Record.Management.dto.PoliceDTO;
import com.JFS.Criminal.Record.Management.dto.mapper.PoliceMapper;
import com.JFS.Criminal.Record.Management.entity.Credential;
import com.JFS.Criminal.Record.Management.entity.PoliceOfficers;
import com.JFS.Criminal.Record.Management.entity.Role;
import com.JFS.Criminal.Record.Management.entity.User;
import com.JFS.Criminal.Record.Management.repository.PoliceRepository;
import com.JFS.Criminal.Record.Management.repository.RoleRepository;
import com.JFS.Criminal.Record.Management.repository.UserRepository;

@Service
public class PoliceService {

	@Autowired
	private PoliceRepository policeRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	public void addPolice(PoliceDTO policeDTO) {
		PoliceOfficers pOfficers = PoliceMapper.toEntity(policeDTO);
		LocalDateTime localDateTime = LocalDateTime.now();
		pOfficers.setDateOfModification(localDateTime);
		pOfficers.setDateOfRegistration(localDateTime);
		
		User user = PoliceMapper.toEntity(policeDTO);
		User storedUser = userRepository.saveAndFlush(user);
		Credential credential = PoliceMapper.toCredentialEntity(policeDTO);
		
		Optional<Role> optionalRole = roleRepository.findByName(com.JFS.Criminal.Record.Management.entity.enumeration.Role.ROLE_POLICE_OFFICER.name());
		Role role = optionalRole.get();
		credential.getRoles().add(role); 
		role.getCredential().add(credential);
		credential.setUser(storedUser);
		storedUser.setCredential(credential);

		PoliceOfficers savePoliceOfficers = policeRepository.saveAndFlush(pOfficers);
	}
}
