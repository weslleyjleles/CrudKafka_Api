package br.com.ProjetoEstudo.crudkafkaapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "tbl_comment")
public class Comentario {
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_comment")
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "fk_id_usuario", referencedColumnName = "id_usuario")
	private Usuario usuario;
	@Column(name = "texto_comment")
	private String texto;
	@OneToOne 
	@JoinColumn(name = "fk_id_post", referencedColumnName = "id_post")
	private Post post;
	
}
