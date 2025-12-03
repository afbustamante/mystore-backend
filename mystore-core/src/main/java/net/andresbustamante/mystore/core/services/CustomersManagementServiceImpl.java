package net.andresbustamante.mystore.core.services;

import java.nio.charset.StandardCharsets;
import java.util.Locale;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import net.andresbustamante.mystore.api.exceptions.ApplicationException;
import net.andresbustamante.mystore.api.exceptions.InvalidEmailException;
import net.andresbustamante.mystore.api.exceptions.ObjectNotFoundException;
import net.andresbustamante.mystore.api.model.AddressCreationDto;
import net.andresbustamante.mystore.api.model.CustomerCreationDto;
import net.andresbustamante.mystore.api.model.CustomerUpdateDto;
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
    @Transactional(rollbackFor = ApplicationException.class)
    public int createCustomer(@NonNull final CustomerCreationDto newCustomer) throws ApplicationException {
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

    @Override
    @Transactional(rollbackFor = ApplicationException.class)
    public void deactivateCustomer(@NonNull final Integer customerId) throws ApplicationException {
        Customer customer = customerDao.findById(customerId).orElseThrow(
                () -> new ObjectNotFoundException(String.format("Customer not found with the given ID: %d", customerId)));

        // Also deactivate the user to avoid any authentication attempt
        usersManagementService.deactivateUser(customer.getUser().getId());
        customerDao.delete(customer); // Hibernate makes a soft-delete here

        log.info("Customer {} has been deactivated", customerId);
    }

    @Override
    @Transactional(rollbackFor = ApplicationException.class)
    public void updateCustomer(final Integer customerId, final CustomerUpdateDto newCustomer) throws ApplicationException {
        Customer customer = customerDao.findById(customerId).orElseThrow();

        customer.setFirstName(newCustomer.firstName());
        customer.setLastName(newCustomer.lastName());
        customer.setEmail(newCustomer.email().toLowerCase(Locale.getDefault()));
        customer.setPhoneNumber(newCustomer.phoneNumber());

        customerDao.save(customer);

        log.info("The customer {} has been successfully updated", customerId);
    }

    private User createUserForCustomer(final CustomerCreationDto newCustomer) throws ApplicationException {
        int userId = usersManagementService.createUser(new UserCreationDto(newCustomer.username(),
                new String(newCustomer.password(),StandardCharsets.UTF_8)));
        return userDao.getReferenceById(userId);
    }

    private Address createAddressForCustomer(final CustomerCreationDto newCustomer) throws ApplicationException {
        AddressCreationDto newAddress = new AddressCreationDto(
                newCustomer.addressLine1(), newCustomer.addressLine2(),
                newCustomer.postalCode(), newCustomer.cityId());

        int addressId = addressesManagementService.createAddress(newAddress);

        return addressDao.getReferenceById(addressId);
    }
}
