package com.example.demo;

import java.time.LocalDate;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
	
	  @Autowired  
	      ModelMapper modelMapper;
 
	public User mapRequestDtoToUser(UserRequestDto requestDto) {
		User u=this.modelMapper.map(requestDto ,User.class);
// 		u.setName(requestDto.getName());
//		u.setMobile(requestDto.getMobile());
//		u.setPassword(requestDto.getPassword());
		u.setReg_date(LocalDate.now());
		return u;
	}

	public UserResponseDto mapUserToResponseDto(User u) {
		UserResponseDto rt=modelMapper.map(u, UserResponseDto.class);
		
//		rt.setId(u.getId());
//		rt.setName(u.getName());
//		rt.setMobile(u.getMobile());
//		rt.setReg_date(u.getReg_date());
		return rt;
	
}



}