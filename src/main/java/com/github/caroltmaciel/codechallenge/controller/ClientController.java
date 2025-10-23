package com.github.caroltmaciel.codechallenge.controller;

import com.github.caroltmaciel.codechallenge.domain.Contract;
import com.github.caroltmaciel.codechallenge.dto.ClientDto;
import com.github.caroltmaciel.codechallenge.dto.ContractDto;
import com.github.caroltmaciel.codechallenge.dto.UpdateContractRequest;
import com.github.caroltmaciel.codechallenge.exception.NotFoundException;
import com.github.caroltmaciel.codechallenge.service.ClientService;
import com.github.caroltmaciel.codechallenge.service.ContractService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    private final ClientService service;
    private final ContractService contractService;

    public ClientController(ClientService service, ContractService contractService) {
        this.service = service;
        this.contractService = contractService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDto> findById(@PathVariable Long id) throws NotFoundException {
        ClientDto obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody ClientDto objDto) {
        ClientDto obj = service.insert(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody ClientDto objDto, @PathVariable Long id) throws NotFoundException {
        objDto.setId(id);
        service.update(objDto);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/{id}/contracts")
    public ResponseEntity<Void> insertContract(@PathVariable(name = "id") Long clientId, @RequestBody ContractDto objDto) {
        Contract obj = contractService.insert(clientId, objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PatchMapping(value = "/{id}/contracts/{contractId}")
    public ResponseEntity<Void> updateContract(@PathVariable(name = "id") Long clientId, @PathVariable(name = "contractId") Long contractId, @RequestBody UpdateContractRequest request) {
        contractService.update(contractId, request);
        return ResponseEntity.ok().build();
    }

}
