package org.themarioga.engine.commons.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.themarioga.engine.commons.exceptions.user.UserDoesntExistsException;
import org.themarioga.engine.commons.models.Lang;
import org.themarioga.engine.commons.models.User;

import java.util.UUID;
import java.util.function.Predicate;

public class SecurityUtils {

	private SecurityUtils() {
		throw new UnsupportedOperationException();
	}

	public static boolean isLoggedIn() {
		return getUserDetails() != null;
	}

	public static User getUser() {
		UserDetails userDetails = getUserDetails();

		return userDetails != null && userDetails.getUser() != null ? userDetails.getUser() : null;
	}

	public static UUID getId() {
		UserDetails userDetails = getUserDetails();

		return userDetails != null && userDetails.getUser() != null ? userDetails.getUser().getId() : null;
	}

	public static String getName() {
		UserDetails userDetails = getUserDetails();

		return userDetails != null ? userDetails.getUser().getName() : null;
	}

	public static Lang getLang() {
		UserDetails userDetails = getUserDetails();

		return userDetails != null ? userDetails.getUser().getLang() : null;
	}

	public static boolean isAdmin() {
		UserDetails userDetails = getUserDetails();

		return userDetails != null && userDetails.getAuthorities().stream().anyMatch((Predicate<GrantedAuthority>) grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"));
	}

	public static void setUserDetails(User user, UserRole userRole) {
		if (user == null || userRole == null) throw new UserDoesntExistsException();

		setUserDetails(new UserDetails(user, userRole));
	}

	public static void setUserDetails(UserDetails userDetails) {
		SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(userDetails,
				null,
				userDetails.getAuthorities()));
	}

	public static UserDetails getUserDetails() {
		if (SecurityContextHolder.getContext().getAuthentication() == null
			|| !(SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof UserDetails))
			return null;
		return (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

}
