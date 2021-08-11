package com.tsswebapps.sgi.domain.model.endereco;

import lombok.Data;

@Data
public class Estado {
	private Long id;
	private String descricao;
	private Pais pais;
}
