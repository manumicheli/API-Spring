package br.com.neurotech.api.Service;

import br.com.neurotech.api.model.Usuario;
import br.com.neurotech.api.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario registerUser(String name, String email, String password, String genero,
            String empresa, String datanascimento) {
        if (userRepository.findByEmail(email).isPresent()) {
            throw new RuntimeException("Email já registrado.");
        }

        Usuario user = new Usuario();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setGenero(genero);
        user.setEmpresa(empresa);
        user.setDatanascimento(datanascimento);

        return userRepository.save(user);
    }

    public Optional<Usuario> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<Usuario> findById(Long id) {
        return userRepository.findById(id);
    }

    public List<Usuario> findAll() {
        return userRepository.findAll();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public Usuario authenticateUser(String email, String password) {
        Optional<Usuario> user = userRepository.findByEmail(email);
        if (user.isPresent() && passwordEncoder.matches(password, user.get().getPassword())) {
            return user.get(); 
        } else {
            throw new RuntimeException("Email ou senha inválidos.");
        }
    }

    public Usuario registerUser(Usuario user) {
        throw new UnsupportedOperationException("Unimplemented method 'registerUser'");
    }
}