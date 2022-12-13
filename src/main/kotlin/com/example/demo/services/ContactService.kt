package com.example.demo.services

import com.example.demo.entities.ContactEntity
import com.example.demo.repositories.ContactRepository
import org.springframework.stereotype.Service
import javax.persistence.EntityNotFoundException

@Service
class ContactService constructor(private val repository: ContactRepository) {

    fun index(): List<ContactEntity> {
        return repository.findAll()
    }

    fun show(id: Long): ContactEntity {
        return repository.findById(id).orElseThrow { EntityNotFoundException() }
    }

    fun create(contact: ContactEntity): ContactEntity {
        return repository.save(contact)
    }

    fun update(id: Long, newContact: ContactEntity): ContactEntity {
        val contact = repository.findById(id).orElseThrow { EntityNotFoundException() }

        contact.apply {
            this.name = newContact.name
            this.email = newContact.email
        }

        return repository.save(contact)
    }

    fun remove(id: Long) {
        val contact = repository.findById(id).orElseThrow { EntityNotFoundException() }

        repository.delete(contact)
    }
}