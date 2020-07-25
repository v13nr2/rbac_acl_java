package com.nanang.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nanang.app.entity.AauthPermToGroupPK;
import com.nanang.app.entity.AauthUserToGroups;
@Repository
public interface AauthUserToGroupsRepository extends JpaRepository<AauthUserToGroups, AauthPermToGroupPK> {

}
