package br.com.neurotech.api.Service;
import br.com.neurotech.api.model.User;
import br.com.neurotech.api.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.Optional;

@Service
public class UserService {
   

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    public User registerUser(String name, String email, String password, String genero, String empresa, String datanascimento) {
        if (userRepository.findByEmail(email).isPresent()) {
            throw new RuntimeException("Email já registrado.");
        }

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(bcryptEncoder.encode(password));
        user.setGenero(genero);
        user.setEmpresa(empresa);
        user.setDatanascimento(datanascimento);

        return userRepository.save(user);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User authenticateUser(String email, String password) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent() && bcryptEncoder.matches(password, user.get().getPassword())) {
            return user.get();  // Usuário autenticado com sucesso
        } else {
            throw new RuntimeException("Email ou senha inválidos.");
        }
}

    public User registerUser(User user) {
       
        throw new UnsupportedOperationException("Unimplemented method 'registerUser'");
    }
}