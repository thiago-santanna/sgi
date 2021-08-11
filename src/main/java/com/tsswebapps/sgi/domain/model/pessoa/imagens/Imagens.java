package com.tsswebapps.sgi.domain.model.pessoa.imagens;

import com.tsswebapps.sgi.domain.model.pessoa.Pessoa;

import lombok.Data;

@Data
public class Imagens {
	private Long id;
	private String url;
	private Pessoa pessoa;
}
