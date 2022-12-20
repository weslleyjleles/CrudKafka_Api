package br.com.ProjetoEstudo.crudkafkaapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.ProjetoEstudo.crudkafkaapi.repository.PostRepository;

@RestController
public class PostController {
	@Autowired
	private PostRepository repositoryPost;

	@GetMapping(value = "/publicacao/{idPublicacao}")
	public ResponseEntity<?> getPublicacao(@PathVariable(value = "idPublicacao") Integer idPublicacao) {
		return ResponseEntity.status(HttpStatus.OK).body(repositoryPost.findById(idPublicacao));

	}
}
