package com.github.caroltmaciel.codechallenge.service;

import com.github.caroltmaciel.codechallenge.domain.Client;
import com.github.caroltmaciel.codechallenge.dto.ClientDto;
import com.github.caroltmaciel.codechallenge.exception.NotFoundException;
import com.github.caroltmaciel.codechallenge.mapper.ClientMapper;
import com.github.caroltmaciel.codechallenge.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private static final String CLIENT_NOT_FOUND = "Client not found";

    @Autowired
    private ClientRepository repo;

    @Autowired
    private ClientMapper mapper;

    public ClientDto findById(Long id) throws NotFoundException {
        Client client = repo.findById(id)
                .orElseThrow(() -> new NotFoundException(CLIENT_NOT_FOUND));
        ClientDto clientDto = mapper.mapToClientDto(client);
        return clientDto;
    }

    public ClientDto insert(ClientDto clientDto) {
        Client client = mapper.mapToClient(clientDto);
        Client savedClient = repo.save(client);
        return mapper.mapToClientDto(savedClient);
    }

    public void delete(Long id) {
        //findById(id);
        repo.deleteById(id);
    }

    public ClientDto update(ClientDto obj) throws NotFoundException {
        Client newData = mapper.mapToClient(obj);

        Client existentObj = repo.findById(newData.getId())
                .orElseThrow(() -> new NotFoundException(CLIENT_NOT_FOUND));
        mapper.updateData(newData, existentObj);

        Client save = repo.save(newData);
        return mapper.mapToClientDto(save);
    }

}
