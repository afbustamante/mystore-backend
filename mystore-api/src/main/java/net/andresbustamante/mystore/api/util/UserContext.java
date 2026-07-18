package net.andresbustamante.mystore.api.util;

import java.time.ZoneId;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

/**
 * Context information for the connected user.
 */
@Getter
public class UserContext {

    public static final UserContext UNKNOWN_USER = new UserContext("UNKNOWN");

    /**
     * Username of the active user.
     */
    private final String username;

    /**
     * Origin timezone of the active user.
     */

    @Setter
    private ZoneId timezone;

    /**
     * Constructor using a username.
     *
     * @param username Username for the new context object
     */
    public UserContext(final String username) {
        Objects.requireNonNull(username, "Username cannot be null");
        this.username = username;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserContext context = (UserContext) o;
        return Objects.equals(username, context.username);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(username);
    }
}
