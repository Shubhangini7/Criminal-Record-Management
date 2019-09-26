package com.JFS.Criminal.Record.Management.service;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.JFS.Criminal.Record.Management.dto.JudgeDTO;
import com.JFS.Criminal.Record.Management.dto.mapper.JudgeMapper;
import com.JFS.Criminal.Record.Management.entity.Credential;
import com.JFS.Criminal.Record.Management.entity.Judge;
import com.JFS.Criminal.Record.Management.entity.Role;
import com.JFS.Criminal.Record.Management.exception.RoleNotAvailableException;
import com.JFS.Criminal.Record.Management.repository.JudgeRepository;
import com.JFS.Criminal.Record.Management.repository.RoleRepository;
@Service
public class JudgeService{

	@Autowired
	private JudgeRepository judgeRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Transactional
	public void addJudge(JudgeDTO judgeDTO) throws RoleNotAvailableException
	{
		// TODO Auto-generated method stub
		Judge judge = JudgeMapper.toEntity(judgeDTO);
		
		LocalDateTime localDateTime = LocalDateTime.now();
		judge.setDateOfModification(localDateTime);
		judge.setDateOfRegistration(localDateTime);

        Judge savedJudge = judgeRepository.saveAndFlush(judge);
		
        Credential credential = JudgeMapper.toCredentialEntity(judgeDTO);
		Optional<Role> optionalRole = roleRepository.findByName(com.JFS.Criminal.Record.Management.entity.enumeration.Role.ROLE_JUDGE.name());
		Role role = optionalRole.orElseThrow(()-> new RoleNotAvailableException());
		credential.getRoles().add(role); 
		role.getCredential().add(credential);
		credential.setUser(judge);
		savedJudge.setCredential(credential);
		
		Judge finalSavedJudge=judgeRepository.saveAndFlush(judge);
		
//		try {
//			System.out.println("invoking as asynchronous method" + Thread.currentThread().getName());
//			Thread.sleep(1000L);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
			
	}	
}
