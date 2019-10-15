/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.belrose.belrose_security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author Ngnawen
 */
@Configuration //Pour que cette classe soit scanner et interpreter au demarrage de l'application
@EnableWebSecurity //pour que les configuration faites ci-dessous fonctionne
@EnableGlobalMethodSecurity(securedEnabled = true) //Pour Spring prenne en consideration l'anotation @Secured. C'est une strategie de spring security de proteger les methodes
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // Methode de configuration des utilisateur
    @Autowired
    public void globalConfig(AuthenticationManagerBuilder auth) throws Exception {
        //Utilisation en memoire cas des utilisateurs pas trop variable
        auth.inMemoryAuthentication().withUser("admin").password("{noop}123").roles("ADMIN", "PROF"); //{noop}
        auth.inMemoryAuthentication().withUser("prof").password("{noop}123").roles("PROF");
        auth.inMemoryAuthentication().withUser("etudiant").password("{noop}123").roles("ETUDIANT");
        auth.inMemoryAuthentication().withUser("scolarite").password("{noop}123").roles("SCOLARITE");

    }

    //Methode pour definir les ressources à proteger
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //Design pattern Builder avec les points points 
        http
            .csrf().disable()
            .authorizeRequests()
                .anyRequest()
                    .authenticated() //indique que toutes les requetes doivent etre authentifier meme le formulaire d'authentification
                        .and()
                .formLogin()
                    .loginPage("/login") //Redirection dans le cas contraire
                    .permitAll() //Donner l'authorisation d'accès au formulaire
                .defaultSuccessUrl("/index.html");//page par defaut

    }

}
