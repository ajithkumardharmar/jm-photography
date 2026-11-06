package com.jmphotography.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
public class SecurityConfig {
 @Value("${ADMIN_USERNAME:admin}") private String username;
 @Value("${ADMIN_PASSWORD:ChangeMe123!}") private String password;
 @Bean PasswordEncoder passwordEncoder(){ return new BCryptPasswordEncoder(); }
 @Bean UserDetailsService userDetailsService(PasswordEncoder encoder){ return new InMemoryUserDetailsManager(User.withUsername(username).password(encoder.encode(password)).roles("ADMIN").build()); }
 @Bean SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
  return http.authorizeHttpRequests(a->a.requestMatchers("/", "/about", "/services", "/portfolio", "/contact", "/enquiry", "/css/**", "/js/**", "/images/**", "/error").permitAll().requestMatchers("/admin/login", "/admin/login?error=true").permitAll().requestMatchers("/admin/**").hasRole("ADMIN").anyRequest().permitAll())
   .formLogin(f->f.loginPage("/admin/login").loginProcessingUrl("/admin/login").defaultSuccessUrl("/admin",true).failureUrl("/admin/login?error=true").permitAll())
   .logout(l->l.logoutUrl("/admin/logout").logoutSuccessUrl("/").permitAll()).build();
 }
}
