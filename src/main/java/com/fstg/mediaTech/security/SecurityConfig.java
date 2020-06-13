package com.fstg.mediaTech.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.Md4PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource datasource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		// TODO Auto-generated method stub
//		super.configure(auth);
		auth.inMemoryAuthentication().withUser("admin").password("{noop}1234").roles("USER", "ADMIN");
		auth.inMemoryAuthentication().withUser("user").password("{noop}1234").roles("USER");
//		auth.jdbcAuthentication().dataSource(datasource)
//				.usersByUsernameQuery(
//						"select user_name as principal,password as credentials from users where user_name=?")
//				.authoritiesByUsernameQuery("select user_name as principal,role as role from users where user_name=?")
//				.rolePrefix("ROLE_");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
//		super.configure(http);
		http.formLogin();
		http.authorizeRequests().antMatchers("/user/*").hasRole("USER");
		http.authorizeRequests().antMatchers("/admin/*").hasRole("ADMIN");
		// if accesse denied return page 403
		http.exceptionHandling().accessDeniedPage("/403");
	}

}
