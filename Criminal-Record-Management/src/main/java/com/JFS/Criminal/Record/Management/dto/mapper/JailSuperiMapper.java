package com.JFS.Criminal.Record.Management.dto.mapper;

import com.JFS.Criminal.Record.Management.dto.JailSuperintendentDTO;
import com.JFS.Criminal.Record.Management.entity.Credential;
import com.JFS.Criminal.Record.Management.entity.JailSuperintendent;
import com.JFS.Criminal.Record.Management.entity.User;

public class JailSuperiMapper {

	public static JailSuperintendent toEntity(JailSuperintendentDTO jDto)
    {
        JailSuperintendent register = new JailSuperintendent();
        register.setCode(jDto.getCode());
        register.setName(jDto.getName());
        register.setEmail(jDto.getEmail());
        register.setPhone(jDto.getPhone());
        register.setJailName(jDto.getJailName());
        return register;
    }
    public static User toUserEntity(JailSuperintendentDTO jDto)
    {
        User jailSuper = new User();
        return jailSuper;
    }
    public static Credential toCredentialEntity(JailSuperintendentDTO jDto)
    {
        Credential credential = new Credential();
        credential.setUsername(jDto.getUsername());
        credential.setPassword(jDto.getPassword());
        return credential;
    }

}
