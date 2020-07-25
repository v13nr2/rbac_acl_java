package com.nanang.app.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nanang.app.entity.AauthUsers;
@Repository
public interface AauthUsersRepository extends JpaRepository<AauthUsers, String> {

	@Query("SELECT a FROM AauthUsers a WHERE a.username = :username")
	List<AauthUsers> findOne(@Param("username") String username);
	@Query("SELECT a FROM AauthUsers a WHERE a.username = :username and a.password = :password")
	List<AauthUsers> findOneByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
    /*
     * SELECT a.id, c.name FROM aauth_users a, aauth_user_to_groups b, aauth_groups c where 
a.id = b.user_id and b.group_id = c.id
     */
	
	@Query("Select a, c.name  From AauthUsers a, AauthUserToGroups b, AauthGroups c "
			+ "where a.id = b.aauthUserToGroupsPK.userId and b.aauthUserToGroupsPK.groupId "
			+ " = c.id and a.id = :userId")
	List<Object[]> findUserAndGroupByUserId(@Param("userId") String userId);
	
}
