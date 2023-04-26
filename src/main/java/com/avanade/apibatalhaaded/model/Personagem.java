package com.avanade.apibatalhaaded.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table( name = "PERSONAGEM" )
@Entity
public class Personagem implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private Long id;
	@Column(name = "HEROI", nullable = false)
	private String heroi;
	@Column(name = "VIDA", nullable = false)
	private Long vida;
	@Column(name = "FORCA", nullable = false)
	private Long forca;
	@Column(name = "DEFESA", nullable = false)
	private Long defesa;
	@Column(name = "AGILIDADE", nullable = false)
	private Long agilidade;
	@Column(name = "QUANTIDADE_DADOS", nullable = false)
	private Long quantidadeDados;
	@Column(name = "FACES_DADO", nullable = false)
	private Long facesDado;
	@Column(name = "CREATED_AT", nullable = false)
	private LocalDateTime createdAt;
}