package br.com.neurotech.api.controller;

import br.com.neurotech.api.Service.CursoService;
import br.com.neurotech.api.model.Cursos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    // Endpoint para criar um novo curso
    @PostMapping("/criar")
    public ResponseEntity<Cursos> criarCurso(@RequestBody Cursos curso) {
        Cursos novoCurso = cursoService.criarCurso(curso);
        return new ResponseEntity<>(novoCurso, HttpStatus.CREATED);
    }

    // Endpoint para listar cursos disponíveis
    @GetMapping("/disponiveis")
    public ResponseEntity<List<Cursos>> listarCursosDisponiveis() {
        return ResponseEntity.ok(cursoService.listarCursosDisponiveis());
    }

    // Endpoint para o usuário escolher um curso
    @PostMapping("/{usuarioId}/escolher/{cursoId}")
    public ResponseEntity<String> escolherCurso(@PathVariable Long usuarioId, @PathVariable Long cursoId) {
        String response = cursoService.escolherCurso(usuarioId, cursoId);
        if (response.startsWith("Erro")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            return ResponseEntity.ok(response);
        }
    }

    // Endpoint para listar os cursos que o usuário escolheu
    @GetMapping("/{usuarioId}/meus-cursos")
    public ResponseEntity<List<Cursos>> listarCursosDoUsuario(@PathVariable Long usuarioId) {
        List<Cursos> cursos = cursoService.listarCursosDoUsuario(usuarioId);
        if (cursos != null) {
            return ResponseEntity.ok(cursos);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }}
