package com.guia.api_guia.modelo;

import javax.annotation.processing.Generated;

import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.NotFound;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings({ "deprecation", "unused" })
@Entity
@Table(name= "aprovados")
@Getter
@Setter

public class GuiaModeloAprovados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    @NotFound
    @NotNull
    @JsonIgnore

    private Long id;
    private String nome;
    private String tel;
    private String face;
    private String insta;
    private String descricao;
    
}