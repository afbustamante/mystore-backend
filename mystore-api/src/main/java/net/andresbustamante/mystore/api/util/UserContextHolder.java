package net.andresbustamante.mystore.api.util;

public final class UserContextHolder {

    private static final ThreadLocal<UserContext> USER_CONTEXT_HOLDER = new ThreadLocal<>();

    private UserContextHolder() {
        // no-op
    }

    public static UserContext getUserContext() {
        return USER_CONTEXT_HOLDER.get();
    }

    public static void setUserContext(final UserContext userContext) {
        if (userContext == null) {
            resetUserContext();
        } else {
            USER_CONTEXT_HOLDER.set(userContext);
        }
    }

    public static void resetUserContext() {
        USER_CONTEXT_HOLDER.remove();
    }
}
