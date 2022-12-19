package br.com.ProjetoEstudo.crudkafkaapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_post")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "fk_id_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario;
    @Column(name = "titulo_post")
    private String titulo;
    @Column(name = "texto_post")
    private String texto;
    @Column(name = "visualisacao_post")
    private Integer visualisacao;
    @Column(name = "datetime_post")
    private LocalDateTime dataHoraPublicacao;
}
