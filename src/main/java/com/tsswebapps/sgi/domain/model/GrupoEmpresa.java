package com.tsswebapps.sgi.domain.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class GrupoEmpresa {
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	@Column(nullable = false)
	private String razaoSocial;
	
	@Column(nullable = false)
	private String nomeFantasia;
	
	@OneToMany
	@JoinColumn(name = "documentos_grupo_empresa", nullable = false, referencedColumnName = "id")
	private List<Documentos> documentos = new ArrayList<>();
	
	@Column(nullable = false)
	private String numEndereco;
	
	@Column(name = "complemento_endereco_empresa", nullable = false)
	private String complementoEndereco;
	
	@ManyToOne
	@JoinColumn(nullable = false, referencedColumnName = "id")
	private Rua endereco;	
	
	@ManyToMany
	@JoinTable(name = "agrupamento_empresas", joinColumns = @JoinColumn(name = "grupo_empresa_id"),
	inverseJoinColumns = @JoinColumn(name = "empresa_id"))
	private Set<GrupoEmpresa> empresas = new HashSet<>();	

}
