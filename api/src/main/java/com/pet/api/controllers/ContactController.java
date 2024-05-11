package com.pet.api.controllers;

import com.pet.api.entities.ContactEntity;
import com.pet.api.services.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contacts")
@RequiredArgsConstructor
public class ContactController {
  private final ContactService contactService;

  @PostMapping
  public ResponseEntity<ContactEntity> createContact(@RequestBody ContactEntity contact) {
    return ResponseEntity.ok().body(contactService.createContact(contact));
  }

  @GetMapping
  public ResponseEntity<Page<ContactEntity>> getContacts(@RequestParam(value = "page", defaultValue = "0") int page,
                                                         @RequestParam(value = "size", defaultValue = "10") int size) {
    return ResponseEntity.ok().body(contactService.getAllContacts(page, size));
  }

  @GetMapping("/{id}")
  public ResponseEntity<ContactEntity> getContact(@PathVariable(value = "id") String id) {
    return ResponseEntity.ok().body(contactService.getContactById(id));
  }
}
