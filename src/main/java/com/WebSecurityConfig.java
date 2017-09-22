package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http

                .formLogin()
                .loginPage("/login");
        http





                .csrf().disable()

                .httpBasic()

                .and()
                .authorizeRequests()
               //.antMatchers("/**").permitAll()
               .antMatchers("/index.html", "/login.html", "/","/signup.html","/addUser").permitAll()
                .anyRequest().authenticated()
                .and()

                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/");
                /*
        .httpBasic()

                .and()
                .authorizeRequests()
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated();
*/






    }
}