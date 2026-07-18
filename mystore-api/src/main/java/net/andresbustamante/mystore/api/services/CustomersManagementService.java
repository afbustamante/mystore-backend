package net.andresbustamante.mystore.api.services;

import net.andresbustamante.mystore.api.exceptions.ApplicationException;
import net.andresbustamante.mystore.api.model.CustomerCreation;
import net.andresbustamante.mystore.api.model.CustomerUpdate;
import net.andresbustamante.mystore.api.util.UserContext;

/**
 * Customers' management service.
 */
public interface CustomersManagementService {

    /**
     * Creates a new customer in the application.
     *
     * @param newCustomer Data to use for the new customer.
     * @param ctx         The context of the current user.
     * @return The technical ID of the new user.
     * @throws ApplicationException When a problem is found during customer creation.
     */
    int createCustomer(CustomerCreation newCustomer, UserContext ctx) throws ApplicationException;

    /**
     * Updates a given customer.
     *
     * @param customerId ID of the customer to be updated.
     * @param customer   Customer data to use for the update.
     * @param ctx        The context of the current user.
     * @throws ApplicationException When a problem is found during the update.
     */
    void updateCustomer(Integer customerId, CustomerUpdate customer, UserContext ctx) throws ApplicationException;

    /**
     * Deactivates an existing user.
     *
     * @param customerId ID of the user to be deactivated.
     * @param ctx        The context of the current user.
     * @throws ApplicationException When a problem occurs during the deactivation process.
     */
    void deactivateCustomer(Integer customerId, UserContext ctx) throws ApplicationException;
}
