package net.andresbustamante.mystore.api.services;

import net.andresbustamante.mystore.api.exceptions.InvalidUsernameException;
import net.andresbustamante.mystore.api.model.UserCreationDto;

public interface UsersManagementService {

    int createUser(UserCreationDto user) throws InvalidUsernameException;
}
