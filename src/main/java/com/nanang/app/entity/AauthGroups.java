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
@Table(name = "aauth_groups")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AauthGroups.findAll", query = "SELECT a FROM AauthGroups a")
    , @NamedQuery(name = "AauthGroups.findById", query = "SELECT a FROM AauthGroups a WHERE a.id = :id")
    , @NamedQuery(name = "AauthGroups.findByName", query = "SELECT a FROM AauthGroups a WHERE a.name = :name")
    , @NamedQuery(name = "AauthGroups.findByDefinition", query = "SELECT a FROM AauthGroups a WHERE a.definition = :definition")})
public class AauthGroups implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "definition")
    private String definition;

    public AauthGroups() {
    }

    public AauthGroups(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        if (!(object instanceof AauthGroups)) {
            return false;
        }
        AauthGroups other = (AauthGroups) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.nanang.app.entity.AauthGroups[ id=" + id + " ]";
    }
    
}
