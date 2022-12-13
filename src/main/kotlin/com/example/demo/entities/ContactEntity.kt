package com.example.demo.entities

import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

/**
 * Quando se usa @Entity e seta um @Id você transforma
 * essa classe de dados em uma Entidade Jpa
 * */
@Entity
@Table(name = "CONTACTS")
class ContactEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(name = "NAME_CONTACTS")
    @NotNull
    @Size(min = 5, max = 50, message = "Exemplo")
    var name: String,

    @Column(name = "EMAIL_CONTACTS")
    @NotNull
    @Email
    var email: String,
) {}