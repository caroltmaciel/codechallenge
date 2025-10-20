package com.github.caroltmaciel.codechallenge.mapper;

import com.github.caroltmaciel.codechallenge.domain.Client;
import com.github.caroltmaciel.codechallenge.dto.ClientDto;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

@Component
public class ClientMapper {

    public ClientDto mapToClientDto(Client client) {
        String name = client.getName();
        Integer phone = client.getPhone();
        String email = client.getEmail();
        Long id = client.getId();
        LocalDate birthDate = client.getBirthDate();
        String companyIdentifier = client.getCompanyIdentifier();

        ClientDto dto = new ClientDto();
        dto.setName(name);
        dto.setPhone(phone);
        dto.setEmail(email);
        dto.setId(id);
        dto.setBirthDate(birthDate);
        dto.setCompanyIdentifier(companyIdentifier);

        return dto;
    }

    public Client mapToClient(ClientDto dto) {
        String name = dto.getName();
        Integer phone = dto.getPhone();
        String email = dto.getEmail();
        Long id = dto.getId();
        LocalDate birthDate = dto.getBirthDate();
        String companyIdentifier = dto.getCompanyIdentifier();

        Client client = new Client();
        client.setName(name);
        client.setPhone(phone);
        client.setEmail(email);
        client.setId(id);
        client.setBirthDate(birthDate);
        client.setCompanyIdentifier(companyIdentifier);

        return client;
    }

    public void updateData(Client newObj, Client oldObj) {
        newObj.setName(oldObj.getName());
        newObj.setEmail(oldObj.getEmail());
        newObj.setPhone(oldObj.getPhone());
    }

}
