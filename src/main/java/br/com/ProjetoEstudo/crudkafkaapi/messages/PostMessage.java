package br.com.ProjetoEstudo.crudkafkaapi.messages;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostMessage {
    private Integer idPublicacao;
    private Integer idUsuario;
    private String tituloPublicacao;
    private String textoPublicacao;
    private Integer visualisacaoPublicacao;
    private LocalDateTime dataHoraPublicacao;
    private String acaoPublicacao;
}
