package br.com.neurotech.api.Repository;


import br.com.neurotech.api.model.Cursos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Cursos, Long> {
}