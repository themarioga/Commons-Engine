package org.themarioga.engine.commons.util;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.themarioga.engine.commons.models.User;

import java.util.Objects;

public class SessionUtil {

	public static void setCurrentUser(User user) {
		SecurityContext context = SecurityContextHolder.createEmptyContext();
		context.setAuthentication(new UserAuthentication(user));
		SecurityContextHolder.setContext(context);
	}

	public static User getCurrentUser() {
		return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

	public static class UserAuthentication extends AbstractAuthenticationToken {
		private final User user;

		public UserAuthentication(User user) {
			super(null);
			this.user = user;
			setAuthenticated(true);
		}

		@Override
		public Object getPrincipal() {
			return user;
		}

		@Override
		public Object getCredentials() {
			return null;
		}

		@Override
		public boolean equals(Object o) {
			if (o == null || getClass() != o.getClass()) return false;
			if (!super.equals(o)) return false;

			UserAuthentication that = (UserAuthentication) o;
			return Objects.equals(user, that.user);
		}

		@Override
		public int hashCode() {
			int result = super.hashCode();
			result = 31 * result + Objects.hashCode(user);
			return result;
		}
	}

}
