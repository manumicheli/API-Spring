package br.com.neurotech.api.controller;

import br.com.neurotech.api.DTO.UsuarioDTO;
import br.com.neurotech.api.model.Usuario;
import br.com.neurotech.api.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioDTO.toUsuario();
        String response = userService.registerUser(usuario);

        if (response.startsWith("Erro")) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody UsuarioDTO usuarioDTO) {
        String response = userService.loginUser(usuarioDTO.getEmail(), usuarioDTO.getSenha());
        if (response.startsWith("Erro")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        } else {
            return ResponseEntity.ok(response);
        }
    }

    @GetMapping("/todos")
    public ResponseEntity<List<UsuarioDTO>> getAllUsuarios() {
        List<UsuarioDTO> usuarios = userService.getAllUsuarios().stream()
                .map(UsuarioDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getUsuarioById(@PathVariable Long id) {
        Optional<Usuario> usuarioOptional = userService.getUsuarioById(id);
        return usuarioOptional.map(usuario -> ResponseEntity.ok(new UsuarioDTO(usuario)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUsuario(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioDTO.toUsuario();
        String response = userService.atualizarUsuario(id, usuario);

        if (response.startsWith("Erro")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            return ResponseEntity.ok(response);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUsuario(@PathVariable Long id) {
        String response = userService.deleteUsuario(id);
        if (response.startsWith("Erro")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            return ResponseEntity.ok(response);
        }
    }
}
