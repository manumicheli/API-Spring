package br.com.neurotech.api.DTO;

import br.com.neurotech.api.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
public class UsuarioDTO {
    private Long id;
    private String nomecompleto;
    private String email;
    private String senha;
    private String genero;
    private String empresa;
    private String datanascimento;

   
    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId(); // Inclui o ID
        this.nomecompleto = usuario.getNomecompleto();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
        this.genero = usuario.getGenero();
        this.empresa = usuario.getEmpresa();
        this.datanascimento = usuario.getDatanascimento();
    }

    
    public Usuario toUsuario() {
        Usuario usuario = new Usuario();
        usuario.setId(this.id); 
        usuario.setNomecompleto(this.nomecompleto);
        usuario.setEmail(this.email);
        usuario.setSenha(this.senha);
        usuario.setGenero(this.genero);
        usuario.setEmpresa(this.empresa);
        usuario.setDatanascimento(this.datanascimento);
        return usuario;
    }
    public UsuarioDTO(String nomecompleto, String email, String senha, String genero, String empresa, String datanascimento) {
       
        this.nomecompleto = nomecompleto;
        this.email = email;
        this.senha = senha;
        this.genero = genero;
        this.empresa = empresa;
        this.datanascimento = datanascimento;
    }
}
