package ua.lviv.iot.terminal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.terminal.domain.Address;
import ua.lviv.iot.terminal.service.AddressService;

@RestController
@RequestMapping(value = "api/address", produces = MediaType.APPLICATION_JSON_VALUE)
public class AddressController extends AbstractController<Address> {

  @Autowired
  public AddressController(AddressService addressService) {
    super(addressService);
  }

  @Override
  @PutMapping("/{id}")
  public ResponseEntity<Address> updateObject(@PathVariable final Integer id,
                                              @RequestBody final Address address) {
    address.setId(id);
    Address oldAddress = service.updateObject(id, address, new Address());
    return oldAddress == null
        ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
        : new ResponseEntity<>(oldAddress, HttpStatus.OK);
  }
}
