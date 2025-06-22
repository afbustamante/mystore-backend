package net.andresbustamante.mystore.api.services;

import net.andresbustamante.mystore.api.exceptions.FunctionalException;
import net.andresbustamante.mystore.api.model.CustomerCreationDto;

public interface CustomersManagementService {

    int createCustomer(CustomerCreationDto customerCreationCommand) throws FunctionalException;
}
