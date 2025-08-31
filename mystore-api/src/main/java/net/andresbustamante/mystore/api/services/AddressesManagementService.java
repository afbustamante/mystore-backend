package net.andresbustamante.mystore.api.services;

import net.andresbustamante.mystore.api.exceptions.ApplicationException;
import net.andresbustamante.mystore.api.model.AddressCreationDto;

/**
 * Addresses management service.
 */
public interface AddressesManagementService {

    /**
     * Registers a new address in database.
     *
     * @param address The address to create.
     * @return Technical ID of the new address.
     * @exception ApplicationException When the address cannot be stored in database.
     */
    int createAddress(AddressCreationDto address) throws ApplicationException;
}
