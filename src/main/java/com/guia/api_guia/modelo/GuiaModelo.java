package com.guia.api_guia.modelo;

import javax.annotation.processing.Generated;

import org.hibernate.annotations.NotFound;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Lob;

@SuppressWarnings({ "unused" })
@Entity
@Table(name= "pendentes")
@Getter
@Setter

public class GuiaModelo {

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
