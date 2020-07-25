package com.nanang.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nanang.app.entity.AauthGroups;

@Repository
public interface AauthGroupsRepository extends JpaRepository<AauthGroups, String> {

}
