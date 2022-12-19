package br.com.ProjetoEstudo.crudkafkaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.ProjetoEstudo.crudkafkaapi.model.Like;

@Repository
public interface LikeRepository extends JpaRepository<Like, Integer> {

}
