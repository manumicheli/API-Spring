package br.com.neurotech.api.controller;

import br.com.neurotech.api.Service.PersonalizacaoService;
import br.com.neurotech.api.model.Personalizacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/personalizacao")
public class PersonalizacaoController {

    @Autowired
    private PersonalizacaoService personalizacaoService;

    @PostMapping("/salvar")
    public ResponseEntity<Personalizacao> salvarPersonalizacao(@RequestBody Personalizacao personalizacao) {
        return new ResponseEntity<>(personalizacaoService.salvarPersonalizacao(personalizacao), HttpStatus.CREATED);
    }

    @GetMapping("/{usuarioId}")
    public ResponseEntity<Personalizacao> buscarPersonalizacao(@PathVariable Long usuarioId) {
        Personalizacao personalizacao = personalizacaoService.buscarPersonalizacao(usuarioId);
        if (personalizacao != null) {
            return ResponseEntity.ok(personalizacao);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
