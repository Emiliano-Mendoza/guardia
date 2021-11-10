package com.practicasupervisada.guardia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.practicasupervisada.guardia.service.impl.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserService userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth)
      throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bcrypt);
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	//http.authorizeRequests().antMatchers("/").permitAll().and().csrf().disable();;
        //http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
    	/*
    	http.csrf().disable().httpBasic()
    				.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    				.and().authorizeRequests()
    				.antMatchers("api/usuario").hasAuthority("ADMIN")
    				.antMatchers("/**").permitAll()
    				.anyRequest().authenticated();  */
    				 
    	http.authorizeRequests()
    							.antMatchers("/**").authenticated()	
    							.antMatchers("api/personal").hasRole("USER")
    							.antMatchers("api/usuario").hasRole("ADMIN")
    							.and().csrf().disable().httpBasic().and().logout(); 

    							
    }
	
}
