package br.com.neurotech.api.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import br.com.neurotech.api.DTO.UsuarioDTO;



@Controller
public class PageController { 
    

    
    @GetMapping("/")
    public String index() {
        return "index"; 
    }

    
    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("usuarioDTO", new UsuarioDTO("","","","","","") );
        return "cadastro"; 
    }

    
    @GetMapping("/login")
    public String login() {
        return "login"; 
    }

    
    @GetMapping("/personalizacao-de-cor")
    public String personalizacaoDeCor() {
        return "p ersonalizaçaodecor"; 
    }

   
    @GetMapping("/personalizacao-de-fonte")
    public String personalizacaoDeFonte() {
        return "personalizaçaodefonte"; 
    }

    @GetMappin("/"trilhadeensino)
    public ModelAndViewodel trilhadeensino(){
        ModelAndView mav = new ModelAndView ("trilhadeensino");
        mav.addObjeto ("mensagem", "trilha de ensino");
        return mav;
    }

    @GetMapping("/cursos")
    public ModelAndView cursos() {
    ModelAndView mav = new ModelAndView("cursos"); 
    mav.addObject("mensagem", "Bem-vindo ao curso de Neurotech!"); 
    return mav;
    }
}
