package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.LPModel;

@Repository
public interface LPRepo extends JpaRepository<LPModel, Long> {
	public List<LPModel>findBycourseStartsWith(String course);
	public List<LPModel>findBycourserating(float courserating);

	
	//positional parameter
			@Query("select b from LPModel b where b.course=?1 and b.mentor=?2")
			public List<LPModel>getAppcourse(String course,String mentor);
			//named parameter
			@Query("select b from LPModel b where b.courserating=:courserating")
			public List<LPModel>getByAppcourserating(float courserating);

		
		//dml delete query
			@Modifying
			@Query("delete from LPModel b where b.course=?1")
			public int deleteBycourse(String course);
			//dml update query
			@Modifying
			@Query("update LPModel b set b.course=?1 where b.mentor=?2")
			public int updateBycourse(String course,String mentor);

}
