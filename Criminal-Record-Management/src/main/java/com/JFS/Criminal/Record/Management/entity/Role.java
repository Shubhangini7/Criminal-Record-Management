package com.JFS.Criminal.Record.Management.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Role {

    private int roleid;
    private String name;


    private Set<Credential> credential=new HashSet<>();


    @ManyToMany(mappedBy = "roles")
    public Set<Credential> getCredential() {
        return credential;
    }

    public void setCredential(Set<Credential> credential) {
        this.credential = credential;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}