package br.com.neurotech.api.Repository;

import br.com.neurotech.api.model.Personalizacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalizacaoRepository extends JpaRepository<Personalizacao, Long> {
}
