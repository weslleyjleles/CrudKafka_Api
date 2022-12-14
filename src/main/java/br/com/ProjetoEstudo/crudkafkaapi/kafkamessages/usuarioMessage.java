package br.com.ProjetoEstudo.crudkafkaapi.kafkamessages;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class usuarioMessage {
    private String nomeUsuario;
    private String emailUsuario;
    private String userUsuario;
    private String senhaUsuario;
    private String telefoneUsuario;
    private String acaoUsuario;
}
