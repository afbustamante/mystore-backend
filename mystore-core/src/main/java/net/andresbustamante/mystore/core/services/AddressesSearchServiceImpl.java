package net.andresbustamante.mystore.core.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.andresbustamante.mystore.api.model.Address;
import net.andresbustamante.mystore.api.services.AddressesSearchService;
import net.andresbustamante.mystore.core.dao.AddressDao;
import net.andresbustamante.mystore.core.mappers.AddressMapper;

@Service
@Transactional(readOnly = true)
public class AddressesSearchServiceImpl implements AddressesSearchService {

    private final AddressDao addressDao;
    private final AddressMapper addressMapper;

    public AddressesSearchServiceImpl(final AddressDao addressDao, final AddressMapper addressMapper) {
        this.addressDao = addressDao;
        this.addressMapper = addressMapper;
    }

    @Override
    public Address findAddress(final Integer addressId) {
        return addressDao.findById(addressId).map(addressMapper::map).orElse(null);
    }
}
