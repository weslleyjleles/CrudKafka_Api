package br.com.ProjetoEstudo.crudkafkaapi.messages;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LikeMessage {
	private Integer id;                   //usar id no caso de ação de delete
	private Integer idUsuario;
	private Integer idPublicacao;
	private Integer idComentario;
	private String acaoLike;
	
}
