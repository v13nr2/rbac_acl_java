/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanang.app.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "aauth_user_to_groups")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AauthUserToGroups.findAll", query = "SELECT a FROM AauthUserToGroups a")
    , @NamedQuery(name = "AauthUserToGroups.findByUserId", query = "SELECT a FROM AauthUserToGroups a WHERE a.aauthUserToGroupsPK.userId = :userId")
    , @NamedQuery(name = "AauthUserToGroups.findByGroupId", query = "SELECT a FROM AauthUserToGroups a WHERE a.aauthUserToGroupsPK.groupId = :groupId")})
public class AauthUserToGroups implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AauthUserToGroupsPK aauthUserToGroupsPK;

    public AauthUserToGroups() {
    }

    public AauthUserToGroups(AauthUserToGroupsPK aauthUserToGroupsPK) {
        this.aauthUserToGroupsPK = aauthUserToGroupsPK;
    }

    public AauthUserToGroups(String userId, String groupId) {
        this.aauthUserToGroupsPK = new AauthUserToGroupsPK(userId, groupId);
    }

    public AauthUserToGroupsPK getAauthUserToGroupsPK() {
        return aauthUserToGroupsPK;
    }

    public void setAauthUserToGroupsPK(AauthUserToGroupsPK aauthUserToGroupsPK) {
        this.aauthUserToGroupsPK = aauthUserToGroupsPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aauthUserToGroupsPK != null ? aauthUserToGroupsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AauthUserToGroups)) {
            return false;
        }
        AauthUserToGroups other = (AauthUserToGroups) object;
        if ((this.aauthUserToGroupsPK == null && other.aauthUserToGroupsPK != null) || (this.aauthUserToGroupsPK != null && !this.aauthUserToGroupsPK.equals(other.aauthUserToGroupsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.nanang.app.entity.AauthUserToGroups[ aauthUserToGroupsPK=" + aauthUserToGroupsPK + " ]";
    }
    
}
