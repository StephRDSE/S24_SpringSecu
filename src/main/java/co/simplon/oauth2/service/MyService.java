package co.simplon.oauth2.service;

import java.security.Principal;

import javax.inject.Named;

import org.apache.catalina.realm.GenericPrincipal;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

@Named
public class MyService {

	public String publicInfo() {
		return "for anybody";
	}

	@Secured({ "ROLE_ADMIN" })
	public String adminInfo(Principal principal) {
		 OAuth2Authentication  oAuth2Authentication = (OAuth2Authentication) principal;
		return "for admin only " + principal.getName()
				+ "<br> Credential : " + oAuth2Authentication.getCredentials()
				+ "<br> Autentifié : " + oAuth2Authentication.isAuthenticated()
				+ "<br> Droits : " + oAuth2Authentication.getAuthorities()
				+ "<br><br> Object principal " + principal;
		
		
	}

	@Secured({ "ROLE_USER" })
	public String privateInfo() {
		return "for user";
	}
}
