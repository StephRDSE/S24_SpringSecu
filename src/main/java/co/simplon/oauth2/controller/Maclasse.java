package co.simplon.oauth2.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Maclasse {
	
	@RequestMapping(value="/np/private", method = RequestMethod.GET)
	@ResponseBody
	private String fonction() {
		
		return "private";
		
	}
	@RequestMapping(value="/user", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, String> getName(Principal user) {
		Map<String, String> userJson = new HashMap<>();
		userJson.put("name", user.getName());
		return userJson;
		
	}
	
	
	
	
	
}
