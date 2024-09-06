package br.com.neurotech.api.Service;

import br.com.neurotech.api.Repository.PersonalizacaoRepository;
import br.com.neurotech.api.model.Personalizacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalizacaoService {

    @Autowired
    private PersonalizacaoRepository personalizacaoRepository;

    public Personalizacao salvarPersonalizacao(Personalizacao personalizacao) {
        return personalizacaoRepository.save(personalizacao);
    }

    public Personalizacao buscarPersonalizacao(Long usuarioId) {
        return personalizacaoRepository.findById(usuarioId).orElse(null);
    }
}
