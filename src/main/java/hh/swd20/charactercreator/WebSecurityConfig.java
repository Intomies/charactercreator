package hh.swd20.charactercreator;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import hh.swd20.charactercreator.web.UserDetailServiceImpl;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailServiceImpl userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.cors()
				.and()
		.authorizeRequests()
			.antMatchers("/css/**")
				.permitAll() // Enable css when logged out
				.and()
		.authorizeRequests()
		    .anyRequest()
		        .authenticated()
		        .and()
        .authorizeRequests()
        	.antMatchers("/editchar/{id}", "/deletechar/{id}", "/addownarmor", 
        				"/editarmor/{id}", "/deletearmor/{id}", "/addownrace",
        				"/editrace/{id}", "/deleterace/{id}")
        	.hasAuthority("ADMIN")
        		.and()
		.authorizeRequests()
			.antMatchers("/h2-console/**")
				.permitAll()
		        .and()
		    .csrf()
		    	.ignoringAntMatchers("/h2-console/**")
		        .and()
		    .headers()
		    	.frameOptions()
		    	.sameOrigin()
		        .and()
		.formLogin()
			.loginPage("/login")
				.defaultSuccessUrl("/index")
				.permitAll()
				.and()
		.logout()
				.permitAll();
	}
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
		configuration.setAllowedMethods(Arrays.asList("GET","POST"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

@Autowired
public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

}
