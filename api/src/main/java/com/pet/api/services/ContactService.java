package com.pet.api.services;

import com.pet.api.entities.ContactEntity;
import com.pet.api.repository.ContactRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Transactional(rollbackOn = Exception.class)
@RequiredArgsConstructor
public class ContactService {
  private final ContactRepository contactRepository;

  public Page<ContactEntity> getAllContacts(int page, int size) {
    return contactRepository.findAll(PageRequest.of(page, size, Sort.by("id")));
  }

  public ContactEntity getContactById(String id) {
    return contactRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
  }

  public ContactEntity createContact(ContactEntity contact) {
    return contactRepository.save(contact);
  }

  public void deleteContact(String id) {
    contactRepository.deleteById(id);
  }

  public ContactEntity updateContact(String id, String name) {
    ContactEntity contact = contactRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    contact.setName(name);
    return contactRepository.save(contact);
  }
}
