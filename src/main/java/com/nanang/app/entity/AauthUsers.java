/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanang.app.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "aauth_users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AauthUsers.findAll", query = "SELECT a FROM AauthUsers a")
    , @NamedQuery(name = "AauthUsers.findById", query = "SELECT a FROM AauthUsers a WHERE a.id = :id")
    , @NamedQuery(name = "AauthUsers.findByEmail", query = "SELECT a FROM AauthUsers a WHERE a.email = :email")
    , @NamedQuery(name = "AauthUsers.findByPassword", query = "SELECT a FROM AauthUsers a WHERE a.password = :password")
    , @NamedQuery(name = "AauthUsers.findByUsername", query = "SELECT a FROM AauthUsers a WHERE a.username = :username")
    , @NamedQuery(name = "AauthUsers.findByFullName", query = "SELECT a FROM AauthUsers a WHERE a.fullName = :fullName")
    , @NamedQuery(name = "AauthUsers.findByPhoneNumber", query = "SELECT a FROM AauthUsers a WHERE a.phoneNumber = :phoneNumber")
    , @NamedQuery(name = "AauthUsers.findByAvatar", query = "SELECT a FROM AauthUsers a WHERE a.avatar = :avatar")
    , @NamedQuery(name = "AauthUsers.findByBanned", query = "SELECT a FROM AauthUsers a WHERE a.banned = :banned")
    , @NamedQuery(name = "AauthUsers.findByLastLogin", query = "SELECT a FROM AauthUsers a WHERE a.lastLogin = :lastLogin")
    , @NamedQuery(name = "AauthUsers.findByDateCreated", query = "SELECT a FROM AauthUsers a WHERE a.dateCreated = :dateCreated")})
public class AauthUsers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "username")
    private String username;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "avatar")
    private String avatar;
    @Column(name = "banned")
    private Integer banned;
    @Column(name = "last_login")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;
    @Column(name = "date_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    public AauthUsers() {
    }

    public AauthUsers(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getBanned() {
        return banned;
    }

    public void setBanned(Integer banned) {
        this.banned = banned;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
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
        if (!(object instanceof AauthUsers)) {
            return false;
        }
        AauthUsers other = (AauthUsers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.nanang.app.entity.AauthUsers[ id=" + id + " ]";
    }
    
}
