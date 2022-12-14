package br.com.ProjetoEstudo.crudkafkaapi.messages;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioMessage {
    private Integer idUsuario;
    private String nomeUsuario;
    private String emailUsuario;
    private String userUsuario;
    private String senhaUsuario;
    private String telefoneUsuario;
    private String acaoUsuario;
}
