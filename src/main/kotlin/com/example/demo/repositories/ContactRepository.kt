package com.example.demo.repositories

import com.example.demo.entities.ContactEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Listagem ocorre pela Entity (Contact) e pela chave primária,
 * no caso o Id do tipo Long.
 * */
@Repository
interface ContactRepository: JpaRepository<ContactEntity, Long>
