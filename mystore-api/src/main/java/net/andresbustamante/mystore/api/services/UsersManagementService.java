package net.andresbustamante.mystore.api.services;

import net.andresbustamante.mystore.api.exceptions.ApplicationException;
import net.andresbustamante.mystore.api.model.UserCreation;

/**
 * Users' management service.
 */
public interface UsersManagementService {

    /**
     * Registers a new user in database.
     *
     * @param user User to register.
     * @return Technical ID of the new user.
     * @throws ApplicationException When the user cannot be stored in database.
     */
    int createUser(UserCreation user) throws ApplicationException;

    /**
     * Deactivates a user by using his technical ID.
     *
     * @param userId ID of the user to deactivate.
     * @throws ApplicationException When the user cannot be deactivated in database.
     */
    void deactivateUser(Integer userId) throws ApplicationException;
}
