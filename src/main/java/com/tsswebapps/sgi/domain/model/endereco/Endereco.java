package com.tsswebapps.sgi.domain.model.endereco;

import lombok.Data;

@Data
public class Endereco {
	private Long id;
	private String nomeRua;
	private String cep;
	private Cidade cidade;
}
