package com.jazz.restapidemo.repository;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jazz.restapidemo.model.data.StepCountData;
@Repository
public interface StepCountRepo extends JpaRepository<StepCountData, Integer>{
	@Query(value = "select * from tbl_step_counts ", nativeQuery = true)
	List<StepCountData> findAllData(Pageable pageable);
	
	@Query(value = "select count (*) from tbl_step_counts  ", nativeQuery = true)
	Long getAllStepCountDataCount();
	
	@Query
	(value = "update tbl_step_counts set step_count=:stepCount where date=:date or '' and user_name=:userName ", 
			nativeQuery = true)
	StepCountData updateStepCountDataCount();


	@Query(value = "select sum(step_count) from tbl_step_counts where user_team =:userTeam  ", nativeQuery = true)
	Integer getTotalStepCountTeam(@Param("userTeam") String userTeam);
	
	@Query(value = "select * from tbl_step_counts where user_email =:userEmail and date=:date", nativeQuery = true)
	StepCountData findStepCountByEmail(@Param("userEmail") String userEmail,@Param("date") Date date);
	
	@Query(value = "select * from tbl_step_counts where user_email=:userEmail  and date =:date", nativeQuery = true)
	List<StepCountData> findStepCountByDate(@Param("date") Date date,@Param("userEmail") String string);
	
	@Query(value = "select step_count where user_email =:userEmail ", nativeQuery = true)
	int findStepCountByEmail1(@Param("userEmail") String userEmail);
	
	@Query(value = "dalete tbl_step_counts where date =:date ", nativeQuery = true)
	int deleteByDate(@Param("date") Date date);

	
}