package com.JFS.Criminal.Record.Management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.JFS.Criminal.Record.Management.entity.Credential;

@Repository
public interface CredentialRepository extends JpaRepository<Credential, String>{

	//Optional<Credential> findByUsernameAndPassword(String username, String password);

	Optional<Credential> findByUsername(String username);

}
