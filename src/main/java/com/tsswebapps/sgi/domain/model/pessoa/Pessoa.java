package com.tsswebapps.sgi.domain.model.pessoa;

import java.time.LocalDateTime;

import com.tsswebapps.sgi.domain.enums.Batizado;
import com.tsswebapps.sgi.domain.enums.Sexo;
import com.tsswebapps.sgi.domain.enums.Situacao;
import com.tsswebapps.sgi.domain.model.endereco.Endereco;
import com.tsswebapps.sgi.domain.model.igreja.Igreja;
import com.tsswebapps.sgi.domain.model.pessoa.estadocivil.EstadoCivil;
import com.tsswebapps.sgi.domain.model.pessoa.profissao.Profissao;
import com.tsswebapps.sgi.domain.model.pessoa.telefone.Telefone;
import com.tsswebapps.sgi.domain.model.pessoa.tipopessoa.TipoPessoa;

import lombok.Data;

@Data
public class Pessoa {
	private Long id;
	private String nome;
	private LocalDateTime dtNascimento;
	private String numEndereco;
	private String complementoEndereco;
	private Endereco endereco;
	private TipoPessoa tipoPessoa;
	private Profissao profissao;
	private EstadoCivil estadoCivil;
	private String rg;
	private String cpf;
	private Telefone telefone;
	private Sexo sexo;
	private String email;
	private Situacao situacao;
	private Batizado batizado;
	private String observacao;
	private String urlImagem;
	private Igreja igreja;
}
