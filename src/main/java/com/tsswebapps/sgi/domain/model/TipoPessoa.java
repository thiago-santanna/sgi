package com.tsswebapps.sgi.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class TipoPessoa {
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	@Column(length = 50, nullable = false)
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "id_empresa_fk", referencedColumnName = "id")
	private Empresa empresa;
}
