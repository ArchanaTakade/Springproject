package com.rahul.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.Model.UserMod;
import com.rahul.Repository.UserRepo;


@Service
public class UserServ {
    @Autowired
    UserRepo ur;
	  
	public UserMod adduser(UserMod std) {
		
		return ur.save(std);
	}

	public UserMod getuser(long id) {
		
		 Optional<UserMod> std = ur.findById(id);
		   
		 return std.isPresent() ? (UserMod) std.get() :(UserMod) new UserMod();
	}

	public List<UserMod> getall() {
		
		return (List<UserMod>) ur.findAll();
	}

	public UserMod update(long rollno, String  name ,String lname ,String address) {
		
		UserMod std= getuser(rollno);
		 
		if(std.getId()==null) {

		return std;
		}
		else {
			std.setFirstname(name);
			
			std.setLastname(lname);
		
			std.setAddress(address);
			ur.save(std);
			
			return std;
			
		}

	}

	public String delete(long id) {
		
		 ur.deleteById(id);
		 return  "User Has Been delete Sucessfully";
	}

}
