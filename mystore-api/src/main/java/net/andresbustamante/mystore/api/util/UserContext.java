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
}
