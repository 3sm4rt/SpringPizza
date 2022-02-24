package hu.citec.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
@EnableWebSecurity
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	   @Autowired
	    private DataSource datasource;

	 

	    @Autowired
	    private CustomAccessDeniedHandler accessDeniedHandler;

	 

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.authorizeRequests()
	        .antMatchers("/reg").permitAll()
	        .antMatchers("/").permitAll()
	        .antMatchers("/home").permitAll()
	        .antMatchers("/pizzashow").permitAll()
	        .antMatchers("/drinkshow").permitAll()
	        .anyRequest().authenticated()
	        .and()
	        .formLogin()
	            .loginPage("/home")
	            .usernameParameter("username")
	            .passwordParameter("password")
	            .defaultSuccessUrl("/pizzashow", true)
	            .permitAll()
	        .and()
	        .logout()
	        .permitAll()
	        .and().exceptionHandling()
	                .accessDeniedHandler(accessDeniedHandler);
	    }

	 

	    @Autowired
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.jdbcAuthentication().dataSource(datasource)
	                .usersByUsernameQuery("SELECT username, password, 1 as enabled FROM user WHERE username =?")
	                .authoritiesByUsernameQuery("SELECT username, 1 FROM user WHERE username =?");
	    }

	 

	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return NoOpPasswordEncoder.getInstance();
	    }

	 

	    @Bean
	    public DaoAuthenticationProvider authProvider() {
	        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	        authProvider.setUserDetailsService(userDetailsService());
	        authProvider.setPasswordEncoder(passwordEncoder());
	        return authProvider;
	    }
}