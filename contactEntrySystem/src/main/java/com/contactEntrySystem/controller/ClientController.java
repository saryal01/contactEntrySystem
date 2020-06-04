package com.contactEntrySystem.controller;
import java.util.HashMap;

import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contactEntrySystem.model.*;
import com.contactEntrySystem.Repo.*;
import com.contactEntrySystem.exception.*;


@RestController
public class ClientController {
    @Autowired
    private Repo employeeRepository;

    @GetMapping("/contacts")
    public List < Client > getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/contacts/{id}")
    public ResponseEntity < Client > getConatctById(@PathVariable(value = "id") Long id)
    {
    	Client employee = employeeRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("contact not found for this id :: " + id, "id", 0));
        return ResponseEntity.ok().body(employee);
    }

    @PostMapping("/contact")
    public Client createContact(@Validated @RequestBody Client employee) {
        return employeeRepository.save(employee);
    }

    @PutMapping("/contacts/{id}")
    public ResponseEntity < Client > updateContact(@PathVariable(value = "id") Long clientId,
        @Validated @RequestBody Client employeeDetails) throws ResourceNotFoundException {
    	Client client = employeeRepository.findById(clientId)
    			 .orElseThrow(() -> new ResourceNotFoundException("contact not found for this id :: " + clientId, "id", 0));
    	client.setEmail(employeeDetails.getEmail());
        client.setAddress(employeeDetails.getAddress());
        client.setId(employeeDetails.getId());
        client.setName(employeeDetails.getName());
        client.setPhone(employeeDetails.getPhone());
        final Client updatedEmployee = employeeRepository.save(client);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/contacts/{id}")
    public Map < String, Boolean > deleteContact(@PathVariable(value = "id") Long id)
    throws ResourceNotFoundException {
        Client employee = employeeRepository.findById(id)
            .orElseThrow(( )-> new ResourceNotFoundException("Contact not found for this id :: " + id,"id",0));

        employeeRepository.delete(employee);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}