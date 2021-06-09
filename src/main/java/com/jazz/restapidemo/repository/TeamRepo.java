package com.jazz.restapidemo.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jazz.restapidemo.model.data.Teams;

@Repository
public interface TeamRepo extends JpaRepository<Teams, Integer>{
	@Query(value = "select * from tbl_teams ", nativeQuery = true)
	List<Teams> findAllData(Pageable pageable);
	
	@Query(value = "select count (*) from tbl_teams  ", nativeQuery = true)
	Long getAllTeamCount();

	 
	@Query(value = "select * from tbl_teams where team_name =:teamName ", nativeQuery = true)
	Teams findTeamByName(@Param("teamName") String teamName);
}