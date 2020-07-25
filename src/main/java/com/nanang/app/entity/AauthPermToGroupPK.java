/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanang.app.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author user
 */
@Embeddable
public class AauthPermToGroupPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "perm_id")
    private String permId;
    @Basic(optional = false)
    @Column(name = "group_id")
    private String groupId;

    public AauthPermToGroupPK() {
    }

    public AauthPermToGroupPK(String permId, String groupId) {
        this.permId = permId;
        this.groupId = groupId;
    }

    public String getPermId() {
        return permId;
    }

    public void setPermId(String permId) {
        this.permId = permId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (permId != null ? permId.hashCode() : 0);
        hash += (groupId != null ? groupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AauthPermToGroupPK)) {
            return false;
        }
        AauthPermToGroupPK other = (AauthPermToGroupPK) object;
        if ((this.permId == null && other.permId != null) || (this.permId != null && !this.permId.equals(other.permId))) {
            return false;
        }
        if ((this.groupId == null && other.groupId != null) || (this.groupId != null && !this.groupId.equals(other.groupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.nanang.app.entity.AauthPermToGroupPK[ permId=" + permId + ", groupId=" + groupId + " ]";
    }
    
}
