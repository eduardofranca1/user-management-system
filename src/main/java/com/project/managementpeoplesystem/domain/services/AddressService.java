package com.project.managementpeoplesystem.domain.services;

import com.project.managementpeoplesystem.api.dto.AddressDTO;
import com.project.managementpeoplesystem.api.dto.mapper.AddressMapper;
import com.project.managementpeoplesystem.domain.exceptions.ResourceNotFoundException;
import com.project.managementpeoplesystem.domain.model.Address;
import com.project.managementpeoplesystem.domain.repositories.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class AddressService {

    private final AddressRepository addressRepository;

    private final AddressMapper addressMapper = AddressMapper.INSTANCE;

    public List<AddressDTO> listAll() {
        List<Address> addresses = addressRepository.findAll();
        return addresses.stream()
                .map(addressMapper::toDTO)
                .collect(Collectors.toList());
    }

    public AddressDTO findById(Long id) {

        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Address does not found."));

        return addressMapper.toDTO(address);
    }
}
