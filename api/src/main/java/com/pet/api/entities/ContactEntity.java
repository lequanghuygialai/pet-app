package com.pet.api.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pet.api.enums.ContactStatusEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Table(name = "contacts")
public class ContactEntity {
  @Id
  @UuidGenerator
  @Column(name = "id", unique = true, updatable = false)
  String id;
  String name;
  String email;
  String title;
  String phone;
  String address;
  ContactStatusEnum status;
}
