package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.LPModel;

@Repository
public interface LPRepo extends JpaRepository<LPModel, Long> {
	public List<LPModel>findByCourseStartsWith(String course);
	public List<LPModel>findByCourseRating(float courserating);
	//positional parameter
	@Query("select l from LPModel m where m.course=?1 and m.courserating=?2")
	public List<LPModel>getByCourse(String course,float courserating);
	//named parameter
	@Query("select m from LPModel m where m.courserating=:courserating")
	public List<LPModel>getByCourseRating(float courserating);
	//dml delete query
	@Modifying
	@Query("delete from LPModel m where m.course=?1")
	public int deleteByCourse(String Course);
	//dml update query
	@Modifying
	@Query("update LPModel m set m.course=?1 where m.mentor=?2")
	public int updateByCourse(String course,String mentor);
}
