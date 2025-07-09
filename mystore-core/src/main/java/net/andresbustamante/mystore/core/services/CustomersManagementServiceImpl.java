package net.andresbustamante.mystore.core.services;

import java.nio.charset.StandardCharsets;
import java.util.Locale;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import net.andresbustamante.mystore.api.exceptions.FunctionalException;
import net.andresbustamante.mystore.api.exceptions.InvalidEmailException;
import net.andresbustamante.mystore.api.exceptions.InvalidUsernameException;
import net.andresbustamante.mystore.api.model.AddressCreationDto;
import net.andresbustamante.mystore.api.model.CustomerCreationDto;
import net.andresbustamante.mystore.api.model.UserCreationDto;
import net.andresbustamante.mystore.api.services.AddressesManagementService;
import net.andresbustamante.mystore.api.services.CustomersManagementService;
import net.andresbustamante.mystore.api.services.UsersManagementService;
import net.andresbustamante.mystore.core.dao.AddressDao;
import net.andresbustamante.mystore.core.dao.CustomerDao;
import net.andresbustamante.mystore.core.dao.UserDao;
import net.andresbustamante.mystore.core.entities.Address;
import net.andresbustamante.mystore.core.entities.Customer;
import net.andresbustamante.mystore.core.entities.User;

@Slf4j
@Service
public class CustomersManagementServiceImpl implements CustomersManagementService {

    private final CustomerDao customerDao;
    private final AddressDao addressDao;
    private final UserDao userDao;
    private final UsersManagementService usersManagementService;
    private final AddressesManagementService addressesManagementService;

    public CustomersManagementServiceImpl(final CustomerDao customerDao,
            final AddressesManagementService addressesManagementService,
            final AddressDao addressDao, final UserDao userDao, final UsersManagementService usersManagementService) {
        this.customerDao = customerDao;
        this.addressesManagementService = addressesManagementService;
        this.addressDao = addressDao;
        this.userDao = userDao;
        this.usersManagementService = usersManagementService;
    }

    @Override
    @Transactional(rollbackFor = FunctionalException.class)
    public int createCustomer(@NonNull final CustomerCreationDto newCustomer) throws FunctionalException {
        if (customerDao.existsByEmail(newCustomer.email().toLowerCase(Locale.getDefault()))) {
            throw new InvalidEmailException("A customer already exists for the given email address");
        }

        Customer customer = new Customer();
        customer.setFirstName(newCustomer.firstName());
        customer.setLastName(newCustomer.lastName());
        customer.setEmail(newCustomer.email().toLowerCase(Locale.getDefault()));
        customer.setAddress(createAddressForCustomer(newCustomer));
        customer.setUser(createUserForCustomer(newCustomer));

        customer = customerDao.save(customer);

        log.info("New customer {} ({}) registered with the ID {}", customer.getFullName(), customer.getEmail(),
                customer.getId());

        return customer.getId();
    }

    private User createUserForCustomer(final CustomerCreationDto newCustomer) throws InvalidUsernameException {
        int userId = usersManagementService.createUser(new UserCreationDto(newCustomer.username(),
                new String(newCustomer.password(),StandardCharsets.UTF_8)));
        return userDao.getReferenceById(userId);
    }

    private Address createAddressForCustomer(final CustomerCreationDto newCustomer) {
        AddressCreationDto newAddress = new AddressCreationDto(
                newCustomer.addressLine1(), newCustomer.addressLine2(),
                newCustomer.postalCode(), newCustomer.cityId());

        int addressId = addressesManagementService.createAddress(newAddress);

        return addressDao.getReferenceById(addressId);
    }
}
