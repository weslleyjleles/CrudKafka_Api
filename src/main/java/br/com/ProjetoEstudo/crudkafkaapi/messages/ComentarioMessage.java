package br.com.ProjetoEstudo.crudkafkaapi.messages;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComentarioMessage {

	private Integer idComment;
	private Integer idPublicacao;
	private Integer idUsuario;
	private String textoComment;
	private String acaoComment;
}
