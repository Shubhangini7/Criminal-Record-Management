package com.JFS.Criminal.Record.Management.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JFS.Criminal.Record.Management.dto.JudgeDTO;
import com.JFS.Criminal.Record.Management.dto.mapper.JudgeMapper;
import com.JFS.Criminal.Record.Management.entity.Credential;
import com.JFS.Criminal.Record.Management.entity.Judge;
import com.JFS.Criminal.Record.Management.entity.Role;
import com.JFS.Criminal.Record.Management.entity.User;
import com.JFS.Criminal.Record.Management.exception.RoleNotAvailableException;
import com.JFS.Criminal.Record.Management.repository.JudgeRepository;
import com.JFS.Criminal.Record.Management.repository.RoleRepository;
import com.JFS.Criminal.Record.Management.repository.UserRepository;
@Service
public class JudgeService {

	@Autowired
	private JudgeRepository judgeRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	public void addJudge(JudgeDTO judgeDTO)
	{
		// TODO Auto-generated method stub
		Judge judge = JudgeMapper.toEntity(judgeDTO);
		LocalDateTime localDateTime = LocalDateTime.now();
		judge.setDateOfModification(localDateTime);
		judge.setDateOfRegistration(localDateTime);
		
		User user = JudgeMapper.toEntity(judgeDTO);
		User storedUser = userRepository.saveAndFlush(user);
		Credential credential = JudgeMapper.toCredentialEntity(judgeDTO);
		
		Optional<Role> optionalRole = roleRepository.findByName(com.JFS.Criminal.Record.Management.entity.enumeration.Role.ROLE_JUDGE.name());
		Role role = optionalRole.get();
		credential.getRoles().add(role); 
		role.getCredential().add(credential);
		credential.setUser(storedUser);
		storedUser.setCredential(credential);
		
		Judge savedJudge = judgeRepository.saveAndFlush(judge);
		
	}
	
}
