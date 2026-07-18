package net.andresbustamante.mystore.api.services;

import net.andresbustamante.mystore.api.exceptions.ApplicationException;
import net.andresbustamante.mystore.api.model.AddressCreation;
import net.andresbustamante.mystore.api.util.UserContext;

/**
 * Addresses management service.
 */
public interface AddressesManagementService {

    /**
     * Registers a new address in database.
     *
     * @param address The address to create.
     * @param ctx     The context of the current user.
     * @return Technical ID of the new address.
     * @throws ApplicationException When the address cannot be stored in database.
     */
    int createAddress(AddressCreation address, UserContext ctx) throws ApplicationException;
}
