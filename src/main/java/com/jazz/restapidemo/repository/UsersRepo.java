package com.jazz.restapidemo.repository;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jazz.restapidemo.model.data.Users;
@Repository
public interface UsersRepo extends JpaRepository<Users, Integer> {
	@Query(value = "select * from tbl_user_details ", nativeQuery = true)
	List<Users> findAllData(Pageable pageable);

	@Query(value = "select count (*) from tbl_user_details  ", nativeQuery = true)
	Long getAllUserDataCount();

	@Query(value = "select count (*) from tbl_user_details where user_team =:userTeam  ", nativeQuery = true)
	Integer getTeamDataCount(@Param("userTeam") String userTeam);

	@Query(value = "select * from tbl_user_details where user_email =:userEmail ", nativeQuery = true)
	Users findUserByEmail(@Param("userEmail") String userEmail);

	@Query(value = "select * from tbl_user_details where user_email =:userEmail ", nativeQuery = true)
	List<Users> findUserByEmailArr(@Param("userEmail") String userEmail);

	@Query(value = "select * from tbl_user_details where user_team =:userTeam ", nativeQuery = true)
	Users findUserByTeam(@Param("userTeam") String userTeam);

}