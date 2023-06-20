package com.rahul.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.Model.UserMod;
import com.rahul.Service.UserServ;

@RestController
public class UserCon {
	  
    @Autowired
    UserServ us;
 
	 @PostMapping("/post")
	    public UserMod adduser(@RequestBody UserMod std) {
	    	
	    	return us.adduser(std);
	    }
	 @GetMapping("/get")
	   public UserMod getuser(@RequestParam("id") long id) {
		   
		   return us.getuser(id);
	   }
	 @GetMapping("/getall")
	    public List<UserMod> getall(){
		   
	    	List<UserMod>std=us.getall();
	    	
	    	return std;
	    }
	 @PutMapping("/update")
	   public UserMod update(@RequestParam("id") long id, 
			   @RequestParam("name") String name,
			   @RequestParam("last") String lname,
			   @RequestParam("address") String address) {
		   
		   return us.update(id , name, lname, address);
	   }
	 @DeleteMapping("/del")
	   public String delete(@RequestParam("id") long id) {
		   
		   return us.delete(id);
	   }
}
