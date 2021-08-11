package com.tsswebapps.sgi.domain.model.endereco;

import lombok.Data;

@Data
public class Cidade {
	private Long id;
	private String codigoCidade;
	private String descricao;
	private Estado estado;
	
}
