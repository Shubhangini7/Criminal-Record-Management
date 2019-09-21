package com.JFS.Criminal.Record.Management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.JFS.Criminal.Record.Management.entity.Judge;

@Repository
public interface JudgeRepository extends JpaRepository<Judge, String>{

}
