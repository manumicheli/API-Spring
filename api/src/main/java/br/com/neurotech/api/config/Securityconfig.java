package br.com.neurotech.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class Securityconfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())  // Desabilita CSRF 
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/api/users/register", "/api/users/login").permitAll()  // Permite acesso sem autenticação
                .anyRequest().authenticated()  // Exige autenticação para outras requisições
            )
            .formLogin(formLogin -> formLogin
                .loginPage("/login")  // Página de login customizada
                .permitAll()
            )
            .logout(logout -> logout.permitAll());  //  logout

        return http.build();
    }
}
