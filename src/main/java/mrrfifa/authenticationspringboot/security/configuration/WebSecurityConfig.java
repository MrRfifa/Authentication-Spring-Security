package mrrfifa.authenticationspringboot.security.configuration;

import lombok.AllArgsConstructor;
import mrrfifa.authenticationspringboot.appuser.AppUserService;
import mrrfifa.authenticationspringboot.security.PasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfig {

    private final AppUserService appUserService;
    private final PasswordEncoder passwordEncoder;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/api/v*/registration/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();
        return http.build();
    }

//    @Bean
//    public EmbeddedLdapServerContextSourceFactoryBean contextSourceFactoryBean() {
//        EmbeddedLdapServerContextSourceFactoryBean contextSourceFactoryBean =
//                EmbeddedLdapServerContextSourceFactoryBean.fromEmbeddedLdapServer();
//        contextSourceFactoryBean.setPort(0);
//        return contextSourceFactoryBean;
//    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(AuthenticationManagerBuilder authenticationManagerBuilder){
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder.bCryptPasswordEncoder());
        provider.setUserDetailsService(appUserService);
        authenticationManagerBuilder.authenticationProvider(provider);
        return (provider);
    }
}
