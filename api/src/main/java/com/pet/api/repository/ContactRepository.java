package com.pet.api.repository;

import com.pet.api.entities.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, String> {
  Optional<ContactEntity> findById(String id);
}
