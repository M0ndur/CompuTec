
package com.compuTec;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
       //El siguiente método funciona para hacer la autenticación del usuario en memoria
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("admin")
                    .password("{noop}123")
                    .roles("ADMIN","VENDEDOR","USER")
                .and()
                
                .withUser("user")
                    .password("{noop}123")
                    .roles("USER")
        .and()
                .withUser("pedro")
                    .password("{noop}123")
                    .roles("USER");
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/producto/nuevo",        "/producto/guardar", 
                             "/producto/modificar/**", "/producto/eliminar/**",
                             "/categoria/nuevo",       "/categoria/guardar",
                             "/categoria/modificar/**","/categoria/eliminar/**",
                             "/cliente/nuevo",         "/cliente/guardar",  
                             "/cliente/modificar/**",  "/cliente/eliminar/**",
                             "/usuario/listado",  
                             "/usuario/nuevo",         "/usuario/guardar",  
                             "/usuario/modificar/**",  "/usuario/eliminar/**")
                    .hasRole("ADMIN")
                .antMatchers("/producto/listado", "/categoria/listado",
                             "/cliente/listado")
                    .hasAnyRole("ADMIN","VENDEDOR")
                .antMatchers("/producto/listado", "/categoria/listado",
                             "/cliente/listado", "/perfil")
                    .hasAnyRole("USER","VENDEDOR","ADMIN")
                .and()
                    .formLogin()
                    .loginPage("/login")
                .and()
                    .exceptionHandling().accessDeniedPage("/errores/403");
    } 

}

// noop - no encriptar ontraseña