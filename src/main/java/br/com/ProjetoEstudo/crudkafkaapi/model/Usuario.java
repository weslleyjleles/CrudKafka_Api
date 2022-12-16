package br.com.ProjetoEstudo.crudkafkaapi.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "public", name = "tbl_usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer id;
    @Column(name = "nome_usuario")
    private String nome;
    @Column(name = "email_usuario")
    private String email;
    @Column(name = "user_usuario")
    private String username;
    @Column(name = "senha_usuario")
    private String senha;
    @Column(name = "telefone_usuario")
    private String telefone;
}
