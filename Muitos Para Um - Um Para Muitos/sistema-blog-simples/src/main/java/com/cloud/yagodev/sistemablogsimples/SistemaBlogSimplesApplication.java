package com.cloud.yagodev.sistemablogsimples;

import com.cloud.yagodev.sistemablogsimples.model.Autor;
import com.cloud.yagodev.sistemablogsimples.model.Post;
import com.cloud.yagodev.sistemablogsimples.repositories.AutorRepository;
import com.cloud.yagodev.sistemablogsimples.repositories.PostRepository;
import com.cloud.yagodev.sistemablogsimples.services.AutorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SistemaBlogSimplesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SistemaBlogSimplesApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(AutorRepository autorRepository, PostRepository postRepository) {
        return args -> {
            // Criar autor
            Autor autor = new Autor();
            autor.setNome("Yago Dev");

            // Criar posts
            Post post1 = new Post();
            post1.setTitulo("Primeiro post do Yago");
            post1.setConteudo("O Senhor é meu pastor, de nada tenho falta.");
            post1.setAutor(autor);

            Post post2 = new Post();
            post2.setTitulo("Segundo post do Yago");
            post2.setConteudo("Grande é o Senhor e mui digno de louvor.");
            post2.setAutor(autor);

            // Associar posts ao autor
            autor.getPosts().add(post1);
            autor.getPosts().add(post2);

            // Salvar no banco
            autorRepository.save(autor);
            postRepository.save(post1);
            postRepository.save(post2);
            System.out.println(">>> Autor e posts inseridos com sucesso!");
        };

    }
}
