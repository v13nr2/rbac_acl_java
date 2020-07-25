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
@Table(name = "aauth_perm_to_group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AauthPermToGroup.findAll", query = "SELECT a FROM AauthPermToGroup a")
    , @NamedQuery(name = "AauthPermToGroup.findByPermId", query = "SELECT a FROM AauthPermToGroup a WHERE a.aauthPermToGroupPK.permId = :permId")
    , @NamedQuery(name = "AauthPermToGroup.findByGroupId", query = "SELECT a FROM AauthPermToGroup a WHERE a.aauthPermToGroupPK.groupId = :groupId")})
public class AauthPermToGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AauthPermToGroupPK aauthPermToGroupPK;

    public AauthPermToGroup() {
    }

    public AauthPermToGroup(AauthPermToGroupPK aauthPermToGroupPK) {
        this.aauthPermToGroupPK = aauthPermToGroupPK;
    }

    public AauthPermToGroup(String permId, String groupId) {
        this.aauthPermToGroupPK = new AauthPermToGroupPK(permId, groupId);
    }

    public AauthPermToGroupPK getAauthPermToGroupPK() {
        return aauthPermToGroupPK;
    }

    public void setAauthPermToGroupPK(AauthPermToGroupPK aauthPermToGroupPK) {
        this.aauthPermToGroupPK = aauthPermToGroupPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aauthPermToGroupPK != null ? aauthPermToGroupPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AauthPermToGroup)) {
            return false;
        }
        AauthPermToGroup other = (AauthPermToGroup) object;
        if ((this.aauthPermToGroupPK == null && other.aauthPermToGroupPK != null) || (this.aauthPermToGroupPK != null && !this.aauthPermToGroupPK.equals(other.aauthPermToGroupPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.nanang.app.entity.AauthPermToGroup[ aauthPermToGroupPK=" + aauthPermToGroupPK + " ]";
    }
    
}
