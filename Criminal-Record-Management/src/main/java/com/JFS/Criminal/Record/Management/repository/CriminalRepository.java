package com.JFS.Criminal.Record.Management.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.JFS.Criminal.Record.Management.entity.Criminal;

@Repository
public interface CriminalRepository extends JpaRepository<Criminal, Long>{
	
	Optional<Criminal> findByCriminalName(String jailorJail);

}
