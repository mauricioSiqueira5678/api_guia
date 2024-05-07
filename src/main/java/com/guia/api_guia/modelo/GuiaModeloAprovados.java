package com.guia.api_guia.modelo;

import javax.annotation.processing.Generated;

import org.hibernate.annotations.NotFound;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Lob;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings({ "unused" })
@Entity
@Table(name= "aprovados")
@Getter
@Setter

public class GuiaModeloAprovados {

    @SuppressWarnings("null")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    @NotFound
    @NonNull
    @JsonIgnore

    private Long id;
    private String nome;
    private String tel;
    private String face;
    private String insta;
    private String categoria;
    private String descricao;
   
    @Lob
    private byte[] imagem; // Campo para armazenar a imagem

    
}
