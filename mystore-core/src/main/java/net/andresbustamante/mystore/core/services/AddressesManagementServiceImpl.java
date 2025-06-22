package net.andresbustamante.mystore.core.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import net.andresbustamante.mystore.api.model.AddressCreationDto;
import net.andresbustamante.mystore.api.services.AddressesManagementService;
import net.andresbustamante.mystore.core.dao.AddressDao;
import net.andresbustamante.mystore.core.dao.CityDao;
import net.andresbustamante.mystore.core.entities.Address;
import net.andresbustamante.mystore.core.entities.City;

@Slf4j
@Service
public class AddressesManagementServiceImpl implements AddressesManagementService {

    private final AddressDao addressDao;
    private final CityDao cityDao;

    public AddressesManagementServiceImpl(final AddressDao addressDao, final CityDao cityDao) {
        this.addressDao = addressDao;
        this.cityDao = cityDao;
    }

    @Transactional
    @Override
    public int createAddress(final AddressCreationDto address) {
        Address newAddress = new Address();
        newAddress.setLine1(address.line1());
        newAddress.setLine2(address.line2());
        newAddress.setPostalCode(address.postalCode());

        City city = cityDao.getReferenceById(address.cityId());
        newAddress.setCity(city);

        newAddress = addressDao.save(newAddress);

        log.info("New address created in {} with the ID {}", city.getName(), newAddress.getId());

        return newAddress.getId();
    }
}
