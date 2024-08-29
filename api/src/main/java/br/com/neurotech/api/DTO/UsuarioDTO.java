package br.com.neurotech.api.DTO;

import br.com.neurotech.api.model.Usuario;
import lombok.AllArgsConstructor;
@AllArgsConstructor
public class UsuarioDTO {
    private String nomecompleto;
    private String email;
    private String senha;
    private String genero;
    private String empresa;
    private String datanascimento;

    
    public String getNomecompleto() {
        return nomecompleto;
    }

    public void setNomecompleto(String nomecompleto) {
        this.nomecompleto = nomecompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(String datanascimento) {
        this.datanascimento = datanascimento;
    }

    
    public Usuario toUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNomecompleto(this.nomecompleto);
        usuario.setEmail(this.email);
        usuario.setSenha(this.senha);
        usuario.setGenero(this.genero);
        usuario.setEmpresa(this.empresa);
        usuario.setDatanascimento(this.datanascimento);
        return usuario;
    }

    
    public UsuarioDTO(Usuario usuario) {
        this.nomecompleto = usuario.getNomecompleto();
        this.email = usuario.getEmail();
        this.genero = usuario.getGenero();
        this.empresa = usuario.getEmpresa();
        this.datanascimento = usuario.getDatanascimento();
    }
}
