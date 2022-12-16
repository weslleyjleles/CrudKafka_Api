package br.com.ProjetoEstudo.crudkafkaapi.messages;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImageMessage {
    private Integer idImagem;
    private Integer idPublicacao;
    private String imagem64;
    private String extensaoImagem;
    private String acaoImagem;
}
