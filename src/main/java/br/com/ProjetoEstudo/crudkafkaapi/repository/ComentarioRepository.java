package br.com.ProjetoEstudo.crudkafkaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ProjetoEstudo.crudkafkaapi.model.Comentario;
@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {

}
