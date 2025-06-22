package net.andresbustamante.mystore.core.services;

import java.util.Locale;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import net.andresbustamante.mystore.api.exceptions.InvalidUsernameException;
import net.andresbustamante.mystore.api.model.UserCreationDto;
import net.andresbustamante.mystore.api.services.UsersManagementService;
import net.andresbustamante.mystore.core.dao.UserDao;
import net.andresbustamante.mystore.core.entities.User;

@Slf4j
@Service
public class UsersManagementServiceImpl implements UsersManagementService {

    private final UserDao userDao;

    public UsersManagementServiceImpl(final UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public int createUser(@NonNull final UserCreationDto user) throws InvalidUsernameException {
        if (userDao.existsByUsername(user.username().toLowerCase(Locale.getDefault()))) {
            throw new InvalidUsernameException("A user already exists with the given username");
        }

        User newUser = new User();
        newUser.setUsername(user.username().toLowerCase(Locale.getDefault()));
        newUser.setPassword(user.password());

        newUser = userDao.save(newUser);

        log.info("New user created: {}", newUser.getUsername());

        return newUser.getId();
    }
}
