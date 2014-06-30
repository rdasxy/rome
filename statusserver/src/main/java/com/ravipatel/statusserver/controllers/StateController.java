package com.ravipatel.statusserver.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ravipatel.statusserver.models.State;
import com.ravipatel.statusserver.models.StateDao;
import com.ravipatel.statusserver.utils.BaseJsonOutput;

@Controller
@RequestMapping("/state")
public class StateController {
	
	@Autowired
	private StateDao stateDao;
	
	@RequestMapping(method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<BaseJsonOutput> getAllStates(){
		List<State> states = stateDao.allStates();
		BaseJsonOutput output = new BaseJsonOutput();
		output.setMessage("Successfully gathered all states.");
		output.setResult(states);
		output.setStatuscode(200);
		output.setSuccess(true);
		return new ResponseEntity<BaseJsonOutput>(output,HttpStatus.OK);
	}
}
