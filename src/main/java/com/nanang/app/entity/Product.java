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
@Table(name = "table_product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableProduct.findAll", query = "SELECT t FROM Product t")
    , @NamedQuery(name = "TableProduct.findById", query = "SELECT t FROM Product t WHERE t.id = :id")
    , @NamedQuery(name = "TableProduct.findByName", query = "SELECT t FROM Product t WHERE t.name = :name")
    , @NamedQuery(name = "TableProduct.findByCreatedDate", query = "SELECT t FROM Product t WHERE t.createdDate = :createdDate")
    , @NamedQuery(name = "TableProduct.findByCreatedBy", query = "SELECT t FROM Product t WHERE t.createdBy = :createdBy")
    , @NamedQuery(name = "TableProduct.findByUpdatedDate", query = "SELECT t FROM Product t WHERE t.updatedDate = :updatedDate")
    , @NamedQuery(name = "TableProduct.findByUpdatedBy", query = "SELECT t FROM Product t WHERE t.updatedBy = :updatedBy")})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "updated_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;
    @Column(name = "updated_by")
    private String updatedBy;

    public Product() {
    }

    public Product(String id) {
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
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
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication39.TableProduct[ id=" + id + " ]";
    }
    
}
