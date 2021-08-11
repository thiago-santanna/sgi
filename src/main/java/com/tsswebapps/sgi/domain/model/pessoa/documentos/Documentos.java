package com.tsswebapps.sgi.domain.model.pessoa.documentos;

import lombok.Data;

@Data
public class Documentos {
	private Long id;
	private String Descricao;
	private TiposDocumentos tipoDocumento;
}
