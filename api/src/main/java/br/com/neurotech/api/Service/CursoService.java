package br.com.neurotech.api.Service;

import br.com.neurotech.api.Repository.CursoRepository;
import br.com.neurotech.api.Repository.UserRepository;
import br.com.neurotech.api.model.Cursos;
import br.com.neurotech.api.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private UserRepository userRepository;

    // Método de criação de cursos
    public Cursos criarCurso(Cursos curso) {
        return cursoRepository.save(curso); // O método agora é de instância
    }

   
    // Listar todos os cursos disponíveis
    public List<Cursos> listarCursosDisponiveis() {
        return cursoRepository.findAll();
    }

    // Usuário escolhe um curso para adicionar à sua lista de cursos
    
    public String escolherCurso(Long usuarioId, Long cursoId) {
        Optional<Usuario> usuarioOptional = userRepository.findById(usuarioId);
        Optional<Cursos> cursoOptional = cursoRepository.findById(cursoId);

        if (usuarioOptional.isPresent() && cursoOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            Cursos curso = cursoOptional.get();

            // Adiciona o curso à lista de cursos do usuário
            ((List<Cursos>) usuario.getCursos()).add(curso);
            userRepository.save(usuario);

            return "Curso adicionado com sucesso ao usuário.";
        } else {
            return "Erro: Usuário ou curso não encontrado.";
        }
    }

    /**
     * Retrieves the list of courses associated with the specified user.
     *
     * @param usuarioId The ID of the user for which to retrieve the list of courses.
     * @return The list of courses associated with the user, or null if the user is not found.
     */
    public java.util.List<Cursos> listarCursosDoUsuario(Long usuarioId) {
        Optional<Usuario> usuarioOptional = userRepository.findById(usuarioId);
        if (usuarioOptional.isPresent()) {
            return usuarioOptional.get().getCursos();
        }
        return null;
    }
}
