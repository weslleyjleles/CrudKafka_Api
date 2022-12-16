package br.com.ProjetoEstudo.crudkafkaapi.repository;

import br.com.ProjetoEstudo.crudkafkaapi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{            //Entidade e tipo da PK

}
