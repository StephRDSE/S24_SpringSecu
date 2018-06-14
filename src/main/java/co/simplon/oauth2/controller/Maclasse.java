package co.simplon.oauth2.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.simplon.oauth2.service.MyService;

@Controller
public class Maclasse {

	@Inject
	MyService myService;

	/*
	 * @RequestMapping(value="/np/private", method = RequestMethod.GET)
	 * 
	 * @ResponseBody private String fonction() {
	 * 
	 * return "private";
	 * 
	 * }
	 */
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, String> getName(Principal principal) {
		OAuth2Authentication  oAuth2Authentication = (OAuth2Authentication) principal;
		Map<String, String> userJson = new HashMap<>();
		userJson.put("name", principal.getName());
		userJson.put("roles", oAuth2Authentication.getAuthorities().toString());
		userJson.put("Authentifié", oAuth2Authentication.isAuthenticated() ? "oui " : "non");
		return userJson;

	}

	@RequestMapping(value = "/np/private", method = RequestMethod.GET)
	@ResponseBody
	public String privateInfo() {
		return myService.privateInfo();
	}

	@RequestMapping(value = "/np/admin", method = RequestMethod.GET)
	@ResponseBody
	public String adminInfo(Principal user) {
		return myService.adminInfo(user);
	}

	@RequestMapping(value = "/np", method = RequestMethod.GET)
	@ResponseBody
	public String np() {
		return myService.publicInfo();
	}

}
