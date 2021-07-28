package net.guides.springboot2.springboot2jpacrudexample.security;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
//@EnableAutoConfiguration
//@EnableWebSecurity
public class SecurityConfig
//        extends WebSecurityConfigurerAdapter
{

    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user")
                .password("pass")
                .roles("USER")
                .and()
                .withUser("act")
                .password("act")
                .roles("ADMIN");
    }

    @Bean
    protected PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/secure").hasRole("ADMIN")
                .antMatchers("/secure/**").hasRole("ADMIN")
                .antMatchers("**").hasRole("USER")
                .antMatchers("/")
                .permitAll()
                .and().formLogin()
                .and().csrf().disable();
    }*/
}
