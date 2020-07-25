/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanang.app.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "aauth_perms")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AauthPerms.findAll", query = "SELECT a FROM AauthPerms a")
    , @NamedQuery(name = "AauthPerms.findById", query = "SELECT a FROM AauthPerms a WHERE a.id = :id")
    , @NamedQuery(name = "AauthPerms.findByAauthPerms", query = "SELECT a FROM AauthPerms a WHERE a.aauthPerms = :aauthPerms")
    , @NamedQuery(name = "AauthPerms.findByDefinition", query = "SELECT a FROM AauthPerms a WHERE a.definition = :definition")})
public class AauthPerms implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Column(name = "aauth_perms")
    private String aauthPerms;
    @Column(name = "definition")
    private String definition;

    public AauthPerms() {
    }

    public AauthPerms(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAauthPerms() {
        return aauthPerms;
    }

    public void setAauthPerms(String aauthPerms) {
        this.aauthPerms = aauthPerms;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AauthPerms)) {
            return false;
        }
        AauthPerms other = (AauthPerms) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.nanang.app.entity.AauthPerms[ id=" + id + " ]";
    }
    
}
