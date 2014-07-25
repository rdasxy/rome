package com.ravipatel.statusserver.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ravipatel.statusserver.models.Company;
import com.ravipatel.statusserver.models.CompanyDao;
import com.ravipatel.statusserver.models.Role;
import com.ravipatel.statusserver.models.RoleDao;
import com.ravipatel.statusserver.models.User;
import com.ravipatel.statusserver.models.UserDao;
import com.ravipatel.statusserver.models.UserRoleDao;
import com.ravipatel.statusserver.utils.BaseJsonOutput;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserDao userDao;
	@Autowired
	private CompanyDao companyDao;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private UserRoleDao userRoleDao;

	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		List<User> users = userDao.findAll();
		model.addAttribute("users", users);
		return "jsp/index";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<BaseJsonOutput> login(HttpServletRequest request,
			@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "password", required = true) String password) {
		User user = userDao.login(email, password);
		BaseJsonOutput output = new BaseJsonOutput();
		if (user == null) {
			output.setMessage("Username/Password did not match.");
			output.setResult(user);
			output.setStatuscode(304);
			output.setSuccess(false);
			return new ResponseEntity<BaseJsonOutput>(output,HttpStatus.FORBIDDEN);
		} else {
			output.setMessage("Successful login.");
			output.setResult(user);
			output.setStatuscode(200);
			output.setSuccess(true);
			return new ResponseEntity<BaseJsonOutput>(output,HttpStatus.OK);
		}
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<BaseJsonOutput> register(
			@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "password", required = true) String password,
			@RequestParam(value = "first_name", required = true) String firstName,
			@RequestParam(value = "last_name", required = true) String lastName,
			@RequestParam(value = "role", required = true) Integer roleId) {
		
		Company company = companyDao.findById(1);
		
		User user = userDao.createNewUser(company, email, password, firstName, lastName);
		
		Role role = roleDao.findById(roleId);
		
		userRoleDao.addUserToRole(user, role);
		
		BaseJsonOutput output = new BaseJsonOutput();
		output.setMessage("Successfully added new user.");
		output.setResult(user);
		output.setStatuscode(202);
		output.setSuccess(true);
		return new ResponseEntity<BaseJsonOutput>(output,HttpStatus.ACCEPTED);
	}
}