package net.andresbustamante.mystore.api.services;

import net.andresbustamante.mystore.api.model.AddressCreationDto;

public interface AddressesManagementService {

    int createAddress(AddressCreationDto address);
}
