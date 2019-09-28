package com.JFS.Criminal.Record.Management.dto.mapper;

import com.JFS.Criminal.Record.Management.dto.CriminalDTO;
import com.JFS.Criminal.Record.Management.entity.Credential;
import com.JFS.Criminal.Record.Management.entity.Criminal;
import com.JFS.Criminal.Record.Management.entity.User;

public class CriminalMapper {


	public static Criminal toEntity(CriminalDTO dto) {
		Criminal register = new Criminal();
		register.setCriminalNo(dto.getCriminalNo());;
		register.setCriminalName(dto.getCriminalName());
		register.setBloodGroup(dto.getBloodGroup());
		register.setJailName(dto.getJailName());
		register.setCellNo(dto.getCellNo());
		register.setAssignWork(dto.getAssignWork());
		return 	register;
		
	}
	
	 public static CriminalDTO toDTO(Criminal criminal)
	    {
	       	CriminalDTO dto = new CriminalDTO();
	        dto.setCriminalNo(criminal.getCriminalNo());
	        dto.setCriminalName(criminal.getCriminalName());
	        dto.setJailName(criminal.getJailName());
	        return dto;
	    }

/*	    public static User toUserEntity(CriminalDTO crimialDTO)
	    {
	        User criminal = new User();
	        return criminal;
	    }
	    
	    public static Credential toCredentialEntity(CriminalDTO crimialDTO)
	    {
	        Credential credential = new Credential();
	        credential.setUsername(collegeDTO.getUsername());
	        credential.setPassword(collegeDTO.getPassword());
	        return credential;
	    }*/
}
