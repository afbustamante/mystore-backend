package net.andresbustamante.mystore.api.services;

import net.andresbustamante.mystore.api.model.Address;

public interface AddressesSearchService {

    Address findAddress(Integer addressId);
}
