package br.com.neurotech.api.controller;

import br.com.neurotech.DTO.LoginDTO;
import br.com.neurotech.DTO.RegistroDto;
import br.com.neurotech.api.model.Usuario;
import br.com.neurotech.api.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegistroDto registroDto) {
        Usuario usuario = registroDto.toUsuario(); // Converte DTO para entidade
        String response = userService.registerUser(usuario);

       
        if (response.startsWith("Erro")) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginDTO loginDto) {
        String response = userService.loginUser(loginDto.getEmail(), loginDto.getSenha());
        if (response.startsWith("Erro")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        } else {
            return ResponseEntity.ok(response);
        }
    }
}