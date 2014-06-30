package com.ravipatel.statusserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ravipatel.statusserver.models.State;
import com.ravipatel.statusserver.models.StateDao;
import com.ravipatel.statusserver.models.User;
import com.ravipatel.statusserver.models.UserDao;
import com.ravipatel.statusserver.models.UserState;
import com.ravipatel.statusserver.models.UserStateDao;
import com.ravipatel.statusserver.utils.BaseJsonOutput;

@Controller
@RequestMapping("/{user_id}/state")
public class UserStateController {
	@Autowired
	private UserStateDao userStateDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private StateDao stateDao;
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object addStatus(
			@PathVariable("user_id") Integer userId,
			@RequestParam(value="state_id", required=true) Integer stateId){
		User user = userDao.findById(userId);
		State state = stateDao.findById(stateId);
		System.out.println(user.getEmail());
		System.out.println(state.getName());
		UserState userState = userStateDao.addUserState(user, state);
		return userState;
		
	}
	
	@RequestMapping(method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<BaseJsonOutput> getStatusListForUser(@PathVariable("user_id") Integer userId){
		BaseJsonOutput output = new BaseJsonOutput();
		
		User user = userDao.findById(userId);
		output.setResult(userStateDao.findAllUserStateForUserId(user));
		output.setMessage("Successfully gathered user status.");
		output.setSuccess(true);
		output.setStatuscode(200);
		
		return new ResponseEntity<BaseJsonOutput>(output,HttpStatus.OK);
		
	}
	
	
}
