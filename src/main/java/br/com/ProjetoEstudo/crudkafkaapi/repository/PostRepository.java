package br.com.ProjetoEstudo.crudkafkaapi.repository;

import br.com.ProjetoEstudo.crudkafkaapi.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> { //Entidade e tipo da PK
}
