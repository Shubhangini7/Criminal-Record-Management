package com.JFS.Criminal.Record.Management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.JFS.Criminal.Record.Management.entity.CBIOfficers;

@Repository
public interface CbiRepository extends JpaRepository<CBIOfficers, Integer>{

}
