
package com.tsswebapps.sgi.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.tsswebapps.sgi.domain.enums.TiposDocumentos;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Documentos {
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	@Column(nullable = false, length = 50)
	private String descricao;
	
	@Column(nullable = false)
	private TiposDocumentos tipoDocumento;
	
	@ManyToOne
	@JoinColumn(name = "id_empresa_fk", referencedColumnName = "id")
	private Empresa empresa;	
}
