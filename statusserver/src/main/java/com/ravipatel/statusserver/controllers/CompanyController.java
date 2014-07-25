package com.ravipatel.statusserver.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ravipatel.statusserver.models.CompanyDao;
import com.ravipatel.statusserver.models.User;
import com.ravipatel.statusserver.models.UserDao;
import com.ravipatel.statusserver.utils.BaseJsonOutput;

@Controller
@RequestMapping(value="{user_id}/company")
public class CompanyController {
	
	@Autowired
	private CompanyDao companyDao;
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value="users",method=RequestMethod.GET)
	public @ResponseBody ResponseEntity<BaseJsonOutput> getAllUsersForCurrentUsersCompany(
			@PathVariable("user_id") Integer userId){
		User user = userDao.findById(userId);
		List<User> users = companyDao.findAllUsersForCompany(user.getCompany());
		BaseJsonOutput output = new BaseJsonOutput();
		output.setMessage("Successfully gathered all users for company.");
		output.setResult(users);
		output.setStatuscode(200);
		output.setSuccess(true);
		return new ResponseEntity<BaseJsonOutput>(output,HttpStatus.OK);
	}

}
