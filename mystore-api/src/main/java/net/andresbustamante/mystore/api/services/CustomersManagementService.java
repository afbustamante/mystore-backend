package net.andresbustamante.mystore.api.services;

import net.andresbustamante.mystore.api.exceptions.ApplicationException;
import net.andresbustamante.mystore.api.model.CustomerCreationDto;

/**
 * Customers' management service.
 */
public interface CustomersManagementService {

    /**
     * Creqtes a new customer in the application.
     *
     * @param newCustomer Data to use for the new customer.
     * @return The technical ID of the new user.
     * @throws ApplicationException When a problem is found during customer creation.
     */
    int createCustomer(CustomerCreationDto newCustomer) throws ApplicationException;

    /**
     * Deactivates an existing user.
     *
     * @param customerId ID of the user to be deactivated.
     * @throws ApplicationException When a problem occurs during the deactivation process.
     */
    void deactivateCustomer(Integer customerId) throws ApplicationException;
}
