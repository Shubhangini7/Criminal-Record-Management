package com.JFS.Criminal.Record.Management.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JFS.Criminal.Record.Management.dto.LoginDTO;
import com.JFS.Criminal.Record.Management.entity.Credential;
import com.JFS.Criminal.Record.Management.exception.UserNotExistException;
import com.JFS.Criminal.Record.Management.repository.CredentialRepository;
import com.JFS.Criminal.Record.Management.repository.UserRepository;

@Service
public class AcountService {
	
	@Autowired
    private CredentialRepository credentialRepository;
	@Autowired
	private UserRepository userRepository;

	public Credential performLoginAndFetchRole(LoginDTO loginDTO) throws UserNotExistException {
		// TODO Auto-generated method stub
		//Optional<Credential> expectedCredential=credentialRepository.findByUsernameAndPassword(loginDTO.getUsername(),loginDTO.getPassword());
		Optional<Credential>expectedCredential = credentialRepository.findByUsername(loginDTO.getUsername());
		expectedCredential.orElseThrow(()->new UserNotExistException());
		return expectedCredential.get();
	}

}
