package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.LPModel;
import com.example.demo.Model.VerifyModel;
import com.example.demo.Repository.LPRepo;
import com.example.demo.Repository.VerifyRepo;

@Service
public class LPService {
	@Autowired
	private LPRepo lprepo;
	@Autowired
	private VerifyRepo verifyrepo;
	public String Login(String username, String password) {
		VerifyModel xuser = verifyrepo.findByusername(username);
		if (xuser == null) {
			return "invalidusername";
		} else {
			if (xuser.getPassword().equals(password)) {
				return "success";
			} else {
				return "invalidpassword";
			}
		}
	}
	public String Signup(VerifyModel xuser) {
	    String username = xuser.getUsername();
	    VerifyModel authuser = verifyrepo.findByusername(username);
	    if (authuser == null) {
	        verifyrepo.save(xuser);
	        return "useradded";
	    } else {
	        return "existingusername";
	    }
	}
	public List<LPModel> getData() {
		return lprepo.findAll();
	}
	public LPModel addData(LPModel data) {
		return lprepo.save(data);
	}
	public LPModel editData(LPModel data, Long id) {
		LPModel edx = lprepo.findById(id).orElse(data);
		if (edx != null) {
			edx.setCourse(data.getCourse());
			edx.setMentor(data.getMentor());
			edx.setCourseprice(data.getCourseprice());
			edx.setCourserating(data.getCourserating());
			edx.setCountryimg(data.getCountryimg());
			return lprepo.saveAndFlush(edx);
		} else {
			return null;
		}
	}
	public String deleteData(Long id) {
		lprepo.deleteById(id);
		return "Deleted Successfully";
	}
	public Optional<LPModel> findbyID(Long id) {
		return lprepo.findById(id);
	}
}

