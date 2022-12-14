package com.dxc.learntoday.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.dxc.learntoday.filter.JwtFilter;
import com.dxc.learntoday.service.TrainerService;
import com.dxc.learntoday.utill.JwtUtil;

@SuppressWarnings("deprecation")
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	TrainerService service;
	
	@Autowired
	JwtFilter jwtFilter;
	
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(service);
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManager();
    }

	
	   @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.csrf()
	        	.disable()
	        	.authorizeRequests()
	        	.antMatchers("/authenticate","/h2-console","/v2/api-docs",
	        	        "/swagger-resources/**",
	        	        "/swagger-ui.html**",
	        	        "/webjars/**")
	            .permitAll()
	            .anyRequest()
	            .authenticated().and()
	            .exceptionHandling().and()
	            .sessionManagement()
	            .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

	        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);;
	    }
	    
	    @Override
	    public void configure(WebSecurity web) throws Exception {
	        web
	            .ignoring()
	            .antMatchers("/h2-console/**");
	    }

}
