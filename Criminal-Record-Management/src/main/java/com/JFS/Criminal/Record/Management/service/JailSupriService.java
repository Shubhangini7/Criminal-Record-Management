package com.JFS.Criminal.Record.Management.service;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JFS.Criminal.Record.Management.dto.JailSuperintendentDTO;
import com.JFS.Criminal.Record.Management.dto.mapper.JailSuperiMapper;
import com.JFS.Criminal.Record.Management.entity.Credential;
import com.JFS.Criminal.Record.Management.entity.JailSuperintendent;
import com.JFS.Criminal.Record.Management.entity.Role;
import com.JFS.Criminal.Record.Management.entity.User;
import com.JFS.Criminal.Record.Management.exception.RoleNotAvailableException;
import com.JFS.Criminal.Record.Management.repository.JailSuperiRepository;
import com.JFS.Criminal.Record.Management.repository.RoleRepository;
import com.JFS.Criminal.Record.Management.repository.UserRepository;

@Service
public class JailSupriService {

	@Autowired
	private JailSuperiRepository jailSuperiRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	@Transactional
    public void addJailSuper(JailSuperintendentDTO jDto) throws RoleNotAvailableException
    {
        JailSuperintendent jSuperintendent = JailSuperiMapper.toEntity(jDto);
        
        LocalDateTime localDateTime = LocalDateTime.now();
        jSuperintendent.setDateOfModification(localDateTime);
        jSuperintendent.setDateOfRegistration(localDateTime);

        User user = JailSuperiMapper.toUserEntity(jDto);
        User storedUser = userRepository.saveAndFlush(user);
        Credential credential = JailSuperiMapper.toCredentialEntity(jDto);

        Optional<Role> optionalRole=roleRepository.findByName(com.JFS.Criminal.Record.Management.entity.enumeration.Role.ROLE_JAIL_SUPERINTENDENT.name());
        Role role = optionalRole.orElseThrow(()-> new RoleNotAvailableException());
        credential.getRoles().add(role);
        role.getCredential().add(credential);
        credential.setUser(storedUser);
        storedUser.setCredential(credential);
        
        JailSuperintendent savedJailSupri = jailSuperiRepository.saveAndFlush(jSuperintendent);
    
    }
}
