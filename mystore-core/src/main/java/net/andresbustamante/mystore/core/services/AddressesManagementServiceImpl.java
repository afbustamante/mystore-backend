package net.andresbustamante.mystore.core.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import net.andresbustamante.mystore.api.model.AddressCreation;
import net.andresbustamante.mystore.api.services.AddressesManagementService;
import net.andresbustamante.mystore.api.util.UserContext;
import net.andresbustamante.mystore.jpa.dao.AddressDao;
import net.andresbustamante.mystore.jpa.dao.CityDao;
import net.andresbustamante.mystore.jpa.entities.AddressEntity;
import net.andresbustamante.mystore.jpa.entities.CityEntity;

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
    public int createAddress(final AddressCreation address, final UserContext ctx) {
        AddressEntity newAddress = new AddressEntity();
        newAddress.setLine1(address.line1());
        newAddress.setLine2(address.line2());
        newAddress.setPostalCode(address.postalCode());

        CityEntity city = cityDao.getReferenceById(address.cityId());
        newAddress.setCity(city);

        newAddress = addressDao.save(newAddress);

        log.info("New address created in {} with the ID {}", city.getName(), newAddress.getId());

        return newAddress.getId();
    }
}
