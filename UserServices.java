package com.example.demo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


          
@Service
public class UserServices {
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
    Mapper mapper;
	

    public UserResponseDto adduser(UserRequestDto RequestDto) {
    	
    	User user = mapper.mapRequestDtoToUser(RequestDto);
    	
    	userRepo.save(user);
		return mapper.mapUserToResponseDto(user);
    	
    	
    	 
    	
     }


	public List<UserResponseDto> showusers() {
		List<User>users= userRepo.findAll();
		
		
		return users.stream().map(mapper::mapUserToResponseDto).collect(Collectors.toList());
	}


	public UserResponseDto showusersbyid(int id) {
		 User byId = userRepo.findById(id).get();
		 
		return mapper.mapUserToResponseDto(byId);
	}


	public UserResponseDto update(int id,UserResponseDto rt) {
		 
		User byId = userRepo.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
 		byId.setName(rt.getName());
		byId.setMobile(rt.getMobile());
		byId.setReg_date(rt.getReg_date());
		 userRepo.save(byId);
		return mapper.mapUserToResponseDto(byId);
	}


	public String delete(int id) {
		userRepo.deleteById(id);
 		return "User Deleted";
	}
}
