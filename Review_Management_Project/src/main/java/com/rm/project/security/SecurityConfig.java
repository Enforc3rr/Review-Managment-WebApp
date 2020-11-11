package com.rm.project.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	DataSource dataSource;
	@Autowired
	BCryptPasswordEncoder bcrypt;
	
	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder
		.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select username , password , enabled from user_entity where username = ?")
		.authoritiesByUsernameQuery("select username , user_role from user_entity where username  = ?")
		.passwordEncoder(bcrypt);
	}
	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/user/signup").permitAll()
		.antMatchers("/book/viewbooks").hasAuthority("USER")
		.antMatchers("/book/addbook").hasAuthority("USER")
		.antMatchers("/review","/review/**").hasAuthority("USER")
		.and()
		.formLogin()
		.defaultSuccessUrl("/user/signup")
		.permitAll();
		
		httpSecurity.csrf().disable();
		httpSecurity.headers().frameOptions().disable();
		
	}
	

}
