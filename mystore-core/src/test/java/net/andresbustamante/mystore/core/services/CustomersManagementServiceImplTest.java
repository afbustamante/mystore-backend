package net.andresbustamante.mystore.core.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import net.andresbustamante.mystore.api.model.AddressCreationDto;
import net.andresbustamante.mystore.api.model.CustomerCreationDto;
import net.andresbustamante.mystore.api.model.UserCreationDto;
import net.andresbustamante.mystore.api.services.AddressesManagementService;
import net.andresbustamante.mystore.api.services.UsersManagementService;
import net.andresbustamante.mystore.core.dao.AddressDao;
import net.andresbustamante.mystore.core.dao.CustomerDao;
import net.andresbustamante.mystore.core.dao.UserDao;
import net.andresbustamante.mystore.core.entities.Address;
import net.andresbustamante.mystore.core.entities.Customer;
import net.andresbustamante.mystore.core.entities.User;

@ExtendWith(MockitoExtension.class)
class CustomersManagementServiceImplTest {

    @InjectMocks
    private CustomersManagementServiceImpl customersManagementService;

    @Mock
    private CustomerDao customerDao;

    @Mock
    private AddressesManagementService addressesManagementService;

    @Mock
    private UsersManagementService usersManagementService;

    @Mock
    private AddressDao addressDao;

    @Mock
    private UserDao userDao;

    @Test
    void testCreateCustomer() throws Exception {
        CustomerCreationDto customer = new CustomerCreationDto("Cristiano", "Ronaldo", "cr7@foot.pt",
                "01 23 45 67 89", "cr7", "password".getBytes(StandardCharsets.UTF_8), "123 Rue des Sports",
                null, "12345", 1);

        Customer storedCustomer = new Customer();
        storedCustomer.setId(1000);
        when(customerDao.save(any(Customer.class))).thenReturn(storedCustomer);

        Address storedAddress = new Address();
        storedAddress.setId(2000);
        when(addressesManagementService.createAddress(any(AddressCreationDto.class))).thenReturn(2000);
        when(addressDao.getReferenceById(2000)).thenReturn(storedAddress);

        User storedUser = new User();
        storedUser.setId(3000);
        when(usersManagementService.createUser(any(UserCreationDto.class))).thenReturn(3000);
        when(userDao.getReferenceById(3000)).thenReturn(storedUser);

        int id = customersManagementService.createCustomer(customer);

        assertEquals(1000, id);

        verify(addressesManagementService).createAddress(any(AddressCreationDto.class));
        verify(usersManagementService).createUser(any(UserCreationDto.class));
    }
}
