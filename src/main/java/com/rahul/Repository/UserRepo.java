package com.rahul.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rahul.Model.UserMod;
@Repository
public interface UserRepo extends CrudRepository<UserMod, Long>{

}
