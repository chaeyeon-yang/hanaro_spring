package com.hana.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@AllArgsConstructor
public class SecurityConfig  {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //CSRF, CORS
        http.csrf((csrf) -> csrf.disable());
        //http.cors(Customizer.withDefaults());

        // CORS 제한 해지
        // String Security 추가시 제한이 많기 때문에 해제해줌.
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin(CorsConfiguration.ALL);
        configuration.addAllowedMethod(CorsConfiguration.ALL);
        configuration.addAllowedHeader(CorsConfiguration.ALL);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // CORS 제한 풀어줌
        source.registerCorsConfiguration("/**,/chbot", configuration);
        // 권한 규칙 작성
        http.authorizeHttpRequests(authorize -> authorize
                        //@PreAuthrization을 사용할 것이기 때문에 모든 경로에 대한 인증처리는 Pass
                        // 제한 없이도 모든 접속 허용
                        .anyRequest().permitAll()
//                        .anyRequest().authenticated()
        );
        return http.build();
    }


}