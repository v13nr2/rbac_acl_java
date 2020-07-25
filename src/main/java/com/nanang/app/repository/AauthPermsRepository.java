package com.nanang.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nanang.app.entity.AauthPerms;

@Repository
public interface AauthPermsRepository extends JpaRepository<AauthPerms, String> {

}
