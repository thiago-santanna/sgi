package com.tsswebapps.sgi.domain.model;

import java.time.LocalDateTime;
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
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.tsswebapps.sgi.domain.enums.Batizado;
import com.tsswebapps.sgi.domain.enums.Sexo;
import com.tsswebapps.sgi.domain.enums.Situacao;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Pessoa {
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	@Column(length = 50)
	private String nome;
	
	@Column(name = "dtnasc", nullable = false, columnDefinition = "datetime")
	private LocalDateTime dtNascimento;
	
	@Column(nullable = false)
	private String numEndereco;
	
	@Column(name = "complemento_endereco_pessoa", nullable = false)
	private String complementoEndereco;
	
	@OneToOne
	@JoinColumn(nullable = false, referencedColumnName = "id")
	private Rua endereco;
	
	@OneToOne
	@JoinColumn(name = "tipo_fk", nullable = false, referencedColumnName = "id")
	private TipoPessoa tipoPessoa;
	
	@OneToOne
	@JoinColumn(nullable = false, referencedColumnName = "id")
	private Profissao profissao;
	
	@OneToOne
	@JoinColumn(nullable = false, referencedColumnName = "id")
	private EstadoCivil estadoCivil;
	
	@OneToMany
	@JoinColumn(name = "documentos_pessoa", nullable = false, referencedColumnName = "id")
	private List<Documentos> documentos = new ArrayList<>();
	
	@OneToMany
	@JoinColumn(name = "telefones_pessoa", nullable = false, referencedColumnName = "id")
	private List<Telefone> telefone = new ArrayList<>();
	
	@Column
	private Sexo sexo;
	
	@Column(length = 100)
	private String email;
	
	@Column(name = "status")
	private Situacao situacao;
	
	@Column
	private Batizado batizado;
	
	@Column(name = "obs", length = 100)
	private String observacao;
	
	@OneToOne
	@JoinColumn(nullable = false, referencedColumnName = "id")
	private Empresa empresaDefault;
	
	@ManyToOne
	@JoinColumn(name = "id_empresa_fk", referencedColumnName = "id")
	private Empresa empresa;	
	
	@OneToMany
	@JoinColumn(nullable = false, referencedColumnName = "id")
	private List<Imagens> imagens = new ArrayList<>();
	
	@CreationTimestamp
	@Column(nullable = false, columnDefinition = "datetime")
	private LocalDateTime dtCriacao;
	
	@UpdateTimestamp
	@Column(nullable = false, columnDefinition = "datetime")
	private LocalDateTime dtAlteracao;	
	
	@ManyToMany
	@JoinTable(name = "usuario_empresas", joinColumns = @JoinColumn(name = "pessoa_id"), 
	inverseJoinColumns = @JoinColumn(name = "empresa_id"))	
	private Set<Empresa> empresas = new HashSet<>();
}
