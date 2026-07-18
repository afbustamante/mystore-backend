package net.andresbustamante.mystore.api.services;

import net.andresbustamante.mystore.api.exceptions.ApplicationException;
import net.andresbustamante.mystore.api.model.CustomerCreation;
import net.andresbustamante.mystore.api.model.CustomerUpdate;

/**
 * Customers' management service.
 */
public interface CustomersManagementService {

    /**
     * Creates a new customer in the application.
     *
     * @param newCustomer Data to use for the new customer.
     * @return The technical ID of the new user.
     * @throws ApplicationException When a problem is found during customer creation.
     */
    int createCustomer(CustomerCreation newCustomer) throws ApplicationException;

    /**
     * Updates a given customer.
     *
     * @param customerId ID of the customer to be updated.
     * @param customer   Customer data to use for the update.
     * @throws ApplicationException When a problem is found during the update.
     */
    void updateCustomer(Integer customerId, CustomerUpdate customer) throws ApplicationException;

    /**
     * Deactivates an existing user.
     *
     * @param customerId ID of the user to be deactivated.
     * @throws ApplicationException When a problem occurs during the deactivation process.
     */
    void deactivateCustomer(Integer customerId) throws ApplicationException;
}
