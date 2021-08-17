package com.tsswebapps.sgi.domain.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.tsswebapps.sgi.domain.enums.Situacao;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Empresa {	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;	
	
	@Column(nullable = false, length = 50)
	private String razaoSocial;
	
	@Column(nullable = false, length = 50)
	private String nomeFantasia;	
	
	@Column(nullable = false, length = 6)
	private String numEndereco;
	
	@Column(name = "complemento_endereco_empresa", nullable = false, length = 100)
	private String complementoEndereco;
	
	@ManyToOne
	@JoinColumn(nullable = false, referencedColumnName = "id")
	private Rua endereco;
	
	@OneToMany
	@JoinColumn(name = "documentos_empresa", nullable = false, referencedColumnName = "id")
	private List<Documentos> documentos = new ArrayList<>();
	
	@OneToMany
	@JoinColumn(name = "telefones_empresa", nullable = false, referencedColumnName = "id")
	private List<Telefone> telefone = new ArrayList<>();	
	
	@Column(nullable = false)
	private Situacao situacao;	
	
	@Column(nullable = false)
	private String email;	

	
	@Column(nullable = false)
	private String observacao;
	
	@CreationTimestamp
	@Column(name = "dtcadastro", nullable = false, columnDefinition = "datetime")
	private LocalDateTime dtCriacao;
	
	@UpdateTimestamp
	@Column(name = "dtalteracao", nullable = false, columnDefinition = "datetime")
	private LocalDateTime dtAlteracao;
}
