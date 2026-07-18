package net.andresbustamante.mystore.core.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import net.andresbustamante.mystore.api.model.AddressCreation;
import net.andresbustamante.mystore.api.model.CustomerCreation;
import net.andresbustamante.mystore.api.model.UserCreation;
import net.andresbustamante.mystore.api.services.AddressesManagementService;
import net.andresbustamante.mystore.api.services.UsersManagementService;
import net.andresbustamante.mystore.api.util.UserContext;
import net.andresbustamante.mystore.jpa.dao.AddressDao;
import net.andresbustamante.mystore.jpa.dao.CustomerDao;
import net.andresbustamante.mystore.jpa.dao.UserDao;
import net.andresbustamante.mystore.jpa.entities.AddressEntity;
import net.andresbustamante.mystore.jpa.entities.CustomerEntity;
import net.andresbustamante.mystore.jpa.entities.UserEntity;

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
        CustomerCreation customer = new CustomerCreation("Cristiano", "Ronaldo", "cr7@foot.pt",
                "01 23 45 67 89", "cr7", "password".getBytes(StandardCharsets.UTF_8), "123 Rue des Sports",
                null, "12345", 1);

        CustomerEntity storedCustomer = new CustomerEntity();
        storedCustomer.setId(1000);
        when(customerDao.save(any(CustomerEntity.class))).thenReturn(storedCustomer);

        AddressEntity storedAddress = new AddressEntity();
        storedAddress.setId(2000);
        when(addressesManagementService.createAddress(any(AddressCreation.class), any(UserContext.class))).thenReturn(2000);
        when(addressDao.getReferenceById(2000)).thenReturn(storedAddress);

        UserEntity storedUser = new UserEntity();
        storedUser.setId(3000);
        when(usersManagementService.createUser(any(UserCreation.class), any(UserContext.class))).thenReturn(3000);
        when(userDao.getReferenceById(3000)).thenReturn(storedUser);

        int id = customersManagementService.createCustomer(customer, new UserContext("test"));

        assertEquals(1000, id);

        verify(addressesManagementService).createAddress(any(AddressCreation.class), any(UserContext.class));
        verify(usersManagementService).createUser(any(UserCreation.class), any(UserContext.class));
    }
}
