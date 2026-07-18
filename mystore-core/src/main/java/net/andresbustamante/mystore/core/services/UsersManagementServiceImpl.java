package net.andresbustamante.mystore.core.services;

import java.util.Locale;

import org.springframework.lang.NonNull;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import net.andresbustamante.mystore.api.exceptions.ApplicationException;
import net.andresbustamante.mystore.api.exceptions.InvalidUsernameException;
import net.andresbustamante.mystore.api.exceptions.ObjectNotFoundException;
import net.andresbustamante.mystore.api.model.UserCreation;
import net.andresbustamante.mystore.api.services.UsersManagementService;
import net.andresbustamante.mystore.jpa.dao.UserDao;
import net.andresbustamante.mystore.jpa.entities.UserEntity;

@Slf4j
@Service
public class UsersManagementServiceImpl implements UsersManagementService {

    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;

    public UsersManagementServiceImpl(final UserDao userDao, final PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional(rollbackFor = ApplicationException.class)
    public int createUser(@NonNull final UserCreation user) throws ApplicationException {
        if (userDao.existsByUsername(user.username().toLowerCase(Locale.getDefault()))) {
            throw new InvalidUsernameException("A user already exists with the given username");
        }

        UserEntity newUser = new UserEntity();
        newUser.setUsername(user.username().toLowerCase(Locale.getDefault()));
        newUser.setPassword(passwordEncoder.encode(user.password()));

        newUser = userDao.save(newUser);

        log.info("New user created: {}", newUser.getUsername());

        return newUser.getId();
    }

    @Override
    @Transactional(rollbackFor = ApplicationException.class)
    public void deactivateUser(@NonNull final Integer userId) throws ApplicationException {
        UserEntity user = userDao.findById(userId).orElseThrow(() -> new ObjectNotFoundException("User not found"));
        userDao.delete(user); // Hibernate makes a soft-delete here

        log.info("User {} has been deactivated", user.getUsername());
    }
}
