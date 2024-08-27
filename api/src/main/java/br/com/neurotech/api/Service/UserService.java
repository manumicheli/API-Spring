package br.com.neurotech.api.Service;

import br.com.neurotech.api.model.Usuario;
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
    private BCryptPasswordEncoder passwordEncoder;

    public String registerUser(Usuario usuario) {
        Optional<Usuario> existingUser = userRepository.findByEmail(usuario.getEmail());
        if (existingUser.isPresent()) {
            return "Erro: Email já registrado.";
        }

        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        userRepository.save(usuario);
        return "Usuário registrado com sucesso.";
    }

    public String loginUser(String email, String senha) {
        Optional<Usuario> user = userRepository.findByEmail(email);
        if (user.isPresent() && passwordEncoder.matches(senha, user.get().getSenha())) {
            return "Login bem-sucedido.";
        }
        return "Erro: Email ou senha inválidos.";
    }

    public List<Usuario> getAllUsuarios() {
        return userRepository.findAll();
    }

    public Optional<Usuario> getUsuarioById(Long id) {
        return userRepository.findById(id);
    }

    public String atualizarUsuario(Long id, Usuario usuarioAtualizado) {
        Optional<Usuario> usuarioOptional = userRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            Usuario usuarioExistente = usuarioOptional.get();

            
            if (usuarioAtualizado.getNomecompleto() != null && !usuarioAtualizado.getNomecompleto().isEmpty()) {
                usuarioExistente.setNomecompleto(usuarioAtualizado.getNomecompleto());
            }

            if (usuarioAtualizado.getEmail() != null && !usuarioAtualizado.getEmail().isEmpty()) {
                usuarioExistente.setEmail(usuarioAtualizado.getEmail());
            }

            if (usuarioAtualizado.getSenha() != null && !usuarioAtualizado.getSenha().isEmpty()) {
                usuarioExistente.setSenha(passwordEncoder.encode(usuarioAtualizado.getSenha()));
            }

            if (usuarioAtualizado.getGenero() != null && !usuarioAtualizado.getGenero().isEmpty()) {
                usuarioExistente.setGenero(usuarioAtualizado.getGenero());
            }

            if (usuarioAtualizado.getEmpresa() != null && !usuarioAtualizado.getEmpresa().isEmpty()) {
                usuarioExistente.setEmpresa(usuarioAtualizado.getEmpresa());
            }

            if (usuarioAtualizado.getDatanascimento() != null && !usuarioAtualizado.getDatanascimento().isEmpty()) {
                usuarioExistente.setDatanascimento(usuarioAtualizado.getDatanascimento());
            }

            userRepository.save(usuarioExistente);
            return "Usuário atualizado com sucesso.";
        } else {
            return "Erro: Usuário não encontrado.";
        }
    }

    public String deleteUsuario(Long id) {
        Optional<Usuario> usuarioOptional = userRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            userRepository.deleteById(id);
            return "Usuário deletado com sucesso.";
        } else {
            return "Erro: Usuário não encontrado.";
        }
    }
}
